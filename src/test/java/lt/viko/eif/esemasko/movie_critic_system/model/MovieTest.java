package lt.viko.eif.esemasko.movie_critic_system.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MovieTest {
    @Test
    public void testToString() {
        var genre = new Genre(1, "Comedy");
        var director = new Director(1, "Jean-Pierre", "Jeunet");
        var writer = new Writer(1, "Guillaume", "Laurant");
        var actor = new Actor(1, "Audrey", "Tautou", 53);
        var user = new User(1, "John", "Doe");
        var review = new MovieReview(1, "This Movie can CHANGE your life :-)", 10, user);

        var movie = new Movie(1, "Amélie", 122, List.of(actor), List.of(genre), List.of(director), List.of(writer));
        movie.setReviews(List.of(review));


        Assert.assertEquals("\nMovie:\n\t" + "Title = Amélie\n\t" + "Length = 122 minutes\n" + "\tGenres: \n\t[\tComedy ]\n" + "\tDirectors: \n\t[\tJean-Pierre Jeunet]\n" + "\tWriters: \n\t[\tGuillaume Laurant]\n" + "\tCast: \n\t[\tAudrey Tautou. Age: 53]\n" + "\tReviews: \n\t[\t\tReview:\n\t\t\tRating = 10\n\t\t\tReview = This Movie can CHANGE your life :-)\n\t" + "\t\tUser = \tJohn Doe\n]\n", movie.toString());
    }

}