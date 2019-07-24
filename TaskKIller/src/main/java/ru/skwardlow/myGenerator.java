package ru.skwardlow;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Pattern;
/**
 * This class is using for Generate some ArrayList of current working processes
**/
public class myGenerator {
    private static final String PROC_PATH = "/proc/";
    private static final Pattern pattern = Pattern.compile("^(/proc/)[0-9]+");
    private ArrayList<myProcess> processes = new ArrayList<>();

    myGenerator() throws IOException{
        File file = new File(PROC_PATH);
        File[] getALL = file.listFiles();
        String[] splittedStat;
        for (File value : getALL) {
            if (pattern.matcher(value.toString()).matches()) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(value + "/stat"));
                splittedStat = bufferedReader.readLine().split(" ");
                myProcess myProc = new myProcess(splittedStat[0], splittedStat[1], splittedStat[2]);
                processes.add(myProc);

            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (myProcess myproc:processes) {
            sb.append(myproc.toString()).append("\n");
        }
        return sb.toString();
    }
}
