package org.eltex.mavTest.root;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.LinkedHashMap;

public class unitFile {
    public static void main(String[] args) throws IOException {
        String json = "{\"name\": \"alex\"}";
        ObjectMapper om = new ObjectMapper();
        LinkedHashMap<String,String> linkedHashMap =
                om.readValue(json,LinkedHashMap.class);
        System.out.println(linkedHashMap.toString());
        System.out.println("Ahaha");
    }
}
