package lt.viko.eif.esemasko.movie_critic_system.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DirectorTest {
    @Test
    public void testSetAndGet() {
        var director = new Director();

        director.setId(1);
        director.setName("Quentin");
        director.setLastName("Tarantino");

        Assert.assertEquals(1, director.getId());
        Assert.assertEquals("Quentin", director.getName());
        Assert.assertEquals("Tarantino", director.getLastName());
    }

    @Test
    public void testToString() {
        var director = new Director(1, "Quentin", "Tarantino");
        assertEquals("\tQuentin Tarantino", director.toString());
    }
}