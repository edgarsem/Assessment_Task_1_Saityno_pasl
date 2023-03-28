package lt.viko.eif.esemasko.movie_critic_system.model;

import jakarta.xml.bind.annotation.XmlType;

import javax.persistence.*;

/**
 * This class stores information about actors.
 * This class has four parameters: id, name, lastName, age.
 *
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name = "cast")
@XmlType(propOrder = {"id", "name", "lastName", "age"})
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String name;
    private String lastName;
    private int age;


    /**
     * Getter for actors id
     *
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for actors id
     *
     * @param id - actors id in Movie object
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter for actors name
     *
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for actors name
     *
     * @param name - actors name in Movie object
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for actors last name
     *
     * @return String
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter for actors last name
     *
     * @param lastName - actors last name in Movie object
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter for actors age
     *
     * @return int
     */
    public int getAge() {
        return age;
    }

    /**
     * Setter for actors aage
     *
     * @param age - actors age in Movie object
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Constructor for Actor class.
     */
    public Actor() {

    }

    /**
     * Constructor for Actor class with id, name, lastName, age arguments.
     *
     * @param id       - actors id in Movie object
     * @param name     - actors name in Movie object
     * @param lastName - actors last name in Movie object
     * @param age      - actors age in Movie object
     */
    public Actor(int id, String name, String lastName, int age) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    /**
     * Constructor for Actor class with name, lastName, age arguments.
     *
     * @param name     - actors name in Movie object
     * @param lastName - actors last in Movie object
     * @param age      - actors last in Movie object
     */
    public Actor(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("\t%s" + " %s" + ". Age: %s", this.name, this.lastName, this.age);
    }
}
