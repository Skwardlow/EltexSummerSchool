package ru.skwardlow;

import com.sun.tools.javac.util.StringUtils;

import java.io.*;
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

  /*  public String toCSV(){
        StringBuilder sb = new StringBuilder();
        sb.append("1"+",").append(this.getFio()+",").append(this.getPhone()+",")
                .append(this.getMailbox()+",").append(this.getSalesToStr()+",").append("\n");
    return sb.toString();
    }*/


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
    public void readFromCSV() {
        String csvFile = "Managers.csv";
        BufferedReader br;
        String line;
        String cvsSplitBy = ",";
        try {
            br = new BufferedReader(new FileReader("Managers.csv"));
            line = br.readLine();
            String[] data = line.split(cvsSplitBy);
            int count = line.length() - line.replace(":", "").length();
            setUserid(Byte.valueOf(data[0]));
            setFio(data[1]);
            setPhone(data[2]);
            setMailbox(data[3]);
            StringBuilder CurrItems = new StringBuilder();
            StringBuilder CurrPrices = new StringBuilder();
            //String[] CurrSale;
            int iterator=0;
            for(int i=4;i<count;i++) {
                String[] CurrSale=data[i].split(":");
                System.out.println(data[i]);
                CurrItems.append(CurrSale[0]).append(";");
                CurrPrices.append((CurrSale[0])).append(";");
            }
            setSales(CurrItems.toString().split(";"),CurrPrices.toString().split(";"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}