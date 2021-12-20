package pl.put.poznan.transformer.models;

import java.io.Serializable;
import java.util.List;

/**
 * abstrakcyjna klasa lokacji z ktorej dziedzicza klasy:
 *          Room
 *          Building
 *          Floor
 */
public abstract class Location implements Localization, Serializable {
    private static int count = 0;
    private int id;
    private String name;

    /**
     * pusty konstruktor
     */
    public Location(){
    }

    /**
     * konstruktor o parametrach:
     *
     * @param name  nazwa lokacji
     */
    public Location(String name){
        this.id = ++count;
        this.name = name;
    }

    /**
     * funkcja zwracajaca id lokacji
     *
     * @return  id lokacji
     */
    public int getId(){
        return id;
    }

    /**
     * funkcja zwracajaca nazwe lokacji
     *
     * @return nazwa lokacji
     */
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
