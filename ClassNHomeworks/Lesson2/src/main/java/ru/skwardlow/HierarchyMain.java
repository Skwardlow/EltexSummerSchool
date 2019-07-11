package ru.skwardlow;

import java.io.*;
import java.util.ArrayList;

public class HierarchyMain {


    private static final String csvPathDev ="Developers.csv";
    private static final String csvPathMan ="Managers.csv";


    public static void main(String[] args){

        System.out.println("Class Hierarchy");
        byte id1 = 1;
        byte id2 = 2;
        String[] items={"iPad","iPhone","iHome"};
        String[] cost={"111111","2222222","3333333"};
        Manager man = new Manager(id1,"Igor","+79634115478","abc@d",items,cost);

        ArrayList<String> langs = new ArrayList<>();
        langs.add("Java");
        langs.add("Python");
        Developer dev = new Developer(id2,"Egor","+78005553535","zaym@da",langs);
        try {
            FileWriter fw = new FileWriter(new File(csvPathDev),false);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileWriter fw = new FileWriter(new File(csvPathMan),false);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        man.writeToCSV();
        dev.writeToCSV();
        System.out.println("CSV Writed");

        Developer rdev = new Developer();
        rdev.readFromCSV();
        System.out.println(rdev.toString());

        Manager rman = new Manager();
        rman.readFromCSV();
        System.out.println(rman.toString());

        System.out.println("CSV Readed");

        Task <Developer,Manager> task = new Task<>(dev,man);
        task.writeToCSV();
        System.out.println("Task Writed");
        Task<Developer,Manager> rtask = new Task();
        rtask.readFromCSV();
        System.out.println("Task Readed");
        System.out.println(rtask.toString());

        //Сделаю лист объектов для считывания подряд вне зависимости от количества как разберусь с чтением
    }
}
