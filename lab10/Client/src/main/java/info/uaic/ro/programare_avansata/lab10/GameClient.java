package info.uaic.ro.programare_avansata.lab10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class GameClient {
    public static void main(String[] args) throws IOException {
        String serverAddress = "127.0.0.1";
        int PORT = 8100;
        try(
            Socket socket = new Socket(serverAddress, PORT);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())) ) {
                String request = "World";
                out.println(request);

                String response = in.readLine();
                System.out.println(response);
            } catch (UnknownHostException e){
            System.err.println("No server listening..." + e);
        }
    }
}
