package ru.skwardlow;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public abstract class User implements CSV,JSON {
    private String fio;
    private String phone;
    private String mailbox;
    private Byte userid;

    User() {

    }

    User(byte userid, String fio, String phone, String mailbox) {
        setUserid(userid);
        setFio(fio);
        setPhone(phone);
        setMailbox(mailbox);
    }

    public void setUserid(Byte userid) {
        this.userid = userid;
    }

    public Byte getUserid() {
        return userid;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getFio() {
        return fio;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox;
    }

    public String getMailbox() {
        return mailbox;
    }


    @Override
    public String toString() {
        return getUserid()+getFio()+getPhone()+getMailbox();
    }

    @Override
    public void writeToJSON() {
        ObjectMapper om = new ObjectMapper();
        try{
            FileWriter fw = new FileWriter(new File("Users.json"),true);
            om.writeValue(fw,this);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void readFromJSON() {
        ObjectMapper om = new ObjectMapper();
        try {
            User tmpUser = om.readValue(new File("Users.json"),User.class);
            this.fio = tmpUser.fio;
            this.phone = tmpUser.phone;
            this.mailbox = tmpUser.mailbox;
            this.userid = tmpUser.userid;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
