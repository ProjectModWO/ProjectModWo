package network;/* 
 * Copyright (C) 2017 Vindalia - All Rights Reserved 
 * 
 * Unauthorized copying of this file, via any medium is strictly prohibited 
 * Proprietary and confidential 
 * 
 * Written by Vindalia <development@vindalia.net>, 2017 
 */

import java.io.IOException;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TcpServer {

    private Timer iHateThreads;

    private ServerSocket server;

    private ThreadUnifier unifier;

    private volatile Queue<ServerRunnable> runnables;

    public TcpServer(int port) {

        unifier = new ThreadUnifier();

        try {
            server = new ServerSocket(port);

            iHateThreads = new Timer(false);

            runnables = new ConcurrentLinkedQueue<>();
            runnables.clear();


            iHateThreads.schedule(new TimerTask() {
                @Override
                public void run() {
                    readyAccept();
                }
            }, 20);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    private void readyAccept() {

        System.out.println("Ready for client");

        while (true) {
            try {
                System.out.println("Waiting for client");
                Socket socket = server.accept();

                ServerRunnable runnable = new ServerRunnable(socket);
                runnables.add(runnable);

                new Timer(false).schedule(runnable, 10);
                System.out.println("Client done");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void sendToAll(Serializable serializable) {
        System.out.println(runnables.toArray().length);
        for (ServerRunnable r : runnables) {
            r.send(serializable);
        }
    }
}
