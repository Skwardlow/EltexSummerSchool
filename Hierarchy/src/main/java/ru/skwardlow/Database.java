package ru.skwardlow;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Cleanup;
import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Database {
    @SneakyThrows(SQLException.class)
    protected static void devToDB(Developer developer) {
        @Cleanup Connection connection = DriverManager.getConnection(Auth.getHOST(), Auth.getLOGIN(), Auth.getPASSWD());
        @Cleanup Statement statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO Developers(fio, phone, mailbox, langs) " +
                "VALUE ('" + developer.getFio() + "','" + developer.getPhone() +
                "','" + developer.getMailbox() + "','" + developer.langToStr() + "')");
        statement.close();
    }

    @SneakyThrows(SQLException.class)
    protected static void manToDB(Manager manager) {
        @Cleanup Connection connection = DriverManager.getConnection(Auth.getHOST(), Auth.getLOGIN(), Auth.getPASSWD());
        @Cleanup Statement statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO Managers(fio, phone, mailbox, sales) " +
                "VALUE ('" + manager.getFio() + "','" + manager.getPhone() +
                "','" + manager.getMailbox() + "','" + manager.salesToStr() + "')");
    }

    @SneakyThrows(SQLException.class)
    public static ArrayList<Developer> devsFromDB() {
        @Cleanup Connection connection = DriverManager.getConnection(Auth.getHOST(), Auth.getLOGIN(), Auth.getPASSWD());
        @Cleanup Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Developers;");
        ArrayList<Developer> devs = new ArrayList<>();
        ArrayList<String> langs = new ArrayList<>();
        String tempStr;
        String[] langsTemp;

        while (resultSet.next()) {
            Developer tmpDev = new Developer();
            tmpDev.setUserid(resultSet.getByte("id"));
            tmpDev.setFio(resultSet.getString("fio"));
            tmpDev.setPhone(resultSet.getString("phone"));
            tmpDev.setMailbox(resultSet.getString("mailbox"));

            tempStr = resultSet.getString("langs");
            langsTemp = tempStr.split(" ");
            Collections.addAll(langs, langsTemp);

            tmpDev.setLang(langs);

            devs.add(tmpDev);
        }

        return devs;
    }

    @SneakyThrows(SQLException.class)
    public static ArrayList<Manager> mansFromDB() {
        @Cleanup Connection connection = DriverManager.getConnection(Auth.getHOST(), Auth.getLOGIN(), Auth.getPASSWD());
        @Cleanup Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Managers;");
        ArrayList<Manager> mans = new ArrayList<>();
        String tempStr;

        ArrayList<String> tempArr = new ArrayList<>();

        while (resultSet.next()) {
            Manager tmpMan = new Manager();
            tmpMan.setUserid(resultSet.getByte("id"));
            tmpMan.setFio(resultSet.getString("fio"));
            tmpMan.setPhone(resultSet.getString("phone"));
            tmpMan.setMailbox(resultSet.getString("mailbox"));

            tempStr = resultSet.getString("sales");
            Collections.addAll(tempArr, tempStr.split(" "));

            LinkedList<String> itemsLL = new LinkedList<>();
            LinkedList<String> pricesLL = new LinkedList<>();

            for (int i = 1; i < tempArr.size(); i += 2) {
                String[] currSale = tempArr.get(i).split(":");
                itemsLL.add(currSale[0]);
                pricesLL.add(currSale[1]);
            }

            tmpMan.setSales(itemsLL.toString().split(", "), pricesLL.toString().split(", "));

            mans.add(tmpMan);
        }

        return mans;
    }


    @SneakyThrows(IOException.class)
    public static void jsonManDBTransfer() {
        @Cleanup FileInputStream fis = new FileInputStream(Manager.jsonPathMan);
        ObjectMapper om = new ObjectMapper();
        MappingIterator<Manager> iterator = om.readerFor(Manager.class).readValues(fis);

        while (iterator.hasNextValue()) {
            Manager currMan;
            currMan = iterator.nextValue();
            manToDB(currMan);
        }

    }

    @SneakyThrows(IOException.class)
    public static void jsonDevDBTransfer() {
        @Cleanup FileInputStream fis = new FileInputStream(Developer.jsonPathDev);
        ObjectMapper om = new ObjectMapper();
        MappingIterator<Developer> iterator = om.readerFor(Developer.class).readValues(fis);

        while (iterator.hasNextValue()) {
            Developer currDev;
            currDev = iterator.nextValue();
            devToDB(currDev);
        }

    }
}
