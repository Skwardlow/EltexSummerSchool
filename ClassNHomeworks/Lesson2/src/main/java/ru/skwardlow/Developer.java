package ru.skwardlow;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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
                    .append(this.getMailbox()+",").append(":").append(this.getLangToStr()+",").append("\n");
            fw.write(sb.toString());
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
        String cvsSplitBy = ",";
        String lngSplitBy = ":";
        try {
            br = new BufferedReader(new FileReader("Developers.csv"));
            line = br.readLine();
            String[] lngSwitch =line.split(lngSplitBy);
            String[] userData = lngSwitch[0].split(cvsSplitBy);
            String[] langData = lngSwitch[1].split(cvsSplitBy);
            setUserid(Byte.valueOf(userData[0]));
            setFio(userData[1]);
            setPhone(userData[2]);
            setMailbox(userData[3]);

            Collections.addAll(this.lang, langData);

        }
          catch (IOException e) {
            e.printStackTrace();
        }
    }
}
