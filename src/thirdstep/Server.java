package thirdstep;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private static String[] names = {"Ali", "Amir", "Hadi"};
    private static String[] adjs = {" is short ", "is tall", "is a Monster"};
    private static final int PORT = 9091;
    private static ArrayList<ClientHandler> clients= new ArrayList<>();
    private static ExecutorService pool= Executors.newFixedThreadPool(3);
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);

        while (true) {
            System.out.println("[SERVER] Waiting for client connection...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("[SERVER] connected to client!  ");
            ClientHandler clientThread=new ClientHandler(clientSocket, clients);
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

