package ru.skwardlow;

public class Developer extends  User{

    private  String[] lang;

    public Developer(){
        super();
    }

    public Developer(Byte id, String fio, String phone, String mailbox, String[] lang){
        super(id,fio,phone,mailbox);
        setLang(lang);
    }

    private void setLang(String[] lang) {
        this.lang = lang;
    }

    public String[] getLang() {
        return lang;
    }


}
