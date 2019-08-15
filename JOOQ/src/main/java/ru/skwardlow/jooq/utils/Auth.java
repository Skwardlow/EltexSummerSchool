package ru.skwardlow.jooq.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Auth {
    private static String HOST;
    private static String LOGIN;
    private static String PASSWD;

    static  {
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("src/main/resources/config.properties"));
            System.out.println(prop.toString());
            HOST = prop.getProperty("db.host");
            LOGIN = prop.getProperty("db.login");
            PASSWD = prop.getProperty("db.password");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String getHOST() {
        return HOST;
    }

    public static String getLOGIN() {
        return LOGIN;
    }

    public static String getPASSWD() {
        return PASSWD;
    }
}
