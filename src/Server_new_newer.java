import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server_new_newer {
    private static String[] names = {"Ali", "Amir"};
    private static String[] adjs = {"the gentle", "the overwought"};
    private static final int PORT = 9091;
    private static ArrayList<ClientHandler_newer> clients= new ArrayList<>();
    private static ExecutorService pool= Executors.newFixedThreadPool(3);
    public static void main(String[] args) throws IOException {
        ServerSocket listener = new ServerSocket(PORT);

        while (true) {
            System.out.println("[SERVER] Waiting for client connection...");
            Socket client = listener.accept();
            System.out.println("[SERVER] connected to client!  ");
            ClientHandler_newer clientThread=new ClientHandler_newer(client, clients);
            clients.add(clientThread);
            pool.execute(clientThread);
        }
    }

    public static String getRandomName() {
        String name = names[(int) (Math.random() * names.length)];
        String adj = adjs[(int) (Math.random() * adjs.length)];
        return name + " " + adj;
    }
}

