package secondstep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    private static final String SERVER_IP ="127.0.0.1";
    private static final int SERVER_PORT =9090 ;

    public static void main(String[] args) throws IOException {
        Socket clientSocket=new Socket(SERVER_IP, SERVER_PORT);

        BufferedReader input=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        BufferedReader keyboard=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out= new PrintWriter(clientSocket.getOutputStream(),true);
        System.out.println(" Welcome,  say hello to start!");
       while(true){
           System.out.println(">  ");
           String command= keyboard.readLine();
           if (command.equals("exit")) break;
           out.println(command);
           String serverResponse= input.readLine();
           System.out.println("[server side] : "+serverResponse);

       }

        clientSocket.close();
        System.exit(0);
    }
}
