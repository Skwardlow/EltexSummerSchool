package ru.skwardlow;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("Type what you want send to server ");
        Scanner scanner = new Scanner(System.in);
        String dataToSend = scanner.nextLine();
        dataToSend.concat("\0");
        byte[] data = dataToSend.getBytes();
        InetAddress addr = InetAddress.getByName("127.0.0.1");
        DatagramPacket pack =
                new DatagramPacket(data, data.length, addr, 5678);
        DatagramSocket ds = new DatagramSocket();
        ds.send(pack);
        ds.close();
    }
}