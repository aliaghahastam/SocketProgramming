package firststep;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DateServer {
    private static final int PORT=9092;
    public static void main(String[] args) throws IOException {
        System.out.println("\nIn this part we will see a simple connection \nwhich pass the Date to client in a dialog box. \n");
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("[secondstep.Server side] Waiting for client CONNECTION...");
        Socket clientSocket =serverSocket.accept(); // it make a connection
        System.out.println("[secondstep.Server side] Connected to client!");
        PrintWriter out=new PrintWriter(clientSocket.getOutputStream(),true);
        String date=(new Date()).toString();
        System.out.println("[secondstep.Server side] Sending date "+date);
        out.println(date);
        System.out.println("[secondstep.Server] Sent date.    closing...");

        clientSocket.close();
        serverSocket.close();

    }
}
