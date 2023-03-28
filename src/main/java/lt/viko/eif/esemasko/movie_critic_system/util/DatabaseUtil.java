package lt.viko.eif.esemasko.movie_critic_system.util;

import jakarta.xml.bind.JAXBException;
import lt.viko.eif.esemasko.movie_critic_system.model.Movie;
import lt.viko.eif.esemasko.movie_critic_system.model.MovieList;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * This class has two methods: uploadToDatabase and getFromDatabase
 *
 * @version 1.0
 * @since 1.0
 */
public class DatabaseUtil {
    /**
     * This is a uploadToDatabase method
     * <p>
     * This method uploads movieList Movie objects into MySQL database.
     *
     * @param movieList - list of Movie objects.
     */
    public static void uploadToDatabase(MovieList movieList) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            for (Movie movie : movieList.getMovieList())
                session.save(movie);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * This is a getFromDatabase method
     * <p>
     * This method downloads Plain Old Java Object from MySQL database.
     *
     * @return returns movieList object, or null.
     */
    public static List<Movie> getFromDatabase() {

        MovieList movies = new MovieList();
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Movie> moviesTemp = session.createQuery("from Movie", Movie.class).list();
            movies.setMovieList(moviesTemp);
            return moviesTemp;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            //server.shutdown();
        }
        return null;

    }
}
