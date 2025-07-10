package Model;

import org.apache.logging.log4j.util.Strings;

import java.util.List;

public class Theatre {
    private Integer theatreId;
    private String theatreName;
    private String theatreAddress;
    private List<Screen> screens;

    public Theatre(Integer theatreId, String theatreName, String theatreAddress, List<Screen> screens) {
        this.theatreId = theatreId;
        this.theatreName = theatreName;
        this.theatreAddress = theatreAddress;
        this.screens = screens;
    }
}

