package ru.skwardlow;

public class Common {
    int x;
    synchronized  void inc(){
        x=1;
        for (int i = 1;i<10;i++){
            System.out.println("Gyg" + Thread.currentThread().getName()+"     "+x);
            x++;
          /*  try{
                Thread.sleep(1000);
            }
            catch (InterruptedException e){}*/
        }
    }
}
