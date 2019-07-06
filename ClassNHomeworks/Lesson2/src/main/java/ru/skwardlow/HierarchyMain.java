package ru.skwardlow;

public class HierarchyMain {
    public static void main(String[] args){
        String[] items={"one","two","three"};
        String[] cost={"111","222","333"};
        String[] langs={"very","poor","lang"};
        byte id1 = 1;
        byte id2 = 2;
        Manager man = new Manager(id1,"2","3","4",items,cost);
        Developer dev = new Developer(id2,"5","6","7",langs);
    }
}
