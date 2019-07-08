package ru.skwardlow;

import java.io.*;
import java.util.ArrayList;

public class Developer extends  User implements CSV{

    private ArrayList<String> lang = new ArrayList<>();

    Developer(){
        super();
    }

    Developer(Byte id, String fio, String phone, String mailbox, ArrayList<String> lang){
        super(id,fio,phone,mailbox);
        setLang(lang);
    }

    private void setLang(ArrayList<String> lang) {
        this.lang = lang;
    }

    public ArrayList<String> getLang() {
        return lang;
    }

    private String getLangToStr() {
        StringBuilder sb = new StringBuilder();
        for (String s: lang) {
            sb.append(s).append(',');
        }

        return sb.toString();
    }


    @Override
    public String toString() {
        return super.toString()+getLangToStr();
    }

    @Override
    public void writeToCSV() {
        FileWriter fw;
        try {
            fw = new FileWriter(new File("Developers.csv"),true);
            StringBuilder sb = new StringBuilder();
            sb.append("2"+",").append(this.getFio()+",").append(this.getPhone()+",")
                    .append(this.getMailbox()+",").append(this.getLangToStr()+",").append("\n");
            fw.write(sb.toString());
           // fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void readFromCSV() {
        BufferedReader br = null;
        String line;
        String cvsSplitBy = ",";
        try {
            br = new BufferedReader(new FileReader("Developers.csv"));
            line = br.readLine();
            String[] data = line.split(cvsSplitBy);
            int count = line.length() - line.replace(".", "").length();
            setUserid(Byte.valueOf(data[0]));
            setFio(data[1]);
            setPhone(data[2]);
            setMailbox(data[3]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
