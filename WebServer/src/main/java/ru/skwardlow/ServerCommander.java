package ru.skwardlow;

import java.util.Scanner;

public class ServerCommander {
    public static void main(String[] args) {
        System.out.println("Server will be started on port 3360.Type Something to close it and press [Enter]");
        Thread server = new Thread(new ServerThread(5678));
        server.start();
        Scanner in = new Scanner(System.in);
        String buff = in.nextLine();
        server.stop();
        server.interrupt();
        System.out.println("Server Closed");

    }
}
