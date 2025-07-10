package Model;

import java.util.List;

public class Screen {
    private Integer screenId;
    private FormatType formatType;
    private List<Show> shows;
    private List<Seat> seats;
    private Theatre theatre;

    public Screen(Integer screenId, FormatType formatType, List<Show> shows, List<Seat> seats, Theatre theatre) {
        this.screenId = screenId;
        this.formatType = formatType;
        this.shows = shows;
        this.seats = seats;
        this.theatre = theatre;
    }
}
