import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class server{

    public void run() throws IOException{
        int port=8010;
        ServerSocket socket=new ServerSocket(port);
        socket.setSoTimeout(20000);

        while(true){
            try{
            System.out.println("Server is listening on port "+port);
            Socket acceptedconnection=socket.accept();
            System.out.println("Connection accepted from client "+acceptedconnection.getRemoteSocketAddress());
            PrintWriter toclient=new PrintWriter(acceptedconnection.getOutputStream());
            BufferedReader fromclient=new BufferedReader(new InputStreamReader(acceptedconnection.getInputStream()));

            toclient.println("Hello from the server");
            toclient.close();
            fromclient.close();
            acceptedconnection.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    }


    public static void main(String[] args) {
        server server=new server();
        try{
            
                server.run();
            }catch(Exception ex){
                ex.printStackTrace();
            }

        }
}
