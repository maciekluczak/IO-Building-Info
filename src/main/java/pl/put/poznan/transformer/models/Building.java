package pl.put.poznan.transformer.models;

import java.util.ArrayList;
import java.util.List;


/**
 * klasa budynku
 */
public class Building extends Location{
    private List<Floor> floors;

    /**
     * konstruktor o parametrach:
     *
     * @param name      nazwa budynku
     * @param floors    lista pieter w budynku
     */
    public Building( String name, List<Floor> floors){
        super(name);
        this.floors = floors;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    /**
     * funkcja zwracajaca laczna powierzchnie pokoi w budynku
     *
     * @return laczna powierzchnia budynku
     */

    public float getArea(){
        float sumArea = 0;
        for (Floor tFloor : this.floors){
            sumArea += tFloor.getArea();
        }
        return sumArea;
    }

    /**
     * funkcja zwracajaca laczna kubature pokoi w budynku
     *
     * @return laczna kubatura budynku
     */
    public float getCube(){
        float sumCube = 0;
        for (Floor tFloor : this.floors){
            sumCube += tFloor.getCube();
        }
        return sumCube;
    }

    /**
     * funkcja zwracajaca laczne zucycie energii na ogrzewanie budynku
     *
     * @return laczne zuzycie energii
     */
    public float getHeating(){
        float sumHeating = 0;
        for (Floor tFloor : this.floors){
            sumHeating += tFloor.getHeating();
        }
        return sumHeating;
    }

    /**
     * funkcja zwracajaca laczna moc oswietlenia w budynku
     *
     * @return laczna moc oswietlenia
     */
    public float getLight(){
        float sumLight = 0;
        for (Floor tFloor : this.floors){
            sumLight += tFloor.getLight();
        }
        return sumLight;
    }

    /**
     * funkcja zwracajaca srednie zuzycie energii na ogrzewanie budydnku
     *
     * @return srednuie zucycie energii na ogrzewanie budynku na m2
     */
    public float getHeatingPerUnit(){
        float sumHeating = this.getHeating();
        float sumArea = this.getArea();
        return sumHeating / sumArea;
    }

    /**
     * funkcja zwracajaca srednia moc oswietlenia budynku na m3
     *
     * @return srednia moc oswietlenia budynku
     */
    public float getLightPerUnit(){
        float sumLight = this.getLight();
        float sumCube = this.getCube();
        return sumLight / sumCube;
    }

    /**
     * funkcja sprawdzajaca pokoje przekraczajace dopuszczalmny limit zuzycia energii na ogrzewanie
     *
     * @param limit     limit zuzycia energii na ogrzewanie
     * @return  lista pokojow przekraczajacyh dopuszczalne zuzcyie energii
     */
    public List<Room> getHeatingOverLimit(float limit){
        List<Room> list = new ArrayList<Room>();
        for (Floor tFloor : this.floors){
            for (Room tRoom : tFloor.getRooms()) {
                if (tRoom.getHeatingPerUnit() > limit) {
                    list.add(tRoom);
                }
            }
        }
        return list;
    }
}
