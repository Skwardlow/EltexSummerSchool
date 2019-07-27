package ru.skwardlow;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main ( String[] args )
    {
        System.out.println( "Hello World!" );
        ObjectMapper om = new ObjectMapper();
        SimpleObject simpleObjectw = new SimpleObject("John",123,123.456);
        SimpleObject simpleObjectr = new SimpleObject();
        try {
            om.writeValue(new File("jack.json"),simpleObjectw);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
           // BufferedReader br = new BufferedReader(new FileReader("1.txt"));
           // br.toString();
            simpleObjectr = om.readValue(new File("jack.json"),(SimpleObject.class));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(simpleObjectr.toString());
    }

}
