package info.uaic.ro.programare_avansata.lab10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread{
    private Socket socket = null;
    public ClientThread (Socket socket){this.socket = socket;}
    public void run (){
        try{
            //Get the request from input stream client -> server
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );
            String request = in.readLine();

            //Send the response to the output stream: server -> client
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            String raspuns = "Hello " + request + "!";
            out.println(raspuns);
            out.flush();
        } catch (IOException e){
            System.err.println("Communication error..." + e);
        }
        finally {
            try{
                socket.close();//or use try-with-resources
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }
}
