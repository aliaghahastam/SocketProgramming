package thirdstep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    private static final String SERVER_IP ="127.0.0.1";
    private static final int SERVER_PORT =9091 ;

    public static void main(String[] args) throws Exception {
        Socket clientSocket=new Socket(SERVER_IP, SERVER_PORT);

        ServerConnection serverConn=new ServerConnection(clientSocket);
        new Thread(serverConn).start();
        BufferedReader keyboard=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out= new PrintWriter(clientSocket.getOutputStream(),true);

        System.out.println(" Welcome,  say hello to start!");
        while(true){
            System.out.println(">  ");
            String command= keyboard.readLine();
            if (command.equals("exit")) break;
            out.println(command);
        }

        clientSocket.close();
        System.exit(0);
    }
}
