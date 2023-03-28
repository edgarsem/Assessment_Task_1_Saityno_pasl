package lt.viko.eif.esemasko.movie_critic_system.util;

import java.io.IOException;

/**
 * This class has one method: serverEnabler
 *
 * @version 1.0
 * @since 1.0
 */
public class ServerUtil {

    /**
     * This is a serverEnabler method
     * <p>
     * This method invokes Server and Client classes, which send and receive XML file over network respectively.
     *
     * @throws IOException          - this exception occurs when invalid input or invalid output has occurred.
     * @throws InterruptedException - this exception thread is interrupted during sleeping.
     */
    public void serverEnabler() throws IOException {

        String path = "C:/Program Files (x86)/Ed g3a(newer)/java/projects/Saityno_paslaugos/Assessment_Task_1/movies.xml";

        new Thread(() -> {
            try {
                Server.sendXML(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Client.receiveXML();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
