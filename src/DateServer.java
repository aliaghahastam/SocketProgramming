import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DateServer {
    private static final int PORT=9090;
    public static void main(String[] args) throws IOException {

        ServerSocket listener = new ServerSocket(PORT);
        System.out.println("[Server side] Waiting for client CONNECTION...");
        Socket client =listener.accept(); // it make a connection
        System.out.println("[Server side] Connected to client!");
        PrintWriter out=new PrintWriter(client.getOutputStream(),true);
        out.println((new Date()).toString());
        System.out.println("[Server] Sent date.    closing.");

        client.close();
        listener.close();

    }
}
