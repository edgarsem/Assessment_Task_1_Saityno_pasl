package lt.viko.eif.esemasko.movie_critic_system.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    @Test
    public void testSetAndGet() {
        var user = new User();

        user.setId(1);
        user.setName("John");
        user.setLastName("Doe");

        Assert.assertEquals(1, user.getId());
        Assert.assertEquals("John", user.getName());
        Assert.assertEquals("Doe", user.getLastName());
    }

    @Test
    public void testToString() {
        var user = new User(1, "John", "Doe");
        assertEquals("\tJohn Doe", user.toString());
    }
}