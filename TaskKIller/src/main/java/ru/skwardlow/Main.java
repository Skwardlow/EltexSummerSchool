package ru.skwardlow;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)throws IOException {
        myGenerator generator = new myGenerator();
        myWorker worker = new myWorker();
        System.out.println("PID NAME CURRENT_STATUS");
        System.out.println(generator.toString());
        System.out.println("Tell me the ID of process, that you want to KILL/SLAY/DESTROY/ANNIHILATE");
        Scanner scanner = new Scanner(System.in);
        String PID = scanner.nextLine();
        worker.killProc(PID);

    }
}
