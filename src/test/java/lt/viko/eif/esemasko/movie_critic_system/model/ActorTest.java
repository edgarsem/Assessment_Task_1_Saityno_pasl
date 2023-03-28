package lt.viko.eif.esemasko.movie_critic_system.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ActorTest {
    @Test
    public void testSetAndGet() {
        var actor = new Actor();

        actor.setId(1);
        actor.setName("Cate");
        actor.setLastName("Blanchett");
        actor.setAge(53);

        Assert.assertEquals(1, actor.getId());
        Assert.assertEquals("Cate", actor.getName());
        Assert.assertEquals("Blanchett", actor.getLastName());
        Assert.assertEquals(53, actor.getAge());
    }

    @Test
    public void testToString() {
        var actor = new Actor(1, "Cate", "Blanchett", 53);
        assertEquals("\tCate Blanchett. Age: 53", actor.toString());
    }

}