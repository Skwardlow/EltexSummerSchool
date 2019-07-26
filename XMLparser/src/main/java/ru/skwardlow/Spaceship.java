package ru.skwardlow;

public class Spaceship {
    private String weight;
    private String name;
    private String shipClass;

    Spaceship(){
        weight = null;
        name = null;
        shipClass = null;
    }

    Spaceship(String weight, String name, String shipClass){
        this.weight = weight;
        this.name = name;
        this.shipClass = shipClass;
    }

    @Override
    public String toString() {
        return this.weight+"\n"+this.name+"\n"+this.shipClass;
    }
}
