package ru.skwardlow;

import java.util.Scanner;

public class ServerCommander {
    public static void main(String[] args) {
        System.out.println("ServerThread will be started on port 5678.Type Something to close it and press [Enter]");
        Thread server = new Thread(new ServerThread(5678));
        server.start();
        Scanner in = new Scanner(System.in);
        String buff = in.nextLine();
        server.stop();
        server.interrupt();
        System.out.println("ServerThread Closed");
    }
}
