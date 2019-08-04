package ru.skwardlow;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Manager extends User {
    private static final String csvPathMan = "src/main/resources/results/Managers.csv";
    public static final String jsonPathMan = "src/main/resources/results/Managers.json";
    @Getter
    private ArrayList<Sales> sales = new ArrayList<>();

    Manager() {
        super();
    }

    Manager(byte id, String fio, String phone, String mailbox, String[] items, String[] prices) {
        super(id, fio, phone, mailbox);
        setSales(items, prices);


    }

    public void setSales(String[] items, String[] prices) {

        sales = new ArrayList<>();
        if (items.length != prices.length) {
            System.out.println("Sales and prices mismatch");
        } else {
            for (int i = 0; i < items.length; i++) {
                String currItem = items[i];
                String currPrice = prices[i];
                sales.add(new Sales(currItem, currPrice));

            }

        }
    }

    public String salesToStr() {
        StringBuilder sb = new StringBuilder();
        for (Sales s : sales) {
            sb.append(s.getSale()).append(':').append(s.getPrice()).append(' ');
        }

        return sb.toString();
    }


    @Override
    public String toString() {
        return super.toString() + salesToStr();
    }

    @Override
    public void writeToCSV() {
        FileWriter fw;
        try {
            fw = new FileWriter(new File(csvPathMan), true);
            String sb = "2" + "," + this.getFio() + "," + this.getPhone() + "," +
                    this.getMailbox() + "," + ">" + this.salesToStr() + "," + "\n";
            fw.write(sb);
            // fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void readFromCSV() {
        BufferedReader br;
        String line;
        ArrayList<String> currItems = new ArrayList<>();
        ArrayList<String> currPrices = new ArrayList<>();
        String cvsSplitBy = ",";
        String salesSplitBy = ">";
        String prItSplitBy = ":";
        try {
            br = new BufferedReader(new FileReader(csvPathMan));
            line = br.readLine();
            String[] salesSwitch = line.split(salesSplitBy);
            String[] userData = salesSwitch[0].split(cvsSplitBy);
            String[] salesData = salesSwitch[1].split(cvsSplitBy);
            setUserid(Byte.valueOf(userData[0]));
            setFio(userData[1]);
            setPhone(userData[2]);
            setMailbox(userData[3]);

            ArrayList<String> AL = new ArrayList<>();
            Collections.addAll(AL, salesData);

            for (String i : AL) {
                currItems.add(i.split(prItSplitBy)[0]);
                currPrices.add(i.split(prItSplitBy)[1]);
            }
            setSales(currItems.toString().split(","), currPrices.toString().split(","));


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void writeToJSON() throws IOException {
        FileWriter fw = new FileWriter(new File(jsonPathMan), true);
        ObjectMapper om = new ObjectMapper();
        om.writeValue(fw, this);
    }

    @Override
    public void readFromJSON() throws IOException {
        ObjectMapper om = new ObjectMapper();
        Manager tmpMan = om.readValue(new File(jsonPathMan), Manager.class);
        this.userid = tmpMan.userid;
        this.fio = tmpMan.fio;
        this.phone = tmpMan.phone;
        this.mailbox = tmpMan.mailbox;
        this.sales = tmpMan.sales;
    }
}