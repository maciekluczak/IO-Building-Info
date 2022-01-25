import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.models.Room;

import static org.junit.jupiter.api.Assertions.*;

public class RoomTest {

    @Test
    public void testingInput_nameNull_throwsIllegalArgumentException(){

        //given
        String name = null;
        float area = 20;
        float cube = 40;
        float heating = 54;
        float light = 21;
        Room room = new Room();

        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> room.testingInput(name, area, cube, heating, light));
    }

    @Test
    public void  testingInput_allValueOk_resultTrue(){

        //given
        String name = "building1";
        float area = 23;
        float cube = 42;
        float heating = 31;
        float light = 59;
        Room room = new Room();

        //when
        boolean result = room.testingInput(name, area, cube, heating, light);

        //then
        Assertions.assertTrue(result);
    }

    @Test
    public void  testingInput_areaTooHigh_resultFalse(){

        //given
        String name = "Hamilton";
        float area = 300;
        float cube = 179;
        float heating = 99;
        float light = 99;
        Room room = new Room();

        //when
        boolean result = room.testingInput(name, area, cube, heating, light);

        //then
        Assertions.assertFalse(result);
    }

    @Test
    public void  testingInput_lightLessThanZero_throwsIllegalArgumentException(){

        //given
        String name = "b12";
        float area = 14;
        float cube = 40;
        float heating = 70;
        float light = -3;
        Room room = new Room();

        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> room.testingInput(name, area, cube, heating, light));
    }

    @Test
    public void  testingInput_valuesEquelMinOrMax_resultFalse(){

        //given
        String name = "mickiewicza44";
        float area = 60;
        float cube = 1;
        float heating = 100;
        float light = 0;
        Room room = new Room();

        //when
        boolean result = room.testingInput(name, area, cube, heating, light);

        //then
        Assertions.assertFalse(result);
    }
}
