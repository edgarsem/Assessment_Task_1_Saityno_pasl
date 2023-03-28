package lt.viko.eif.esemasko.movie_critic_system.model;

import javax.persistence.*;

import jakarta.xml.bind.annotation.XmlType;

/**
 * This class stores information about writers.
 * This class has three parameters: id, name, lastName.
 *
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name = "writer")
@XmlType(propOrder = {"id", "name", "lastName"})
public class Writer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String name;
    private String lastName;

    /**
     * Getter for writers id
     *
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for team id
     *
     * @param id - writers id in Movie object
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter for writers name
     *
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for writers name
     *
     * @param name - writers name in Movie object
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for writers last name
     *
     * @return String
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter for writers last name
     *
     * @param lastName - writers last name in Movie object
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Constructor for Writer class
     */
    public Writer() {

    }

    /**
     * Constructor for Writers class with id, name, lastName arguments.
     *
     * @param id       - writers id in Movie object
     * @param name     - writers name in Movie object
     * @param lastName - writers last name in Movie object
     */
    public Writer(int id, String name, String lastName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
    }

    /**
     * Constructor for Writers class with name, lastName arguments.
     *
     * @param name     - writers name in Movie object
     * @param lastName - writers last name in Movie object
     */
    public Writer(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("\t%s" + " %s", this.name, this.lastName);
    }
}

