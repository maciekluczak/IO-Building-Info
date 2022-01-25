package pl.put.poznan.transformer.other;

public class OtherRoomsDTO {
    private int id;
    private int area;
    private int cube;
    private int heating;
    private int light;
    private int water;

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getArea(){
        return area;
    }
    public void setArea(int area){
        this.area = area;
    }
    public int getCube(){
        return cube;
    }
    public void setCube(int cube){
        this.cube = cube;
    }
    public int getHeating(){
        return heating;
    }
    public void setHeating(int heating){
        this.heating = heating;
    }
    public int getLight(){
        return light;
    }
    public void setLight(int light){
        this.light = light;
    }
    public int getWater(){
        return water;
    }
    public void setWater(int water){
        this.water = water;
    }
}
