package Model;

import java.util.ArrayList;

public class City {
    private int cityId;
    private String cityName;
    private List<Theatre> theatres;

    public City(int cityId, String cityName, List<Theatre> theatres) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.theatres = new ArrayList<>();
    }
}
