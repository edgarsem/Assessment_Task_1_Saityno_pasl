package lt.viko.eif.esemasko.movie_critic_system;

import lt.viko.eif.esemasko.movie_critic_system.model.*;
import lt.viko.eif.esemasko.movie_critic_system.util.*;


/**
 * This is a HibernateMain class.
 *
 * @author Edgar Semaško
 * @version 1.0
 * @since 1.0
 */
public class HibernateMain {
    /**
     * This is a main method
     * <p>
     * This main method enables and performs download and upload of Plain Old Java Objects from and to MySQL Database.
     *
     * @param `args[]` string array
     * @return void
     */
    public static void main(String[] args) {
        MovieList movies = new MovieList();
        movies.setMovieList(DatabaseUtil.getFromDatabase());
        System.out.println(movies);
        DatabaseUtil.uploadToDatabase(movies);
    }
}
