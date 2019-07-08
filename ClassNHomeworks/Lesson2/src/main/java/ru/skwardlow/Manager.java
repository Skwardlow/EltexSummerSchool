package ru.skwardlow;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Manager extends User implements CSV{
    private ArrayList<Sales> sales = new ArrayList<>();

    Manager(){
        super();
    }

    Manager(byte id, String fio, String phone, String mailbox, String[] items, String[] prices){
        super(id,fio,phone,mailbox);
        setSales(items,prices);


    }

    private void setSales(String[] items, String[] prices) {
        sales = new ArrayList<>();
        if (items.length != prices.length){
            System.out.println( "Sales and prices mismatch");
        }
        else {
            for (int i=0; i< items.length; i++){
                String currItem = items[i];
                String currPrice = prices[i];
                sales.add(new Sales(currItem,currPrice));

            }

        }
    }

    public ArrayList getSales() {
        return sales;
    }

    private String getSalesToStr() {
        StringBuilder sb = new StringBuilder();
        for (Sales s: sales) {
            sb.append(s.getSale()).append(':').append(s.getPrice()).append(',');
        }

        return sb.toString();
    }

    public String toCSV(){
        StringBuilder sb = new StringBuilder();
        sb.append("1"+",").append(this.getFio()+",").append(this.getPhone()+",")
                .append(this.getMailbox()+",").append(this.getSalesToStr()+",").append("\n");
    return sb.toString();
    }


    @Override
    public String toString() {
        return super.toString()+getSalesToStr();
    }

    @Override
    public void writeToCSV() {
        FileWriter fw;
        try {
            fw = new FileWriter(new File("Managers.csv"),true);
            StringBuilder sb = new StringBuilder();
            sb.append("2"+",").append(this.getFio()+",").append(this.getPhone()+",")
                    .append(this.getMailbox()+",").append(this.getSalesToStr()+",").append("\n");
            fw.write(sb.toString());
            // fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String readFromCSV() {
        return null;
    }
}