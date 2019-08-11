package ru.skwardlow.interfaces;

import java.io.IOException;

public interface JSON {
    void writeToJSON() throws IOException;
    void readFromJSON() throws IOException;
}
