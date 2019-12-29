package firststep;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {

    private static final String SERVER_IP ="127.0.0.1";
    private static final int SERVER_PORT =9092 ;

    public static void main(String[] args) throws IOException {
        Socket serverSocket=new Socket(SERVER_IP, SERVER_PORT);

        BufferedReader input=new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
        String serverResponse=input.readLine();
        JOptionPane.showMessageDialog(null, "The date is:\n"+serverResponse);

        serverSocket.close();
        System.exit(0);
    }
}
