package lt.viko.eif.esemasko.movie_critic_system.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This class has one method: sendXML
 *
 * @version 1.0
 * @since 1.0
 */
public class Server {

    private static final int PORT = 8080;

    /**
     * This is a sendXML method
     * <p>
     * This method enables server and sends XML file through network.
     *
     * @param xmlPath - path to XML file.
     */
    public static void sendXML(String xmlPath) throws IOException {

        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected from " + socket.getInetAddress());

            File xmlFile = new File(xmlPath);

            try (FileInputStream fileInputStream = new FileInputStream(xmlFile);
                 OutputStream outputStream = socket.getOutputStream()) {

                byte[] buffer = new byte[4096];
                int bytesRead;

                while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
            }

            socket.close();
            System.out.println("File sent to client");
        }
    }

}
