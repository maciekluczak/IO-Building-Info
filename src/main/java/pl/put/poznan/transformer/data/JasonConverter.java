package pl.put.poznan.transformer.data;

import pl.put.poznan.transformer.models.Building;
import pl.put.poznan.transformer.models.Floor;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.put.poznan.transformer.models.Room;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JasonConverter {
    public JasonConverter() throws IOException, ClassNotFoundException {
        DataHolder dataHolder = new DataHolder();
        dataHolder.readModels();
        System.out.println(dataHolder.getRoomArray());

        //Floor f1 = dataHolder.getFloorArray().get(0);
        //Floor f2 = dataHolder.getFloorArray().get(0);
        //List<Floor> floorsList = new ArrayList<Floor>();
        //floorsList.add(f1);
        //floorsList.add(f2);
        //Building b1 = new Building(6, "b1", floorsList);

        Building b1= dataHolder.getBuildingArray().get(0);

        try {
            System.out.println("CO JESTSRFDS");
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File("target/buildings.json"), b1);

           // Building bobBudowniczy = objectMapper.readValue(new File("target/buildings.json"), Building.class);
           // String carAsString = objectMapper.writeValueAsString(bobBudowniczy);
        }
        catch (final Exception e){
            e.printStackTrace();
        }
    }
}
