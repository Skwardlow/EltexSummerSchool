package ru.Skwardlow;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
    public static void main(String[] args) throws IOException {
        byte[] data = "Hello".getBytes();
        InetAddress addr = InetAddress.getByName("127.0.0.1");
        DatagramPacket pack =
                new DatagramPacket(data, data.length, addr, 5678);
        DatagramSocket ds = new DatagramSocket();
        ds.send(pack);
        ds.close();
    }
}