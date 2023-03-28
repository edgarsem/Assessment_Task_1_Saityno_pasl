package lt.viko.eif.esemasko.movie_critic_system.util;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

/**
 * This class has one method: validateXMLSchema
 *
 * @version 1.0
 * @since 1.0
 */
public class XSDValidation {
    /**
     * This is a validateXMLSchema method
     * <p>
     * This method validates XML file against DTD scheme.
     *
     * @param xsdPath - path to XSD scheme.
     * @param xmlPath - path to XML file.
     * @return returns boolean (true or false)
     * @throws IOException  - this exception occurs when invalid input or invalid output has occurred.
     * @throws SAXException - this exception occur when method is trying to validate XML file.
     */
    public static boolean validateXMLSchema(String xsdPath, String xmlPath) {

        try {
            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdPath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlPath)));
        } catch (IOException | SAXException e) {
            System.out.println("Exception: " + e.getMessage());
            return false;
        }
        return true;
    }


}
