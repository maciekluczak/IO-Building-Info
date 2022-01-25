package pl.put.poznan.transformer.models;

import java.util.ArrayList;
import java.util.List;

/**
 * klasa pietra w budynku
 */
public class Floor extends Location {
    private List<Room> rooms;

    /**
     * konstruktor z parametrami:
     *
     * @param name      nazwa pietra
     * @param rooms     lista pokojow znajdujacych sie na pietrze
     */
    public Floor( String name, List<Room> rooms){
        super(name);
        this.rooms = rooms;
    }


    /**
     * funkcja zwracajaca laczna powierzchnia pokoi na pietrze
     *
     * @return  powierzchnia pokoi na pietrze
     */
    public float getArea(){
        float sumArea = 0;
        for (Room tRoom : this.rooms){
            sumArea += tRoom.getArea();
        }
        return sumArea;
    }

    /**
     * funkcja zwracajaca laczna kubatura pokoi na pietrze
     *
     * @return kubatura pokoi na pietrze
     */
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

    /**
     * funkcja zwracajaca laczna moc oswietlenia pietra
     *
     * @return moc oswietlenia pietra
     */
    public float getLight(){
        float sumLight = 0;
        for (Room tRoom : this.rooms){
            sumLight += tRoom.getLight();
        }
        return sumLight;
    }

    /**
     * funkcja zwracajaca srednie zucycie energii na ogrzewanie pietra na m2
     *
     * @return srednie zuzycie energii na m2
     */
    public float getHeatingPerUnit(){
        float sumHeating = this.getHeating();
        float sumArea = this.getArea();
        return sumHeating / sumArea;
    }

    /**
     * funkcja zwracajaca srednia moc oswietlenia pietra na m3
     *
     * @return srednia moc oswietlenia na m3
     */
    public float getLightPerUnit(){
        float sumLight = this.getLight();
        float sumCube = this.getCube();
        return sumLight / sumCube;
    }
    public List<Room> getRooms(){
        return this.rooms;
    }


    /**
     * funkcja zwracajaca liste pokojow przekraczajacych limit zuzycia energii na ogrzewanie
     *
     * @param limit     limit dopuszczalnego zucycia energii na ogrzewanie
     * @return  lista pokojow przekraczajacych limit zucycia energii
     */
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
