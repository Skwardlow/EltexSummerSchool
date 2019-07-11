package ru.skwardlow;

public class Counter implements Runnable{
    Common res;
    Counter(Common res){
        this.res = res;
    }

    @Override
    public void run() {
        res.inc();
    }
}