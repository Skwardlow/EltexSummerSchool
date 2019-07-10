package ru.skwardlow;

import java.util.Collection;

public class Task<T extends User,V extends  User>implements CSV {
    private Collection<User> collection;

    @Override
    public void writeToCSV() {

    }

    @Override
    public void readFromCSV() {

    }
}
