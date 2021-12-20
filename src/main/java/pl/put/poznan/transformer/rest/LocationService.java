package pl.put.poznan.transformer.rest;

import pl.put.poznan.transformer.models.Building;
import pl.put.poznan.transformer.models.Floor;
import org.springframework.stereotype.Service;
import pl.put.poznan.transformer.models.Room;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocationService {
    private List<Building> buildingList;

    LocationService() {
        buildingList = new ArrayList<>();
//        Room r1 = new Room("b1", 12, 10, 1.2f, 10.8f);
//        Room r2 = new Room("b1", 1, 2, 3, 4);
//        Room r3 = new Room("b1", 21, 30, 5, 8);
//        var roomListA = new ArrayList<Room>();
//        roomListA.add(r1);
//        roomListA.add(r2);
//        var roomsListB = new ArrayList<Room>();
//        roomsListB.add(r3);
//        Floor f1 = new Floor("b1", roomListA);
//        Floor f2 = new Floor("b1", roomsListB);
//        List<Floor> floorsList = new ArrayList<Floor>();
//        floorsList.add(f1);
//        floorsList.add(f2);
//        Building building = new Building("b1", floorsList);
//       buildingList.add(building);
    }

    public List<Building> getAllBuildingsList() {
        return this.buildingList;
    }

    public void addBuilding(Building building) {
        buildingList.add(building);
    }

    public float getFloorArea(int id) {
        List<Floor> allFloors = new ArrayList<>();
        buildingList.forEach((building -> {
            allFloors.addAll(building.getFloors());
        }));
        for (Floor floor : allFloors) {
            if (floor.getId() == id) {
                return floor.getArea();
            }
        }
        return 0;
    }

    public float getRoomArea(int id) {
        List<Floor> allFloors = new ArrayList<>();
        List<Room> allRooms = new ArrayList<>();
        buildingList.forEach((building -> {
            allFloors.addAll(building.getFloors());
        }));
        allFloors.forEach(floor -> {
            allRooms.addAll(floor.getRooms());
        });
        for (Room room : allRooms) {
            if (room.getId() == id) {
                return room.getArea();
            }
        }
        return 0;
    }

    public float getBuildingArea(int id) {
        for (Building building : buildingList) {
            if (building.getId() == id) {
                return building.getArea();
            }
        }
        return 0;
    }
    public float getFloorCube(int id) {
        List<Floor> allFloors = new ArrayList<>();
        buildingList.forEach((building -> {
            allFloors.addAll(building.getFloors());
        }));
        for (Floor floor : allFloors) {
            if (floor.getId() == id) {
                return floor.getArea();
            }
        }
        return 0;
    }

    public float getRoomCube(int id) {
        List<Floor> allFloors = new ArrayList<>();
        List<Room> allRooms = new ArrayList<>();
        buildingList.forEach((building -> {
            allFloors.addAll(building.getFloors());
        }));
        allFloors.forEach(floor -> {
            allRooms.addAll(floor.getRooms());
        });
        for (Room room : allRooms) {
            if (room.getId() == id) {
                return room.getCube();
            }
        }
        return 0;
    }

    public float getBuildingCube(int id) {
        for (Building building : buildingList) {
            if (building.getId() == id) {
                return building.getCube();
            }
        }
        return 0;
    }
    public float getFloorLightning(int id) {
        List<Floor> allFloors = new ArrayList<>();
        buildingList.forEach((building -> {
            allFloors.addAll(building.getFloors());
        }));
        for (Floor floor : allFloors) {
            if (floor.getId() == id) {
                return floor.getLightPerUnit();
            }
        }
        return 0;
    }

    public float getRoomLightning(int id) {
        List<Floor> allFloors = new ArrayList<>();
        List<Room> allRooms = new ArrayList<>();
        buildingList.forEach((building -> {
            allFloors.addAll(building.getFloors());
        }));
        allFloors.forEach(floor -> {
            allRooms.addAll(floor.getRooms());
        });
        for (Room room : allRooms) {
            if (room.getId() == id) {
                return room.getLightPerUnit();
            }
        }
        return 0;
    }

    public float getBuildingLightning(int id) {
        for (Building building : buildingList) {
            if (building.getId() == id) {
                return building.getLightPerUnit();
            }
        }
        return 0;
    }
    public float getRoomHeating(int id){
        List<Floor> allFloors = new ArrayList<>();
        List<Room> allRooms = new ArrayList<>();
        buildingList.forEach((building -> {
            allFloors.addAll(building.getFloors());
        }));
        allFloors.forEach(floor -> {
            allRooms.addAll(floor.getRooms());
        });
        for (Room room : allRooms) {
            if (room.getId() == id) {
                return room.getHeatingPerUnit();
            }
        }
        return 0;
    }
    public float getBuildingHeating(int id){
        for (Building building : buildingList) {
            if (building.getId() == id) {
                return building.getHeatingPerUnit();
            }
        }
        return 0;
    }
    public float getFloorHeating(int id) {
        List<Floor> allFloors = new ArrayList<>();
        buildingList.forEach((building -> {
            allFloors.addAll(building.getFloors());
        }));
        for (Floor floor : allFloors) {
            if (floor.getId() == id) {
                return floor.getHeatingPerUnit();
            }
        }
        return 0;
    }
    public List<Room> getOverusingRooms(float limit){
        List<Floor> allFloors = new ArrayList<>();
        List<Room> allRooms = new ArrayList<>();
        List<Room> returnList = new ArrayList<>();
        buildingList.forEach((building -> {
            allFloors.addAll(building.getFloors());
        }));
        allFloors.forEach(floor -> {
            allRooms.addAll(floor.getRooms());
        });
        for (Room room : allRooms) {
            if (room.getHeatingPerUnit()> limit) {
                returnList.add(room);
            }
        }
        return returnList;
    }
}
