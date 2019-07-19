package ru.skwardlow;

public class ResSYN {
    private int x;
    synchronized  void inc(){
        x=1;
        for (int i = 1;i<4;i++){
            System.out.println("SYN " + Thread.currentThread().getName()+"     "+x);
            x++;
        }
    }
}
