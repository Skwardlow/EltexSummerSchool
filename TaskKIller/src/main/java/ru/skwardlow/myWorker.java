package ru.skwardlow;

import java.io.IOException;

public class myWorker {
    myWorker(){

    }

    public void killProc(String PID)throws IOException {
        Runtime.getRuntime().exec("kill -SIGKILL "+PID);
    }
}
