package ru.skwardlow.utils;

public class Man {
    public static String TEST_HELLO="lalalah";
    private String name;

    public static String getTestHello() {
        return TEST_HELLO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void setTestHello(String testHello) {
        TEST_HELLO = testHello;
    }
}
