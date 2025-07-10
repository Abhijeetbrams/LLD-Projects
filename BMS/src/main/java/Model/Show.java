package Model;

import java.sql.Timestamp;

public class Show {
    private Integer showId;
    private String showName;
    private Timestamp startTime;
    private Timestamp endTime;
    private Screen screen;
    private Movie movie;

    public Show(Integer showId, String showName, Timestamp startTime, Timestamp endTime, Screen screen, Movie movie) {
        this.showId = showId;
        this.showName = showName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.screen = screen;
        this.movie = movie;
    }


}
