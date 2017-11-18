package network;

import java.io.*;
import java.net.Socket;
import java.util.TimerTask;

public class ServerRunnable extends TimerTask {

    private Socket socket;

    public ServerRunnable(Socket socket) {
        this.socket = socket;
    }

    private void processObject(Object o) {
        System.out.println(o);

    }

    public void send(Serializable serializable) {
        System.out.println("Server: Sending object");

        try {
            ObjectOutput obu = new ObjectOutputStream(socket.getOutputStream());
            obu.writeObject(serializable);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void startReceiver() {

        while (true) {

            try {
                System.out.println("Server: Waiting for object");
                ObjectInput oni = new ObjectInputStream(socket.getInputStream());
                Object o = oni.readObject();
                System.out.println("Server: Received Object");
                processObject(o);

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
    }


    @Override
    public void run() {

        startReceiver();
    }
}
