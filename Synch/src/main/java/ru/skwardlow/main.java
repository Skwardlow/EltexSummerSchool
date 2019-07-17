package ru.skwardlow;

public class main {
    public static void main(String[] args) {
    Common common = new Common();
    for (int i=1; i<10;i++){
        Thread t = new Thread(new Counter(common));
        t.setName("Thread "+i);
        t.start();
    }




    }
}
