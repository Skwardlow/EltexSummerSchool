package ru.skwardlow;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
                myProcess myProc = new myProcess(splittedStat[0], splittedStat[1], splittedStat[2],
                        value.toString());
                processes.add(myProc);

            }
        }
    }

    public void dirDeleter(String dir)throws IOException{
                Path delPath = Paths.get(dir);
                List<Path> pathsToDelete = Files.walk(delPath).
                        sorted(Comparator.reverseOrder()).collect(Collectors.toList());
                for(Path path : pathsToDelete) {
                   Files.deleteIfExists(path);
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
