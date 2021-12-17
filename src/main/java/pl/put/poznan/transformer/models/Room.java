package pl.put.poznan.transformer.models;

import java.util.ArrayList;
import java.util.List;

public class Room extends Location {
    private float area;
    private float cube;
    private float heating;
    private float light;

    public Room(int id, String name, float area, float cube, float heating, float light){
        super(id, name);
        this.area = area;
        this.cube = cube;
        this.heating = heating;
        this.light = light;
    }

    public float getArea(){
        return area;
    }
    public float getCube(){
        return cube;
    }
    public float getHeating(){
        return heating;
    }
    public float getLight(){
        return light;
    }
    public  float getHeatingPerUnit(){
        return heating/area;
    }
    public  float getLightPerUnit(){
        return light/cube;
    }


    public List<Room> getHeatingOverLimit(float limit){
        List<Room> roomsList = new ArrayList<Room>();
        float heatingPU = this.heating / this.cube;
        if (heatingPU > limit){
            roomsList.add(this);
        }
        return roomsList;
    }
}
