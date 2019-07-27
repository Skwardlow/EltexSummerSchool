package ru.skwardlow;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class BroadcastS {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(5678);
        DatagramPacket datagramPacket = new DatagramPacket(new byte[1024],1024);
        while (true){
            datagramSocket.receive(datagramPacket);
            System.out.println("Data "+datagramPacket.getData()+ " is received from "+
                    datagramPacket.getAddress()+" on port "+datagramPacket.getPort());
        }
    }
}
