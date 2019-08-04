package ru.skwardlow;

import lombok.SneakyThrows;

import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread implements Runnable {
    private Integer port;
    private Boolean close = false;

    ServerThread(Integer port) {
        this.port = port;
    }
    @SneakyThrows
    public void run() {
            ServerSocket ss = new ServerSocket(port, 0, InetAddress.getByName("0.0.0.0"));
            while (!close) {
                Socket socket = ss.accept();
                Runnable run = new ClientThread(socket);
                Thread thread = new Thread(run);
                thread.start();
        }
    }

}
