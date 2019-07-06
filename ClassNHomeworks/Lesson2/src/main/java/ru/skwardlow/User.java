package ru.skwardlow;

public abstract class User {
    private String fio;
    private String phone;
    private String mailbox;
    private Byte userid;

    private void setUserid(Byte userid) {
        this.userid = userid;
    }

    public Byte getUserid() {
        return userid;
    }

    private void setFio(String fio) {
        this.fio = fio;
    }

    public String getFio() {
        return fio;
    }

    private void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    private void setMailbox(String mailbox) {
        this.mailbox = mailbox;
    }

    public String getMailbox() {
        return mailbox;
    }

    User() {

    }

    User(byte userid, String fio, String phone, String mailbox) {
        setUserid(userid);
        setFio(fio);
        setPhone(phone);
        setMailbox(mailbox);
    }






}
