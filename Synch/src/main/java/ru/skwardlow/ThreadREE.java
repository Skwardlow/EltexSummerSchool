package ru.skwardlow;

public class ThreadREE implements Runnable {
    private ResREE res;
    ThreadREE(ResREE res){
        this.res = res;
    }

    @Override
    public void run() {
        ResREE.inc();
    }
}
