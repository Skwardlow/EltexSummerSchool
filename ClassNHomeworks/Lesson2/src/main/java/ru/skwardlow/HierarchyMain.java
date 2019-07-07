package ru.skwardlow;

import java.util.ArrayList;

public class HierarchyMain {
    public static void main(String[] args){
        String[] items={"one","two","three"};
        String[] cost={"111","222","333"};
        ArrayList<String> langs = new ArrayList<>();
        langs.add("poor");
        langs.add("Lang");
        byte id1 = 1;
        byte id2 = 2;
        Manager man = new Manager(id1,"2","3","4",items,cost);
        Developer dev = new Developer(id2,"5","6","7",langs);
        System.out.println(dev.toString());
        System.out.println(man.toString());

    }
}
