package ru.skwardlow;

import java.util.concurrent.locks.ReentrantLock;

public class ResREE {
    private static int x=0;
    public static void inc(){
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        x++;
        System.out.println("REE " + Thread.currentThread().getName()+"     "+x);
        reentrantLock.unlock();


    }
}
