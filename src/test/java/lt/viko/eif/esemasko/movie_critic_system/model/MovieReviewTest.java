package lt.viko.eif.esemasko.movie_critic_system.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MovieReviewTest {
    @Test
    public void testSetAndGet() {
        var user = new User(1, "John", "Doe");
        var review = new MovieReview();

        review.setId(1);
        review.setRating(10);
        review.setCriticism("Best movie of all time!");
        review.setUser(user);

        Assert.assertEquals(1, review.getId());
        Assert.assertEquals(10, review.getRating());
        Assert.assertEquals("Best movie of all time!", review.getCriticism());
        Assert.assertEquals(user, review.getUser());
    }

    @Test
    public void testToString() {
        var user = new User(1, "John", "Doe");
        var review = new MovieReview(1, "Best movie of all time!", 10, user);

        assertEquals("\t\tReview:\n\t\t\tRating = 10\n\t\t\tReview = Best movie of all time!\n\t" + "\t\tUser = \tJohn Doe\n", review.toString());
    }
}