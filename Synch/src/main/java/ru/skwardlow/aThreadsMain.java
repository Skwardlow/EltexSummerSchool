package ru.skwardlow;

import javax.swing.plaf.TableHeaderUI;

/*По-доброму, сделать бы тут иерархию из абстрактного треда и ресурса.*/
public class aThreadsMain {
    public static void main(String[] args) throws InterruptedException {
    ResSYN resSYN = new ResSYN();
    for (int i=1; i<=10;i++){
        Thread tsyn = new Thread(new ThreadSYN(resSYN));
        tsyn.setName("Thread "+i);
        tsyn.start();
    }
    Thread.sleep(1000);
    /*благодаря volatile тред сможет остановиться, иначе бул keeprunning в некоторых случаях будет вечно true,
* поскольку он будет кеширован*/

    ThreadVOL t = new ThreadVOL();
    t.start();
    t.setName("VolTest");
    Thread.sleep(1000);
    System.out.println("After sleeping");
    t.keepRunning = false;
    t.join();
    System.out.println("keepRunning set to " + t.keepRunning+"in thread" + t.getName());


    ResREE  resREE = new ResREE();
    for (int i=1; i<=10;i++){
        Thread tlock = new Thread(new ThreadREE(resREE));
        tlock.setName("Thread "+i);
        tlock.start();
    }
    Thread.sleep(2000);


    ResSEM resSEM = new ResSEM();
    for (int i=1;i<=10;i++){
        Thread tsem = new Thread(new ThreadSEM(resSEM));
        tsem.setName("Thread "+i);
        tsem.start();
    }



    }
}
