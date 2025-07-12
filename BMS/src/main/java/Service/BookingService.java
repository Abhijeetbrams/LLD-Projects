package Service;

import Model.Booking;
import Model.Show;
import Model.ShowSeatMap;
import Model.User;
import Repository.BookingRepository;
import Repository.ShowRepository;
import Repository.ShowSeatRepository;
import Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Isolation;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import Exception.InvalidShowError;
import Exception.SeatNotAvailableError;
import Exception.UserNotPresentError;
import Enum.BookingStatus;
import Enum.ShowSeatStatus;
import org.springframework.transaction.annotation.Transactional;

public class BookingService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private ShowSeatRepository showSeatRepository;
    @Autowired
    private BookingRepository bookingRepository;


    public Booking bookShow(Integer userId, List<Integer> showSeatIds, Integer showId) throws UserNotPresentError, SeatNotAvailableError, InvalidShowError {

        // Get User from user id
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty()){
            throw new UserNotPresentError("User is not present");
        }
        User user = optionalUser.get();


        // Get show from show id
        Optional<Show> optionalShow = showRepository.findById(showId);
        if(optionalShow.isEmpty()){
            throw new InvalidShowError("Show selected is invalid");
        }

        Show show = optionalShow.get();

        //Reserve the available seats
        List<ShowSeatMap> reservedSeats = reserveSeats(showSeatIds, showId);

        //Create a booking
        Booking booking = createBooking(reservedSeats, user, show);

        // Updating the reserved ShowSeatMap in the database.
        showSeatRepository.saveAll(reservedSeats);

        return booking;
    }
    //Start transaction with isolation level serializable
    //Get show seats from show seat ids
    //Check availability
    // If !AVAILABLE or (LOCKED && Duration of last lock is < 10)
    //    throw Seat not available error
    //Else
    //    Update Locked Status
    //    Update Locked At time
    // End transaction
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public List<ShowSeatMap> reserveSeats(List<Integer> showSeatIds, Integer showId) throws SeatNotAvailableError {

        //Get show seats from show seat ids
        List<ShowSeatMap> showSeats = showSeatRepository.findAllById(showSeatIds);

        //Check if any of the show seat is unavailable
        for(ShowSeatMap showSeat: showSeats){
            seatNotAvaliableForBooking(showSeat);
        }

        //We lock the seats for booking
        List<ShowSeatMap> reservedSeats = new ArrayList<>();
        for(ShowSeatMap showSeat: showSeats){
            if(!showSeat.getShow().getId().equals(showId)){
                continue;
            }
            showSeat.setShowSeatStatus(ShowSeatStatus.LOCKED);
            showSeat.setLockedAt(new Date());
            reservedSeats.add(showSeat);
        }
        return reservedSeats;
    }

    private Double priceCalculator(List<ShowSeatMap> reservedSeats, Show show){
        //Add logic for calculating price
        return 0.0;
    }

    private Booking createBooking(List<ShowSeatMap> reservedSeats, User user, Show show) {
        Booking booking = new Booking();
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setAmountToBePaid(priceCalculator(reservedSeats, show));
        booking.setUser(user);
        booking.setShowSeatMaps(reservedSeats);
        booking.setPayments(new ArrayList<>());

        return bookingRepository.save(booking);
    }


    private void seatNotAvaliableForBooking(ShowSeatMap showSeat) throws SeatNotAvailableError {
        if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.VACANT)){
            if(showSeat.getShowSeatStatus().equals(ShowSeatStatus.OCCUPIED)){
                throw new SeatNotAvailableError("Seat is already booked");
            }
            if(showSeat.getShowSeatStatus().equals(ShowSeatStatus.LOCKED)){
                Long lockedDuration = Duration.between(new Date().toInstant(), showSeat.getLockedAt().toInstant()).toMinutes();
                if(lockedDuration < 10){
                    throw new SeatNotAvailableError("Seat is not available to book");
                }
            }
        }
    }
}
