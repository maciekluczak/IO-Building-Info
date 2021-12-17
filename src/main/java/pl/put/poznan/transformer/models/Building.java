package pl.put.poznan.transformer.models;

import java.util.ArrayList;
import java.util.List;

public class Building extends Location{
    private List<Floor> floors;

    public Building(int id, String name, List<Floor> floors){
        super(id, name);
        this.floors = floors;
    }

    public float getArea(){
        float sumArea = 0;
        for (Floor tFloor : this.floors){
            sumArea += tFloor.getArea();
        }
        return sumArea;
    }
    public float getCube(){
        float sumCube = 0;
        for (Floor tFloor : this.floors){
            sumCube += tFloor.getCube();
        }
        return sumCube;
    }
    public float getHeating(){
        float sumHeating = 0;
        for (Floor tFloor : this.floors){
            sumHeating += tFloor.getHeating();
        }
        return sumHeating;
    }
    public float getLight(){
        float sumLight = 0;
        for (Floor tFloor : this.floors){
            sumLight += tFloor.getLight();
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
    public List<Room> getHeatingOverLimit(float limit){
        List<Room> list = new ArrayList<Room>();
        for (Floor tFloor : this.floors){
            for (Room tRoom : tFloor.getRooms()){
                if (tRoom.getHeatingPerUnit() > limit) {
                    list.add(tRoom);
                }
            }
        }
        return list;
    }
}
