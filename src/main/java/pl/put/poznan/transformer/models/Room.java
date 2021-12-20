package pl.put.poznan.transformer.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa pokoju w budynku
 */
public class Room extends Location {
    private float area, cube, heating, light;

    /**
     * konstruktor z parametrami:
     *
     * @param name      nazwa pokoju
     * @param area      powierzchnia pokoju
     * @param cube      kubatura pokoju
     * @param heating   poziom zuzycia energii ogrzewania
     * @param light     laczna moc oswietlenia w pokoju
     */

    public Room( String name, float area, float cube, float heating, float light){
        super( name);
        this.area = area;
        this.cube = cube;
        this.heating = heating;
        this.light = light;
    }

    /**
     * funkcja zwracajaca powierzchnie pokoju
     *
     * @return powierzchnia pokoju
     */
    public float getArea(){
        return area;
    }

    /**
     * funkcja zwracajaca kubature pokoju
     *
     * @return kubatura pokoju
     */
    public float getCube(){
        return cube;
    }

    /**
     * funkcja zwracajaca energie na ogrzewanie w pokoju
     *
     * @return energia na ogrzewanie w pokoju
     */
    public float getHeating(){
        return heating;
    }

    /**
     * funkcja zwracajaca moc oswietlenia
     *
     * @return moc oswietlenia
     */
    public float getLight(){
        return light;
    }

    /**
     * funkcja zwracajaca srednia energie na ogrzewanie na m2
     *
     * @return srednie zuzycie energii na m2
     */
    public  float getHeatingPerUnit(){
        return heating/area;
    }

    /**
     * funkcja zwracajaca srednia moc oswietlenia na m3
     *
     * @return srednia moc oswietlenia na m3
     */
    public  float getLightPerUnit(){
        return light/cube;
    }

    /**
     * funkcja sprawdzajaca czy pokoj przekracza limit wykorzystania energii na ogrzewanie
     *
     * @param limit     wartosc limitu dopuszczanego zuzycia energii
     * @return lista pokojow przekraczajacych limit zuzycia
     */
    public List<Room> getHeatingOverLimit(float limit){
        List<Room> roomsList = new ArrayList<Room>();
        float heatingPU = this.heating / this.cube;
        if (heatingPU > limit){
            roomsList.add(this);
        }
        return roomsList;
    }

}
