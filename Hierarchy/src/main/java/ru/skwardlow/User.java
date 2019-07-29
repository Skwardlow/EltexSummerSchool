package ru.skwardlow;

import lombok.Getter;
import lombok.Setter;

public abstract class User implements CSV,JSON {
    @Getter @Setter
    protected String fio;
    @Getter @Setter
    protected String phone;
    @Getter @Setter
    protected String mailbox;
    @Getter @Setter
    protected Byte userid;

    User() {

    }

    User(byte userid, String fio, String phone, String mailbox) {
        this.userid = userid;
        this.fio = fio;
        this.phone = phone;
        this.mailbox = mailbox;
    }

    @Override
    public String toString() {
        return this.userid+" "+this.fio+" "+this.phone+" "+this.mailbox+" ";
    }

}
