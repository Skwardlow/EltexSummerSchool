package ru.skwardlow;

public class myProcess {
    private String processID;
    private String nameOfProcess;
    private String currentStatus;
    private String procPath;

    myProcess(){
        processID = null;
        nameOfProcess = null;
        currentStatus = null;
        procPath = null;
    }

    public myProcess(String processID, String nameOfProcess, String currentStatus, String procPath) {
        this.processID = processID;
        this.nameOfProcess = nameOfProcess;
        this.currentStatus = currentStatus;
        this.procPath = procPath;
    }

    public String getProcessID() {
        return processID;
    }

    public String getProcPath() {
        return procPath;
    }

    @Override
    public String toString() {
        return processID+" "+nameOfProcess+" "+currentStatus;
    }
}
