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
public class Langunity implements Serializable {

    private static final long serialVersionUID = 502392174;

    private final Integer idDev;
    private final Integer idLang;

    public Langunity(Langunity value) {
        this.idDev = value.idDev;
        this.idLang = value.idLang;
    }

    public Langunity(
        Integer idDev,
        Integer idLang
    ) {
        this.idDev = idDev;
        this.idLang = idLang;
    }

    public Integer getIdDev() {
        return this.idDev;
    }

    public Integer getIdLang() {
        return this.idLang;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Langunity (");

        sb.append(idDev);
        sb.append(", ").append(idLang);

        sb.append(")");
        return sb.toString();
    }
}
