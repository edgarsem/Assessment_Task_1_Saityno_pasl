package lt.viko.eif.esemasko.movie_critic_system.model;

import javax.persistence.*;

import jakarta.xml.bind.annotation.*;

import java.util.List;

/**
 * This class stores information about movie.
 * This class has eight parameters: id, name, lastName, genres, directors, writers, cast, reviews.
 *
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @XmlElement(name = "id")
    private int id;
    @XmlElement(name = "title")
    private String title;
    @XmlElement(name = "length")
    private int length;

    @XmlElementWrapper(name = "genres")
    @XmlElement(name = "genre")
    @OneToMany(targetEntity = Genre.class, cascade = CascadeType.ALL)
    private List<Genre> genres;
    @XmlElementWrapper(name = "directors")
    @XmlElement(name = "director")
    @OneToMany(targetEntity = Director.class, cascade = CascadeType.ALL)
    private List<Director> directors;

    @XmlElementWrapper(name = "writers")
    @XmlElement(name = "writer")
    @OneToMany(targetEntity = Writer.class, cascade = CascadeType.ALL)
    private List<Writer> writers;

    @XmlElementWrapper(name = "cast")
    @XmlElement(name = "actor")
    @OneToMany(targetEntity = Actor.class, cascade = CascadeType.ALL)
    private List<Actor> cast;

    @XmlElementWrapper(name = "reviews")
    @XmlElement(name = "review")
    @OneToMany(targetEntity = MovieReview.class, cascade = CascadeType.ALL)
    private List<MovieReview> reviews;

    /**
     * Constructor for Movie class.
     */
    public Movie() {

    }

    /**
     * Setter for movies id
     *
     * @param id - movies id in MovieList object
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Setter for movies title
     *
     * @param title - movies title in MovieList object
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Setter for movies length
     *
     * @param length - movies length in MovieList object
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * Setter for movies genres
     *
     * @param genres - movies genres list in MovieList object
     */
    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    /**
     * Setter for movies directors
     *
     * @param directors - movies directors list in MovieList object
     */
    public void setDirectors(List<Director> directors) {
        this.directors = directors;
    }

    /**
     * Setter for movies writers
     *
     * @param writers - movies writers list in MovieList object
     */
    public void setWriters(List<Writer> writers) {
        this.writers = writers;
    }

    /**
     * Setter for movies cst
     *
     * @param cast - movies actors list in MovieList object
     */
    public void setCast(List<Actor> cast) {
        this.cast = cast;
    }

    /**
     * Setter for movies reviews
     *
     * @param reviews - movies reviews list in MovieList object
     */
    public void setReviews(List<MovieReview> reviews) {
        this.reviews = reviews;
    }

    /**
     * Constructor for Movie class with id, title, length, cast, genres, directors, writers arguments.
     *
     * @param id        - movie id in MovieList object
     * @param title     - movie title in MovieList object
     * @param length    - movie length in MovieList object
     * @param cast      - movie cast in MovieList object
     * @param genres    - movie genres in MovieList object
     * @param directors - movie directors in MovieList object
     * @param writers   - movie writers in MovieList object
     */
    public Movie(int id, String title, int length, List<Actor> cast, List<Genre> genres, List<Director> directors, List<Writer> writers) {
        this.id = id;
        this.title = title;
        this.length = length;
        this.cast = cast;
        this.genres = genres;
        this.directors = directors;
        this.writers = writers;
    }

    /**
     * Constructor for Movie class with title, length, cast, genres, directors, writers arguments.
     *
     * @param title     - movie title in MovieList object
     * @param length    - movie length in MovieList object
     * @param cast      - movie cast in MovieList object
     * @param genres    - movie genres in MovieList object
     * @param directors - movie directors in MovieList object
     * @param writers   - movie writers in MovieList object
     */
    public Movie(String title, int length, List<Actor> cast, List<Genre> genres, List<Director> directors, List<Writer> writers) {
        this.title = title;
        this.length = length;
        this.cast = cast;
        this.genres = genres;
        this.directors = directors;
        this.writers = writers;
    }

    @Override
    public String toString() {
        return String.format("\nMovie:\n\t" + "Title = %s\n\t" + "Length = %s minutes\n" + "\tGenres: \n\t%s\n" + "\tDirectors: \n\t%s\n" + "\tWriters: \n\t%s\n" + "\tCast: \n\t%s\n" + "\tReviews: \n\t%s\n", this.title, this.length, this.genres, this.directors, this.writers, this.cast, this.reviews);
    }

}
