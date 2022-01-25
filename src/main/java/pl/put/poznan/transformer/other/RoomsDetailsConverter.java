package pl.put.poznan.transformer.other;
import pl.put.poznan.transformer.models.Room;

import  java.util.stream.Collectors;
import java.util.List;

public class RoomsDetailsConverter {
    public Room convert(OtherRoomsDTO dto){
        String name = String.valueOf(dto.getId());
        float area = dto.getArea();
        float cube = dto.getCube();
        float heating = dto.getHeating();
        float light = dto.getLight();

        Room room = new Room(name, area, cube, heating, light);
        return room;
    }
}
