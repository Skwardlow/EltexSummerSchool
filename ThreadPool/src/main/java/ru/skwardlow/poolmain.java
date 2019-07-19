package ru.skwardlow;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class poolmain {
    public static void main(String[] args) {
        System.out.println("Choose task number\n1-Cached\n2-Fixed\n3-Single\n4-Scheduled\n" +
                "5-SingleScheduled\nAnyElseKey-Exit\npool-%startedpoolnumber%-thread-%started!INPOOL!threadnumber%");
        Scanner in = new Scanner(System.in);
        String buff;
        ExecutorService exec;

        while (true) {
            buff = in.nextLine();
            switch (buff) {
                case "1":
                exec = Executors.newCachedThreadPool();
                for (int i = 0; i < 3; i++) {
                    Runnable th = new simpleThread();
                    exec.submit(th);

                }
                exec.shutdown();
                break;

                case "2":
                exec = Executors.newFixedThreadPool(3);
                for (int i = 0; i < 10; i++) {
                    Runnable th = new simpleThread();
                    exec.submit(th);
                }
                exec.shutdown();
                break;

                case "3":
                System.out.println("Single - По очереди");
                exec = Executors.newSingleThreadExecutor();
                for (int i = 0; i < 10; i++) {
                    Runnable th = new simpleThread();
                    exec.submit(th);
                }
                exec.shutdown();
                break;

                case "4":
                exec = Executors.newScheduledThreadPool(3);
                for (int i = 0; i < 10; i++) {
                    Runnable th = new simpleThread();
                    exec.submit(th);
                }
                exec.shutdown();
                break;

                case "5":
                exec = Executors.newSingleThreadScheduledExecutor();
                for (int i = 0; i < 10; i++) {
                    Runnable th = new simpleThread();
                    exec.submit(th);
                }
                exec.shutdown();
                break;
                default:
                    return;
            }
        }
    }

}
