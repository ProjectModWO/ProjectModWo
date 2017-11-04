package network;/* 
 * Copyright (C) 2017 Vindalia - All Rights Reserved 
 * 
 * Unauthorized copying of this file, via any medium is strictly prohibited 
 * Proprietary and confidential 
 * 
 * Written by Vindalia <development@vindalia.net>, 2017 
 */

public class Debug {

    public static void main(String... args){


        TcpServer server = new TcpServer(52000);
        TcpClient client = new TcpClient(52000, "localhost");
        TcpClient another = new TcpClient(52000, "localhost");

        client.send("test");
        another.send("test2");
        client.send("test3");

        server.sendToAll("done");
    }
}
