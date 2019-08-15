/*
 * This file is generated by jOOQ.
 */
package ru.skwardlow.database.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.11"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Users implements Serializable {

    private static final long serialVersionUID = 228752106;

    private final Integer id;
    private final String  fio;
    private final String  phone;
    private final String  mailbox;

    public Users(Users value) {
        this.id = value.id;
        this.fio = value.fio;
        this.phone = value.phone;
        this.mailbox = value.mailbox;
    }

    public Users(
        Integer id,
        String  fio,
        String  phone,
        String  mailbox
    ) {
        this.id = id;
        this.fio = fio;
        this.phone = phone;
        this.mailbox = mailbox;
    }

    public Integer getId() {
        return this.id;
    }

    public String getFio() {
        return this.fio;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getMailbox() {
        return this.mailbox;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Users (");

        sb.append(id);
        sb.append(", ").append(fio);
        sb.append(", ").append(phone);
        sb.append(", ").append(mailbox);

        sb.append(")");
        return sb.toString();
    }
}
