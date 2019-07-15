package ru.skwardlow;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App implements Json
{
    public static void main ( String[] args )
    {
        System.out.println( "Hello World!" );
        ObjectMapper om = new ObjectMapper();
        SimpleObject simpleObjectw = new SimpleObject("John",123,123.456);
        try {
            om.writeValue(new File("jack.json"),simpleObjectw);
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    @Override
    public String toJSON() {

        return null;
    }

    @Override
    public void fromJSON(String str) {

    }
}
