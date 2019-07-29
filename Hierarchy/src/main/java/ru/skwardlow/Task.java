package ru.skwardlow;

import lombok.Getter;
import lombok.Setter;

import java.io.*;

public class Task<T extends User,V extends  User>implements CSV {
    private static final String taskWorkPath = "Tasks.csv";
    @Setter @Getter
    private T firstClone;
    @Setter @Getter
    private V secondClone;
    private Byte id1=1, id2=2;


    public Task(){
        this.firstClone = null;
        this.secondClone = null;
    }

    public Task(T firstClone, V secondClone){
        this.firstClone=firstClone;
        this.secondClone=secondClone;
    }

    @Override
    public String toString() {
        return "Task - " + "," + firstClone.getUserid() + "," + secondClone.getUserid() +
                "," + "god pls help me";
    }

    @Override
    public void writeToCSV() {
        FileWriter fw;
        try {
            fw = new FileWriter(new File(taskWorkPath),false);
            fw.write(this.toString());
            // fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void readFromCSV() {
        String csvSplitBy = ",";
        try {
            BufferedReader br = new BufferedReader(new FileReader(taskWorkPath));
            String[] data = br.readLine().split(csvSplitBy);

            Integer currFirstId = Integer.valueOf(data[1]);
            Integer currSevonId = Integer.valueOf(data[2]);
            if (currFirstId.equals(1)){
                this.firstClone =(T) new Developer();
                firstClone.setUserid(id1);
            }

            if (currFirstId.equals(2)){
                this.firstClone =(T) new Manager();
                firstClone.setUserid(id2);
            }

            if (currSevonId.equals(1)){
                this.secondClone =(V) new Developer();
                secondClone.setUserid(id1);
            }
            if (currSevonId.equals(2)){
                this.secondClone =(V) new Manager();
                secondClone.setUserid(id2);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
