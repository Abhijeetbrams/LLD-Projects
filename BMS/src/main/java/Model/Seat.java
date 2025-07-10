package Model;

public class Seat {
    private Integer seatId;
    private String seatNumber;
    private Screen screen;
    private SeatType seatType;
    private int column;
    private int row;

    public Seat(Integer seatId, String seatNumber, Screen screen, int column, int row) {
        this.seatId = seatId;
        this.seatNumber = seatNumber;
        this.screen = screen;
        this.seatType = SeatType.REGULAR; // Default value
        this.column = column;
        this.row = row;
    }
}
