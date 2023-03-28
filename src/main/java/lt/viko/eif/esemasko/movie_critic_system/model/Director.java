package lt.viko.eif.esemasko.movie_critic_system.model;

import jakarta.xml.bind.annotation.XmlType;

import javax.persistence.*;

/**
 * This class stores information about directors.
 * This class has three parameters: id, name, lastName.
 *
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name = "director")
@XmlType(propOrder = {"id", "name", "lastName"})
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String name;
    private String lastName;


    /**
     * Getter for directors id
     *
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for directors id
     *
     * @param id - directors id in Movie object
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter for directors name
     *
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for directors name
     *
     * @param name - directors name in Movie object
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for directors last name
     *
     * @return String
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter for directors last name
     *
     * @param lastName - directors last name in Movie object
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Constructor for Director class.
     */
    public Director() {

    }

    /**
     * Constructor for Director class with id, name, lastName arguments.
     *
     * @param id       - directors id in Movie object
     * @param name     - directors name in Movie object
     * @param lastName - directors last name in Movie object
     */
    public Director(int id, String name, String lastName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
    }

    /**
     * Constructor for Director class with name, lastName arguments.
     *
     * @param name     - directors name in Movie object
     * @param lastName - directors last name in Movie object
     */
    public Director(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("\t%s" + " %s", this.name, this.lastName);
    }
}
