package lt.viko.eif.esemasko.movie_critic_system.model;

import javax.persistence.*;

import jakarta.xml.bind.annotation.XmlType;

/**
 * This class stores information about users.
 * This class has three parameters: id, name, lastName.
 *
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name = "user")
@XmlType(propOrder = {"id", "name", "lastName"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String name;
    private String lastName;

    /**
     * Getter for users name
     *
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for users name
     *
     * @param name - users name in MovieReview object
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for users last name
     *
     * @return String
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter for users name
     *
     * @param lastName - users last name in MovieReview object
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter for users id
     *
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for users id
     *
     * @param id - users id in MovieReview object
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Constructor for User class
     */
    public User() {

    }

    /**
     * Constructor for User class with id, name, lastName arguments.
     *
     * @param id       - users id in User object
     * @param name     - users name in User object
     * @param lastName - users last name in User object
     */
    public User(int id, String name, String lastName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
    }

    /**
     * Constructor for User class with name, lastName arguments.
     *
     * @param name     - users name in User object
     * @param lastName - users last name in User object
     */
    public User(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("\t%s" + " %s", this.name, this.lastName);
    }
}
