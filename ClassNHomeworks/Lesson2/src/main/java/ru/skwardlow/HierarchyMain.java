package ru.skwardlow;

import java.io.*;
import java.util.ArrayList;

public class HierarchyMain {
    public static void main(String[] args){
        System.out.println("Class Hierarchy");
        byte id1 = 1;
        byte id2 = 2;
        String[] items={"iPad","iPhone","iHome"};
        String[] cost={"111111","2222222","3333333"};
        Manager man = new Manager(id1,"Igor","+79634115478","abc@d",items,cost);

        ArrayList<String> langs = new ArrayList<>();
        langs.add("poor");
        langs.add("Lang");
        Developer dev = new Developer(id2,"Egor","+78005553535","zaym@da",langs);
        try {
            FileWriter fw = new FileWriter(new File("Developers.csv"),false);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileWriter fw = new FileWriter(new File("Managers.csv"),false);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        man.writeToCSV();
        dev.writeToCSV();
        System.out.println("CSV Writed");

        //Сделаю лист объектов для считывания подряд вне зависимости от количества как разберусь с чтением
    }
}
