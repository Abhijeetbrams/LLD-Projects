package Model;

public class Movie {
    private Integer movieId;
    private String title;
    private String runtime;
    private String genre;
    private List<Actor> actors;
    private double rating;

    public Movie(Integer movieId, String title, String runtime, String genre, List<Actor> actors, double rating) {
        this.movieId = movieId;
        this.title = title;
        this.runtime = runtime;
        this.genre = genre;
        this.actors = actors;
        this.rating = rating;
    }
}
