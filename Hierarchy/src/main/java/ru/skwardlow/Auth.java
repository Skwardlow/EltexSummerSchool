package ru.skwardlow;

import lombok.Getter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Auth {
    @Getter
    private static String HOST;
    @Getter
    private static String LOGIN;
    @Getter
    private static String PASSWD;

    static  {
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("src/main/resources/cfg/config.properties"));
            System.out.println(prop.toString());
            HOST = prop.getProperty("db.host");
            LOGIN = prop.getProperty("db.login");
            PASSWD = prop.getProperty("db.password");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
