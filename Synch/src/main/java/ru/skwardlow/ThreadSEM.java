package ru.skwardlow;

public class ThreadSEM implements Runnable {
    private ResSEM res;

    ThreadSEM(ResSEM resSEM){res = resSEM;}

    @Override
    public void run() {
        try {
            ResSEM.inc();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
