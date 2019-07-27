package ru.skwardlow;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServerThread implements Runnable {
    private Integer serverPort;

    ServerThread(Integer serverPort){
        this.serverPort = serverPort;
    }

    @Override
    public void run() {
        try {
            DatagramSocket ds = new DatagramSocket(serverPort);
            while (true){
                DatagramPacket pack =
                        new DatagramPacket(new byte[1024], 1024);
                ds.receive(pack);
                System.out.println(new String(pack.getData()));
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }
}
