package lt.viko.eif.esemasko.movie_critic_system;

import lt.viko.eif.esemasko.movie_critic_system.model.*;
import lt.viko.eif.esemasko.movie_critic_system.util.*;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Set;

/**
 * This is a main class.
 *
 * @author Edgar Semaško
 * @version 1.0
 * @since 1.0
 */
public class Main {
    /**
     * This is a main method
     * <p>
     * This is main method enables and performs XML file transfer over network, then validates XML file against DTD scheme.
     * If XML file does not pass validation, message is printed out, informing about failed validation.
     * In case validation is passed, XML file is transformed into Plain Old Java Object, which is printed out and then turned into another XML file.
     *
     * @param `args[]` string array
     * @return void
     * @throws `JAXBException` - this exception occur when you are using JAXB to marshal a java object to xml format.
     */
    public static void main(String[] args) throws IOException {

        ServerUtil serverStart = new ServerUtil();
        serverStart.serverEnabler();

        if (XSDValidation.validateXMLSchema(Path.of("moviesXSD.xsd").toString(), Path.of("received.xml").toString())) {
            System.out.println("Document validated.");
            MovieList movieList = JAXBUtil.transformToPOJO();
            System.out.println(movieList);
            JAXBUtil.transformToXML(movieList);
            System.out.println("Complete.");
        } else
            System.out.println("Validation failed.");
        System.exit(0);
    }
}
