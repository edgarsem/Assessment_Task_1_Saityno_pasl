package lt.viko.eif.esemasko.movie_critic_system.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GenreTest {
    @Test
    public void testSetAndGet() {
        var genre = new Genre();

        genre.setId(1);
        genre.setCategory("Horror");

        Assert.assertEquals(1, genre.getId());
        Assert.assertEquals("Horror", genre.getCategory());
    }

    @Test
    public void testToString() {
        var genre = new Genre(1, "Horror");
        assertEquals("\tHorror ", genre.toString());
    }
}