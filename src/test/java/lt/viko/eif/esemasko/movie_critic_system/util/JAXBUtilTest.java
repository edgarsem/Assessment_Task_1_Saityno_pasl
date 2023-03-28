package lt.viko.eif.esemasko.movie_critic_system.util;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import lt.viko.eif.esemasko.movie_critic_system.model.*;
import lt.viko.eif.esemasko.movie_critic_system.model.Writer;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JAXBUtilTest {

    public MovieList createPOJO() {
        var genre = new Genre(1, "Comedy");
        var director = new Director(1, "Jean-Pierre", "Jeunet");
        var writer = new Writer(1, "Guillaume", "Laurant");
        var actor = new Actor(1, "Audrey", "Tautou", 53);
        var user = new User(1, "John", "Doe");
        var review = new MovieReview(1, "This Movie can CHANGE your life :-)", 10, user);

        var movie = new Movie(1, "Amélie", 122, List.of(actor), List.of(genre), List.of(director), List.of(writer));
        movie.setReviews(List.of(review));
        return new MovieList(List.of(movie));
    }

    @Test
    public void testTransformToXML() {
        MovieList movieList = createPOJO();
        try {
            JAXBContext context = JAXBContext.newInstance(MovieList.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);
            OutputStream os = new FileOutputStream("test1.xml");
            marshaller.marshal(movieList, os);
            Assert.assertEquals(Files.readString(Path.of("test.xml")), Files.readString(Path.of("test1.xml")));
        } catch (JAXBException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void transformToPOJO() {
        try {
            JAXBContext context = JAXBContext.newInstance(MovieList.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Path path = Path.of("test.xml");
            String xmlContent = Files.readString(path);
            StringReader reader = new StringReader(xmlContent);
            MovieList movieList = (MovieList) unmarshaller.unmarshal(reader);
            Assert.assertEquals(createPOJO().toString(), movieList.toString());
        } catch (JAXBException | IOException e) {
            throw new RuntimeException(e);
        }

    }

}