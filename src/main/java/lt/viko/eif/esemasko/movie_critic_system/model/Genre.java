package lt.viko.eif.esemasko.movie_critic_system.model;

import javax.persistence.*;

import jakarta.xml.bind.annotation.XmlType;

/**
 * This class stores information about genres.
 * This class has two parameters: id, category.
 *
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name = "genre")
@XmlType(propOrder = {"id", "category"})
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String category;


    /**
     * Getter for genres id
     *
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for genre id
     *
     * @param id - genre id in Movie object
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter for genres category
     *
     * @return String
     */
    public String getCategory() {
        return category;
    }

    /**
     * Setter for genre category
     *
     * @param category - genre category in Movie object
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Constructor for Genre class.
     */
    public Genre() {

    }

    /**
     * Constructor for Genre class with id, category arguments.
     *
     * @param id       - genre id in Movie object
     * @param category - category in Movie object
     */
    public Genre(int id, String category) {
        this.id = id;
        this.category = category;
    }

    /**
     * Constructor for Genre class with category arguments.
     *
     * @param category - category in Movie object
     */
    public Genre(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return String.format("\t%s ", this.category);
    }
}
