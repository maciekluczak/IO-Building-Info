package pl.put.poznan.transformer.models;

import java.util.ArrayList;
import java.util.List;

public class Floor extends Location {
    private List<Room> rooms;


    public Floor(int id, String name, List<Room> rooms){
        super(id, name);
        this.rooms = rooms;
    }

    public float getArea(){
        float sumArea = 0;
        for (Room tRoom : this.rooms){
            sumArea += tRoom.getArea();
        }
        return sumArea;
    }
    public float getCube(){
        float sumCube = 0;
        for (Room tRoom : this.rooms){
            sumCube += tRoom.getCube();
        }
        return sumCube;
    }
    public float getHeating(){
        float sumHeating = 0;
        for (Room tRoom : this.rooms){
            sumHeating += tRoom.getHeating();
        }
        return sumHeating;
    }
    public float getLight(){
        float sumLight = 0;
        for (Room tRoom : this.rooms){
            sumLight += tRoom.getLight();
        }
        return sumLight;
    }
    public float getHeatingPerUnit(){
        float sumHeating = this.getHeating();
        float sumArea = this.getArea();
        return sumHeating / sumArea;
    }
    public float getLightPerUnit(){
        float sumLight = this.getLight();
        float sumCube = this.getCube();
        return sumLight / sumCube;
    }
    public List<Room> getRooms(){
        return this.rooms;
    }
    public List<Room> getHeatingOverLimit(float limit){
        List<Room> list = new ArrayList<Room>();
        for (Room tRoom : this.rooms){
            if (tRoom.getHeatingPerUnit() > limit){
                list.add(tRoom);
            }
        }
        return list;
    }

}
