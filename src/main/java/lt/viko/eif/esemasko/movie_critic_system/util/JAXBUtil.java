package lt.viko.eif.esemasko.movie_critic_system.util;


import jakarta.xml.bind.Unmarshaller;
import lt.viko.eif.esemasko.movie_critic_system.model.*;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * This class has two methods: transformToXML, transformToPOJO
 *
 * @version 1.0
 * @since 1.0
 */
public class JAXBUtil {
    /**
     * This is a transformToXML method
     * <p>
     * This method marshalls movieList object into XML format.
     *
     * @param movieList - path to XML file.
     * @throws JAXBException         - this exception occurs when using JAXB to marshal a java object to xml format.
     * @throws FileNotFoundException - this exception occurs when in case XML file is not found.
     */
    public static void transformToXML(MovieList movieList) {
        try {
            JAXBContext context = JAXBContext.newInstance(MovieList.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);
            OutputStream os = new FileOutputStream("result.xml");
            marshaller.marshal(movieList, System.out);
            marshaller.marshal(movieList, os);
        } catch (JAXBException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This is a transformToPOJO method
     * <p>
     * This method unmarshalls XML file into Plain Old Java Object.
     *
     * @return returns movieList object.
     * @throws JAXBException - this exception occurs when using JAXB to marshal a java object to xml format.
     * @throws IOException   - this exception occurs when invalid input or invalid output has occurred.
     */
    public static MovieList transformToPOJO() {
        try {
            JAXBContext context = JAXBContext.newInstance(MovieList.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Path path = Path.of("movies.xml");
            String xmlContent = Files.readString(path);
            StringReader reader = new StringReader(xmlContent);
            return (MovieList) unmarshaller.unmarshal(reader);
        } catch (JAXBException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
