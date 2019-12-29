package thirdstep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerConnection implements Runnable{

    private Socket serverSocket;
    private BufferedReader in;
    private PrintWriter out;

    public ServerConnection(Socket socket) throws IOException{
        serverSocket =socket;
        in=new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
        out=new PrintWriter(serverSocket.getOutputStream(),true);
    }
    @Override
    public void run() {
        try {
            while (true) {
                String serverResponse = null;
                if (serverResponse==null) break;
                //serverResponse = in.readLine();
                System.out.println("Server says:  " + serverResponse);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

