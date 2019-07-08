package ru.skwardlow;

import java.util.HashMap;
import java.util.HashSet;

public class main {
    private static sample randomIter(Integer var){
        return new sample(var);

    }
    public static void main(String[] args){
        int countOfIters = 1000000;
        long start;
        long finish;
        System.out.println("HashSet vs HashMap");
        HashSet<sample> TMPS = new HashSet<>();
        HashMap<sample,Integer>TMPM = new HashMap<>();
        start=System.currentTimeMillis();
        for(int i=0; i<countOfIters;i++){
            TMPS.add(randomIter(i));
        }
        boolean m = TMPS.contains(randomIter(645454));
        finish=System.currentTimeMillis();
        System.out.println("Hashset time = "+(finish-start)+"ms");

        start=System.currentTimeMillis();
        for(int i=0; i<countOfIters;i++){
            TMPM.put(randomIter(i),1);
        }
        m = TMPS.contains(randomIter(645454));
        finish=System.currentTimeMillis();
        System.out.println("Hashmap time = "+(finish-start)+"ms");


    }

}
