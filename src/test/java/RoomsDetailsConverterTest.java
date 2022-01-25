import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.put.poznan.transformer.models.Room;
import pl.put.poznan.transformer.other.OtherRoomsDTO;
import pl.put.poznan.transformer.other.RoomsDetailsConverter;

public class RoomsDetailsConverterTest {
    private RoomsDetailsConverter toTest;

    @Test
    public void convert_simpleCase_convertSuccess(){

        //given
        toTest = new RoomsDetailsConverter();
        OtherRoomsDTO itemToTest = creatMock();

        //when
        Room room = toTest.convert(itemToTest);

        //then
        Assertions.assertEquals(room.getName(), "3");
        Assertions.assertEquals(room.getArea(), Float.valueOf(20));
        Assertions.assertEquals(room.getCube(), Float.valueOf(30));
        Assertions.assertEquals(room.getHeating(), Float.valueOf(20));
        Assertions.assertEquals(room.getLight(), Float.valueOf(18));
    }

    private OtherRoomsDTO creatMock() {
        OtherRoomsDTO mock = Mockito.mock(OtherRoomsDTO.class);
        Mockito.when(mock.getId()).thenReturn(3);
        Mockito.when(mock.getArea()).thenReturn(20);
        Mockito.when(mock.getCube()).thenReturn(30);
        Mockito.when(mock.getHeating()).thenReturn(20);
        Mockito.when(mock.getLight()).thenReturn(18);
        return mock;

    }

}
