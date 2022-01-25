package pl.put.poznan.transformer.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa pokoju w budynku
 */
public class Room extends Location  {
    private float area, cube, heating, light;

    /**
     * pusty konstruktor
     */
    public Room(){
    }

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
        if(testingInput(name, area, cube, heating, light)){
            this.area = area;
            this.cube = cube;
            this.heating = heating;
            this.light = light;
        }
        else{
            throw new IllegalArgumentException("Incorrect input values");
        }
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

    /**
     * funkcja  sluzacy do oceny poprawnosci danych wejsciowych
     * @param name
     * @param area
     * @param cube
     * @param heating
     * @param light
     * @return true/false
     */

    public boolean testingInput(String name, float area, float cube, float heating, float light){

        if(name == null){
            throw new IllegalArgumentException("input name can not be null");
        }

        boolean isAreaCorrect = isCorrect(area, ParamValues.AREA);
        boolean isCubeCorrect = isCorrect(cube, ParamValues.CUBE);
        boolean isHeatingCorrect = isCorrect(heating, ParamValues.HEATING);
        boolean isLightCorrect = isCorrect(light, ParamValues.LIGHT);
        if (isAreaCorrect && isCubeCorrect && isHeatingCorrect && isLightCorrect){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * funkcja pomocnicza sluzacy do oceny poprawnosci danych wejsciowych
     * @param value
     * @param validValues
     * @return prawda/falsz
     */

    private boolean isCorrect(float value, ParamValues validValues){
        if(value < 0) {
            throw new IllegalArgumentException("Incorrect input values");
        }

        float maxValue = validValues.getMaxValue();
        float minValue = validValues.getMinValue();
        if (value > minValue && value < maxValue) {
            return true;
        }
        return false;
    }

}
