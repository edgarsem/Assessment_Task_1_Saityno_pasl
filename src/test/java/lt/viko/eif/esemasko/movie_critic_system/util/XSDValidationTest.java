package lt.viko.eif.esemasko.movie_critic_system.util;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class XSDValidationTest {
    @Test
    public void testValidation() {
        XSDValidation validation = new XSDValidation();
        Assert.assertEquals(true, validation.validateXMLSchema(Path.of("moviesXSD.xsd").toString(), Path.of("movies.xml").toString()));
        Assert.assertEquals(false, validation.validateXMLSchema(Path.of("moviesXSD.xsd").toString(), Path.of("generated.xml").toString()));
    }
}