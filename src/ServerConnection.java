import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerConnection implements Runnable{

    private Socket server;
    private BufferedReader in;
    private PrintWriter out;

    public ServerConnection(Socket s) throws Exception{
        server =s;
        in=new BufferedReader(new InputStreamReader(server.getInputStream()));
        out=new PrintWriter(server.getOutputStream(),true);
    }
    @Override
    public void run() {
        try {
            while (true) {
                String serverResponse = null;
                if (serverResponse==null) break;
                serverResponse = in.readLine();
                System.out.println("firststep.Server says:  " + serverResponse);
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

