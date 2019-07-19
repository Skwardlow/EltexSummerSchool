package ru.skwardlow;

public class simpleThread implements Runnable {
    @Override
    public void run() {
        for(int i=0;i<3;i++){
            System.out.println("simpleThread #"+Thread.currentThread().getName()  + " count " + i);
        }
    }
}
