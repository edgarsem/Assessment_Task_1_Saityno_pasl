package lt.viko.eif.esemasko.movie_critic_system.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * This class has one method: receiveXML
 *
 * @version 1.0
 * @since 1.0
 */
public class Client {

    private static final int PORT = 8080;
    private static final String SERVER_ADDRESS = "localhost";

    /**
     * This is a receiveXML method
     * <p>
     * This method receives XML over server.
     *
     * @throws IOException - this exception occurs when invalid input or invalid output has occurred.
     */
    public static void receiveXML() throws IOException {

        Socket socket = new Socket(SERVER_ADDRESS, PORT);
        System.out.println("Connected to server");

        try (InputStream inputStream = socket.getInputStream();
             FileOutputStream fileOutputStream = new FileOutputStream("received.xml")) {

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }
        }

        socket.close();
        System.out.println("File received from server");
    }
}
