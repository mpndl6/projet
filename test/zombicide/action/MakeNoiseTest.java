package zombicide.action;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import zombicide.actor.survivor.Survivor;
import zombicide.map.cell.Cell;
import zombicide.map.cell.Room;
import zombicide.action.MakeNoise;
import zombicide.map.cell.Street;

public class MakeNoiseTest {

    @Test
    public void make_SuccessfullyMakesNoiseInRoom() throws Exception {
        // Arrange
        Survivor survivor = new Survivor("Survivor1");
        Cell cell = new Room();
        survivor.setCell(cell);
        MakeNoise makeNoise = new MakeNoise(survivor);
        survivor.makeAction(makeNoise,cell);
        assertEquals(1,cell.getNoiseLevel());
    }
}