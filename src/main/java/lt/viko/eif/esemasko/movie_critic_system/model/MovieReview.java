package lt.viko.eif.esemasko.movie_critic_system.model;

import javax.persistence.*;

import jakarta.xml.bind.annotation.XmlType;

/**
 * This class stores information about reviews.
 * This class has three parameters: id, criticism, rating, user.
 *
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name = "movie_review")
@XmlType(propOrder = {"id", "criticism", "rating", "user"})
public class MovieReview {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String criticism;
    private int rating;
    @ManyToOne(targetEntity = User.class, cascade = CascadeType.ALL)
    private User user;


    /**
     * Getter for reviews id
     *
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for reviews id
     *
     * @param id - reviews id in Movie object
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter for reviews description
     *
     * @return String
     */
    public String getCriticism() {
        return criticism;
    }

    /**
     * Setter for reviews description
     *
     * @param criticism - reviews description in Movie object
     */
    public void setCriticism(String criticism) {
        this.criticism = criticism;
    }

    /**
     * Getter for reviews rating
     *
     * @return int
     */
    public int getRating() {
        return rating;
    }

    /**
     * Setter for reviews rating
     *
     * @param rating - reviews rating in Movie object
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * Getter for reviews user
     *
     * @return User
     */
    public User getUser() {
        return user;
    }

    /**
     * Setter for reviews user
     *
     * @param user - reviews user in Movie object
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Constructor for MovieReview.
     */
    public MovieReview() {

    }

    /**
     * Constructor for MovieReview class with id, review, rating, user arguments.
     *
     * @param id     - reviews id in Movie object
     * @param review - review in Movie object
     * @param rating - users rating in Movie object
     * @param user   - user in Movie object
     */
    public MovieReview(int id, String review, int rating, User user) {
        this.id = id;
        this.criticism = review;
        this.rating = rating;
        this.user = user;
    }

    /**
     * Constructor for MovieReview class with review, rating, user arguments.
     *
     * @param review - review in Movie object
     * @param rating - users rating in Movie object
     * @param user   - user in Movie object
     */
    public MovieReview(String review, int rating, User user) {
        this.criticism = review;
        this.rating = rating;
        this.user = user;
    }

    @Override
    public String toString() {
        return String.format("\t\tReview:\n" + "\t\t\tRating = %s\n\t" + "\t\tReview = %s\n\t" + "\t\tUser = %s\n", this.rating, this.criticism, this.user);
    }
}
