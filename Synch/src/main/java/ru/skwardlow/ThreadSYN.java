package ru.skwardlow;

public class ThreadSYN implements Runnable{
    private ResSYN res;
    ThreadSYN(ResSYN res){
        this.res = res;
    }

    @Override
    public void run() {
        res.inc();
    }
}