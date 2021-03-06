package secondstep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    private static String[] names = {"Ali", "Amir", "Hadi"};
    private static String[] adjs = {" is short ", "is tall", "is a Monster"};
    private static final int PORT = 9090;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("[SERVER side] Waiting for client connection...");
        Socket clientSocket = serverSocket.accept();
        System.out.println("[SERVER side] connected to client!  ");

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader((new InputStreamReader(clientSocket.getInputStream())));

        try {
            while (true) {
                String request = in.readLine();
                if (request.contains("name")) {
                    out.println(getRandomName());
                } else {
                    out.println("Type 'tell me a name' to get a random name");
                }
            }
        }finally {
                out.close();
                in.close();
            }
        }

    public static String getRandomName() {
        String name = names[(int) (Math.random() * names.length)];
        String adj = adjs[(int) (Math.random() * adjs.length)];
        return name + " " + adj;
    }
}

