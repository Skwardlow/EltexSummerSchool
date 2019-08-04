package ru.skwardlow;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;

public class HierarchyMain {


    private static final String csvPathDev = "src/main/resources/results/Developers.csv";
    private static final String csvPathMan = "src/main/resources/results/Managers.csv";
    public static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/users";
    public static final String splitter =
            "\n-----------------------------------------------------------------------\n";


    public static void main(String[] args) throws IOException {

        System.out.println("\n\nClass Hierarchy\n");
        byte id1 = 1;
        byte id2 = 2;
        String[] items = {" iPad", " iPhone", " iHome"};
        String[] cost = {"111111", "2222222", "3333333"};
        Manager man = new Manager(id1, "Igor", "+79634115478", "abc@d", items, cost);

        ArrayList<String> langs = new ArrayList<>();
        langs.add("Java");
        langs.add("Python");
        Developer dev = new Developer(id2, "Egor", "+78005553535", "zaym@da", langs);

        FileWriter fw = new FileWriter(new File(csvPathDev), false);
        fw.flush();
        fw.close();

        fw = new FileWriter(new File(csvPathMan), false);
        fw.flush();
        fw.close();

        man.writeToCSV();
        dev.writeToCSV();

        System.out.println("[CSV Writed]");


        System.out.println(" CSV Read:");
        Developer rdev = new Developer();
        rdev.readFromCSV();
        System.out.println("       " + rdev.toString());
        Manager rman = new Manager();
        rman.readFromCSV();
        System.out.println("       " + rman.toString());

        System.out.println(splitter);

        Task<Developer, Manager> task = new Task<>(dev, man);
        task.writeToCSV();
        System.out.println("[Task Writed]");

        System.out.println(" Task Read:");
        Task<Developer, Manager> rtask = new Task();
        rtask.readFromCSV();
        System.out.println("      " + rtask.toString());

        System.out.println(splitter);

        man.writeToJSON();
        dev.writeToJSON();
        System.out.println("[Json writed]");

        System.out.println(" Json read:");
        Manager jman = new Manager();
        jman.readFromJSON();
        System.out.println("      " + jman.toString());

        Developer jdev = new Developer();
        jdev.readFromJSON();
        System.out.println("      " + jdev.toString());

        System.out.println(splitter);
        System.out.println(" Database from JSON writer:");
        Database.jsonDevDBTransfer();
        Database.jsonManDBTransfer();

        SQLfunc.showALL();


        System.out.println(splitter);
        //Сделаю лист объектов для считывания подряд вне зависимости от количества как разберусь с чтением
    }
}
