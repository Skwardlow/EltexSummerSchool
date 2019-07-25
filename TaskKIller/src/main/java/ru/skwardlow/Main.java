package ru.skwardlow;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)throws IOException {
        myGenerator generator = new myGenerator();
        System.out.println("PID NAME CURRENT_STATUS");
        System.out.println(generator.toString());
        System.out.println("Tell me the the path, that you want to delete");
        Scanner scanner = new Scanner(System.in);
        String dir = scanner.nextLine();
        generator.dirDeleter(dir);
    }
}
