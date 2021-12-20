package pl.put.poznan.transformer.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;


@SpringBootApplication(scanBasePackages = {"pl.put.poznan.transformer.rest"})
public class LocationApplication {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        SpringApplication.run(LocationApplication.class, args);



        //Read ALL Models from File (Folder> data)
//        DataHolder dataHolder = new DataHolder();
//        dataHolder.readModels();

//      Show data from file
//        dataHolder.showData();

//      Set Building B1 From file
//        Building b1= dataHolder.getBuildingArray().get(0);


// Input data (Manual)

        //najpierw tworzymy pokoje
//       Room r1 = new Room(1,"b1",12,10,1.2f,10.8f);
//       Room r2 = new Room(2, "b1", 1,2,3,4);
//       Room r3 = new Room(3,"b1",21,30,5,8);

//        potem dodajemy je do listy, ktora posluzy nam do utworzenia pietra
//        jedna lista na jedno pietro
//
//        ArrayList roomListA = new ArrayList<Room>();
//        roomListA.add(r1);
//        roomListA.add(r2);
//
//        ArrayList roomsListB = new ArrayList<Room>();
//        roomsListB.add(r3);
//
//        dataHolder.addRoom(r1);
//        dataHolder.addRoom(r2);
//        dataHolder.addRoom(r3);

//        nastepnie tworzymy pietra
//        Floor f1 = new Floor(4,"b1", roomListA);
//        Floor f2 = new Floor(5,"b1",roomsListB);
//
//        dataHolder.addFloor(f1);
//        dataHolder.addFloor(f2);

////        podobnie jak przy pokojach dodajemy je do list, jedna dla kazdego budynku
//        List<Floor> floorsList = new ArrayList<Floor>();
//        floorsList.add(f1);
//        floorsList.add(f2);
//
//
////        na koncu tworzymy budynek
//        Building b1 = new Building(6, "b1", floorsList);
//        dataHolder.addBuilding(b1);

//        System.out.println("Building " + b1.getName() + " Light Power: " + Float.toString(b1.getLight()));
//        System.out.println("Building " + b1.getName() + " Full Area: " + Float.toString(b1.getCube()));
//        System.out.println("Building " + b1.getName() + " Light per Unit: " + Float.toString(b1.getLightPerUnit()));
//
//        List<Room> rooms = b1.getHeatingOverLimit(0.2f);
//        for (Room tRoom : rooms) {
//            System.out.println("Room Heating Over: "+ Integer.toString(tRoom.getId()));
//        }
//        dataHolder.showData();
//        dataHolder.saveModels();




//
    }

    //wszystkie funkcje nazywaja sie tak samo dla kazdej klasy i w zaleznosci z ktorego obiektu sie je wywola daja inny efekt
    //np getArea() dla pokoju zwroci po prostu powierzchnie pokoju, ale dla budynku poda juz laczna sume wszystkich pokojow w budynku itd
    //funkcja getHeatingOverLimit(float limit) zwraca liste pokojow jako liste obiektow typu Room, mozna uzyc na obiekcie kazdej klasy, ale nawet w przypadku pojedynczego pokoju bedzie to lista, wiec trzeba o tym pamietac
    //potem mozna wyswietlic id lub nazwe tych pokojow tak jak zrobilem to w linijkach 49-51
    //najwazniejsze jest to zeby tworzyc obiekty w kolejnosci: pokoje -> pietra -> budynki

}
