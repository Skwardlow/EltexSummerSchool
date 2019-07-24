package ru.skwardlow;

public class myProcess {
    private String processID;
    private String nameOfProcess;
    private String currentStatus;

    myProcess(){
        processID = null;
        nameOfProcess = null;
        currentStatus = null;
    }

    public myProcess(String processID, String nameOfProcess, String currentStatus) {
        this.processID = processID;
        this.nameOfProcess = nameOfProcess;
        this.currentStatus = currentStatus;
    }

    @Override
    public String toString() {
        return processID+" "+nameOfProcess+" "+currentStatus;
    }
}
