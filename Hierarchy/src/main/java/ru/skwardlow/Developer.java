package ru.skwardlow;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Developer extends  User{
    private static final String csvPathDev ="Developers.csv";
    private static final String jsonPathDev ="Developers.json";
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
            fw = new FileWriter(new File(csvPathDev),true);
            StringBuilder sb = new StringBuilder();
            sb.append("1"+",").append(this.getFio()+",").append(this.getPhone()+",")
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
            br = new BufferedReader(new FileReader(csvPathDev));
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

    @Override
    public void writeToJSON() {
    /*    try {
            FileWriter fw = new FileWriter(new File(jsonPathDev),true);
            ObjectMapper om = new ObjectMapper();
            om.writeValue(fw,this);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        super.writeToJSON();
    }

    @Override
    public void readFromJSON() {
        /*ObjectMapper om = new ObjectMapper();
        try {
            Developer tmpDev = om.readValue(new File(jsonPathDev),Developer.class);
            super.readFromJSON();
            this.lang = tmpDev.lang;
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        super.readFromJSON();
    }
}