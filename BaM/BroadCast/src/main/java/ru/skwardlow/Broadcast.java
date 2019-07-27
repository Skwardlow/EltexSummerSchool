package ru.skwardlow;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Broadcast {
    public static void main(String[] args) throws IOException {
        System.out.println("Type a message for server");
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        broadcastData(message,InetAddress.getByName("255.255.255.255"));

    }


    public static void broadcastData(String broadcastData,InetAddress address) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        socket.setBroadcast(true);

        byte[] packet = broadcastData.getBytes();

        DatagramPacket dpacket = new DatagramPacket(packet,packet.length, address, 5678);
        socket.send(dpacket);
        socket.close();
        System.out.println("Message sent!");
    }
}
