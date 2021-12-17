package pl.put.poznan.transformer.models;

import java.util.List;

public abstract class Location {

    private int id;
    private String name;

    public Location(){
    }
    public Location(int id, String name){
        this.id = id;
        this.name = name;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }

    public abstract float getArea();
    public abstract float getCube();
    public abstract float getHeating();
    public abstract float getLight();
    public abstract float getHeatingPerUnit();
    public abstract float getLightPerUnit();
    public abstract List<Room> getHeatingOverLimit(float limit);
}
