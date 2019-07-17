package ru.skwardlow;

public class SimpleObject {
    private String objectName;
    private Integer objectCounter;
    private Double isThatTrue;

    SimpleObject(){
        this.objectName = null;
        this.objectCounter = null;
        this.isThatTrue = null;
    }

    SimpleObject(String objectName,Integer objectCounter,Double isThatTrue){
        this.objectName = objectName;
        this.objectCounter = objectCounter;
        this.isThatTrue = isThatTrue;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public Integer getObjectCounter() {
        return objectCounter;
    }

    public void setObjectCounter(Integer objectCounter) {
        this.objectCounter = objectCounter;
    }

    public Double getIsThatTrue() {
        return isThatTrue;
    }

    public void setIsThatTrue(Double isThatTrue) {
        this.isThatTrue = isThatTrue;
    }

    @Override
    public String toString() {
        return objectName.toString()+" "+objectCounter.toString()+" "+isThatTrue.toString();
    }
}
