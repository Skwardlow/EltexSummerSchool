package ru.skwardlow;

import java.util.*;

public class main {
    private static sample randomIter(Integer var){
        return new sample(var);

    }
    public static void main(String[] args){
        int countOfIters = 1000000;
        long start;
        long finish;
        String row="/---------------------------------------------------/";
        System.out.println("HashSet vs HashMap");
        HashSet<sample> TMPS = new HashSet<>();
        HashMap<sample,Integer>TMPM = new HashMap<>();
        LinkedList<sample>TLL = new LinkedList<>();
        ArrayList<sample>TAL = new ArrayList<>();
        TreeSet<Integer>TTS = new TreeSet<>();
        start=System.currentTimeMillis();
        for(int i=0; i<countOfIters;i++){
            TMPS.add(randomIter(i));
        }
        boolean m = TMPS.contains(randomIter(645454));
        finish=System.currentTimeMillis();
        System.out.println("Hashset time = "+(finish-start)+"ms");

        System.out.println(row);
        start=System.currentTimeMillis();
        for(int i=0; i<countOfIters;i++){
            TMPM.put(randomIter(i),1);
        }
        m = TMPS.contains(randomIter(645454));
        finish=System.currentTimeMillis();
        System.out.println("Hashmap time = "+(finish-start)+"ms");
        System.out.println(row);

        start=System.currentTimeMillis();
        for(int i=0; i<countOfIters;i++){
            TLL.add(randomIter(i));
        }
        m = TLL.contains(randomIter(645454));
        finish=System.currentTimeMillis();
        System.out.println("LinkedList time = "+(finish-start)+"ms");
        System.out.println(row);

        start=System.currentTimeMillis();
        for(int i=0; i<countOfIters;i++){
            TAL.add(randomIter(i));
        }
        m = TAL.contains(randomIter(645454));
        finish=System.currentTimeMillis();
        System.out.println("ArrayList time = "+(finish-start)+"ms");
        System.out.println(row);

        start=System.currentTimeMillis();
        for(int i=0; i<countOfIters;i++){
            TTS.add(i);
        }
        m = TTS.contains(645454);
        finish=System.currentTimeMillis();
        System.out.println("TreeSet time = "+(finish-start)+"ms");


    }

}
