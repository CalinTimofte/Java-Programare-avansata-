package info.uaic.ro.programare_avansata.lab10;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer {
    public static final int PORT = 8100;

    public GameServer() throws IOException{
        ServerSocket serverSocket = null;
        try{
            serverSocket = new ServerSocket(PORT);
            while(true){
                System.out.println("Waiting for a client");
                Socket socket = serverSocket.accept();
//                Execute the client request in a new thread
                new ClientThread(socket).start();
            }
        }
        catch (IOException e){
            System.err.println("Oops..." + e);
        }
        finally {
            serverSocket.close();
        }
    }

    public static void main(String[] args) throws IOException {
        GameServer server = new GameServer();
    }
}
