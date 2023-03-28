package lt.viko.eif.esemasko.movie_critic_system.model;


import jakarta.xml.bind.annotation.*;

import java.util.List;

/**
 * This class stores movies list.
 * This class has one parameter: movieList.
 *
 * @version 1.0
 * @since 1.0
 */
@XmlRootElement(name = "Movies")
@XmlAccessorType(XmlAccessType.FIELD)
public class MovieList {


    @XmlElement(name = "movie")
    private List<Movie> movieList;

    /**
     * Constructor for MovieList class.
     */
    public MovieList() {

    }

    /**
     * Getter for movie list.
     *
     * @return list of movies
     */
    public List<Movie> getMovieList() {
        return movieList;
    }

    /**
     * Setter for movie list
     *
     * @param movieList - movie list
     */
    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    /**
     * Constructor for MovieList class with movieList arguments.
     *
     * @param movieList - movies list.
     */
    public MovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    @Override
    public String toString() {
        return String.format("Movie list: %s\n\t", this.movieList);
    }
}
