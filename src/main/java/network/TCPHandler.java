package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPHandler {

    public static final int SERVER_PORT = 51000;

    ServerSocket serverSocket;

    private boolean isServer;

    public TCPHandler(boolean isServer) {
        //todo implement

        if (isServer){
            try {
                serverSocket = new ServerSocket(SERVER_PORT);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {

        }
    }

    public void startReceiver(){

        if (isServer){
            while (true){
                try {
                    Socket socket = serverSocket.accept();
                    BufferedReader inFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                    //Todo verarbeiten

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        else {

        }

    }

    public void send(String s){

        if (isServer){

        }
        else {

        }

    }
}
