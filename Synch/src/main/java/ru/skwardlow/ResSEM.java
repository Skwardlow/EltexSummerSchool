package ru.skwardlow;

import java.util.concurrent.Semaphore;

public class ResSEM {
    private static int x = 0;
    private static Semaphore semaphore = new Semaphore(1);
    public static void inc() throws InterruptedException{
        semaphore.acquire();
        x++;
        semaphore.release();
        System.out.println("SEM " + Thread.currentThread().getName()+"     "+x);
    }
}
