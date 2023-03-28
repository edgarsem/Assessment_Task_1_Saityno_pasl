package lt.viko.eif.esemasko.movie_critic_system.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WriterTest {

    @Test
    public void testSetAndGet() {
        var writer = new Writer();

        writer.setId(1);
        writer.setName("Woody");
        writer.setLastName("Allen");

        Assert.assertEquals(1, writer.getId());
        Assert.assertEquals("Woody", writer.getName());
        Assert.assertEquals("Allen", writer.getLastName());
    }

    @Test
    public void testToString() {
        var writer = new Writer(1, "Woody", "Allen");
        assertEquals("\tWoody Allen", writer.toString());
    }

}