package ru.skwardlow;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

import static javax.print.attribute.standard.ReferenceUriSchemesSupported.HTTP;

public class ClientThread implements Runnable {
    private Socket socket;
    private InputStream inputStream;
    private OutputStream outputStream;
    private String htmlPage;

    ClientThread(Socket socket) {
        this.socket = socket;
    }

    private String htmlPageCreating(String Page) {
        BufferedReader reader = null;
        Page = "src/main/resources" + Page;

        try {
            reader = new BufferedReader(new FileReader(Page));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        String ls = System.getProperty("line.separator");

        while (true) {
            try {
                if ((line = reader.readLine()) == null) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            stringBuilder.append(line);
            stringBuilder.append(ls);
        }
        htmlPage = Page;

        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        String readyToSend = "HTTP/1.1" + " 200 OK\n" +
                "Сontent-Length:" + htmlPage.length() + "\n" +
                "Сontent-Type:text/html\n" +
                "\n"
                + stringBuilder.toString();
        System.out.println("Requested " + Page);
        return readyToSend;
    }

    public void run() {

        try {
            inputStream = socket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            outputStream = socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Input Stream is " + inputStream.toString());

        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        String[] request = in.nextLine().split(" ");
        for (String str : request) {
            System.out.println(str);
        }

        String Page = request[1];
        htmlPage = this.htmlPageCreating(Page);
        out.println(htmlPage);

        out.flush();
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

