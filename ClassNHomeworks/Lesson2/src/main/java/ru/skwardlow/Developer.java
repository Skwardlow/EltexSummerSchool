package ru.skwardlow;

import java.util.ArrayList;

public class Developer extends  User{

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
            sb.append(s).append(';');
        }

        return sb.toString();
    }


    @Override
    public String toString() {
        return super.toString()+getLangToStr();
    }
}
