package ru.skwardlow;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Developer extends User {
    private static final String csvPathDev = "src/main/resources/results/Developers.csv";
    public static final String jsonPathDev = "src/main/resources/results/Developers.json";
    private ArrayList<String> lang = new ArrayList<>();

    Developer() {
        super();
    }

    Developer(Byte id, String fio, String phone, String mailbox, ArrayList<String> lang) {
        super(id, fio, phone, mailbox);
        setLang(lang);
    }

    public void setLang(ArrayList<String> lang) {
        this.lang = lang;
    }

    public ArrayList<String> getLang() {
        return lang;
    }

    public String langToStr() {
        StringBuilder sb = new StringBuilder();
        for (String s : lang) {
            sb.append(s).append(" ");
        }

        return sb.toString();
    }


    @Override
    public String toString() {
        return super.toString() + langToStr();
    }

    @Override
    public void writeToCSV() {
        FileWriter fw;
        try {
            fw = new FileWriter(new File(csvPathDev), true);
            String sb = "1" + "," + this.getFio() + "," + this.getPhone() + "," +
                    this.getMailbox() + "," + ":" + this.langToStr() + "," + "\n";
            fw.write(sb);
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
            String[] lngSwitch = line.split(lngSplitBy);
            String[] userData = lngSwitch[0].split(cvsSplitBy);
            String[] langData = lngSwitch[1].split(cvsSplitBy);
            setUserid(Byte.valueOf(userData[0]));
            setFio(userData[1]);
            setPhone(userData[2]);
            setMailbox(userData[3]);

            Collections.addAll(this.lang, langData);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeToJSON() throws IOException {
        FileWriter fw = new FileWriter(new File(jsonPathDev), true);
        ObjectMapper om = new ObjectMapper();
        om.writeValue(fw, this);
    }

    @Override
    public void readFromJSON() throws IOException {
        ObjectMapper om = new ObjectMapper();
        Developer tmpDev = om.readValue(new File(jsonPathDev), Developer.class);
        this.userid = tmpDev.userid;
        this.fio = tmpDev.fio;
        this.phone = tmpDev.phone;
        this.mailbox = tmpDev.mailbox;
        this.lang = tmpDev.lang;
    }
}
