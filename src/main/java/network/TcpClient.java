package network;/* 
 * Copyright (C) 2017 Vindalia - All Rights Reserved 
 * 
 * Unauthorized copying of this file, via any medium is strictly prohibited 
 * Proprietary and confidential 
 * 
 * Written by Vindalia <development@vindalia.net>, 2017 
 */

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Timer;
import java.util.TimerTask;

public class TcpClient {

    private int port;
    private String ip;

    private Socket socket;

    private Timer iHateThreadsToo;

    public TcpClient(int port, String ip) {
        this.port = port;
        this.ip = ip;

        iHateThreadsToo = new Timer(false);

        try {
            socket = new Socket(InetAddress.getByName(ip), port);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        iHateThreadsToo.schedule(new TimerTask() {
            @Override
            public void run() {
                startReceiver();
            }
        }, 20);
    }

    public void send(Serializable serializable){

        System.out.println("Client: Sending object");

        try {
            ObjectOutput obu = new ObjectOutputStream(socket.getOutputStream());
            obu.writeObject(serializable);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void startReceiver(){

        while (true){

            try {
                System.out.println("Client: Waiting for object");
                ObjectInput oni = new ObjectInputStream(socket.getInputStream());
                Object o = oni.readObject();
                System.out.println("Client: Received Object");
                processObject(o);

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
    }

    private void processObject(Object o){
        System.out.println("CREC: " + o);
    }
}
