package pl.put.poznan.transformer.models;

import java.util.List;

public interface Localization {
    float getArea();
    float getCube();
    float getHeating();
    float getLight();
    float getHeatingPerUnit();
    float getLightPerUnit();
    List<Room> getHeatingOverLimit(float limit);
}
