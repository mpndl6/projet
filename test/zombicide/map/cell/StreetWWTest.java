import zombicide.map.util.Position;
import static org.junit.jupiter.ap.Assertion.assertEquals;
import org.junit.jupiter.api.Test;

public class StreetWWTest {
    @Test
    public void streetWW(){
        Position position = new Position(3,4);

        StreetWW streetWW=new StreetWW(position);

        assertEquals(position, streetWW.getPosition());
    }
}