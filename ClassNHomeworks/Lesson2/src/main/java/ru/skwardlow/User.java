package ru.skwardlow;

public abstract class User {
    private String fio;
    private String phone;
    private String mailbox;
    private Byte userid;

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

    public User() {

    }

    public  User(byte userid, String fio, String phone, String mailbox) {
        this.userid = userid;
        this.fio =fio;
        this.phone = phone;
        this.mailbox = mailbox;
    }






}
