package pl.put.poznan.transformer.data;

import org.apache.tomcat.util.bcel.classfile.JavaClass;
import pl.put.poznan.transformer.models.Building;
import pl.put.poznan.transformer.models.Floor;
import pl.put.poznan.transformer.models.Room;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataHolder  {
    private static List<Building> buildingArray;
    private static List<Floor> floorArray;
    private static List<Room> roomArray;
    private String filePath;

    public DataHolder() {
        //Create Arrays for models
        filePath = new String("src/main/java/pl/put/poznan/transformer/data/");
        buildingArray = new ArrayList<>();
        floorArray = new ArrayList<>();
        roomArray = new ArrayList<>();
    }
    public void showData(){
        System.out.println("\n>>Models data from/to file");
        System.out.println("Rooms ID:");
        for(Room room: roomArray){
            System.out.print(" "+ room.getId());
        }
        System.out.println("\nFloors ID:");
        for(Floor floor: floorArray){
            System.out.print(" "+ floor.getId());
        }
        System.out.println("\nBuildings ID:");
        for(Building building: buildingArray){
            System.out.print(" "+ building.getId());
        }
        System.out.println("\n");
    }

    public void saveModels() throws IOException {
       //Save ALL Models to Serializable File .ser

        FileOutputStream buildingOut= new FileOutputStream(filePath + "BuildingLog.ser");
        FileOutputStream floorOut= new FileOutputStream(filePath + "FloorLog.ser");
        FileOutputStream roomOut= new FileOutputStream(filePath + "RoomLog.ser");


        ObjectOutputStream outB = new ObjectOutputStream(buildingOut);
        ObjectOutputStream outF = new ObjectOutputStream(floorOut);
        ObjectOutputStream outR = new ObjectOutputStream(roomOut);

        outB.writeObject(buildingArray);
        outB.close();
        buildingOut.close();

        outF.writeObject(floorArray);
        outF.close();
        floorOut.close();

        outR.writeObject(roomArray);
        outR.close();
        roomOut.close();
    }

    public void saveBuildings() throws IOException {
        //Save Buildings to Serializable File .ser

        FileOutputStream buildingOut= new FileOutputStream(filePath + "BuildingLog.ser");


        ObjectOutputStream outB = new ObjectOutputStream(buildingOut);


        outB.writeObject(buildingArray);
        outB.close();
        buildingOut.close();

    }

    public void saveFloors() throws IOException {
        //Save Floors to Serializable File .ser


        FileOutputStream floorOut= new FileOutputStream(filePath + "FloorLog.ser");


        ObjectOutputStream outF = new ObjectOutputStream(floorOut);


        outF.writeObject(floorArray);
        outF.close();
        floorOut.close();

    }
    public void saveRooms() throws IOException {
        //Save Rooms to Serializable File .ser

        FileOutputStream roomOut= new FileOutputStream(filePath + "RoomLog.ser");


        ObjectOutputStream outR = new ObjectOutputStream(roomOut);



        outR.writeObject(roomArray);
        outR.close();
        roomOut.close();
    }
    public void readModels() throws IOException, ClassNotFoundException {
        //Read ALL Models from Serializable File .ser

        FileInputStream roomIn = new FileInputStream(filePath + "RoomLog.ser");
        FileInputStream floorIn = new FileInputStream(filePath + "FloorLog.ser");
        FileInputStream buildingIn = new FileInputStream(filePath + "BuildingLog.ser");

        ObjectInputStream inR = new ObjectInputStream(roomIn);
        ObjectInputStream inF = new ObjectInputStream(floorIn);
        ObjectInputStream inB = new ObjectInputStream(buildingIn);

        roomArray = (ArrayList<Room>) inR.readObject();
        floorArray = (ArrayList<Floor>) inF.readObject();
        buildingArray = (ArrayList<Building>) inB.readObject();

    }
    public void readRoom() throws IOException, ClassNotFoundException {
        //Read rooms from Serializable File .ser

        FileInputStream roomIn = new FileInputStream(filePath + "RoomLog.ser");


        ObjectInputStream inR = new ObjectInputStream(roomIn);


        roomArray = (ArrayList<Room>) inR.readObject();

    }

    public void readFloors() throws IOException, ClassNotFoundException {
        //Read Floors  from Serializable File .ser


        FileInputStream floorIn = new FileInputStream(filePath + "FloorLog.ser");


        ObjectInputStream inF = new ObjectInputStream(floorIn);


        floorArray = (ArrayList<Floor>) inF.readObject();


    }
    public void readBuildings() throws IOException, ClassNotFoundException {
        //Read Buildings from Serializable File .ser

        FileInputStream buildingIn = new FileInputStream(filePath + "BuildingLog.ser");

        ObjectInputStream inB = new ObjectInputStream(buildingIn);

        buildingArray = (ArrayList<Building>) inB.readObject();

    }

    //ADD element to Array of model <building, room, floor>
    public void addBuilding(Building newBuilding) throws IOException {
        buildingArray.add(newBuilding);
        
    }
    public void addRoom(Room newRoom) throws IOException {
        roomArray.add(newRoom);
    }
    public void addFloor(Floor newFloor) throws IOException {
        floorArray.add(newFloor);
    }


    //GET Array of model <building, floor, room>
    public static List<Building> getBuildingArray() {
        return buildingArray;
    }

    public static List<Floor> getFloorArray() {
        return floorArray;
    }

    public static List<Room> getRoomArray() {
        return roomArray;
    }
}
