package zombicide.action;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import zombicide.action.actionZombie.AttackZombie;
import zombicide.actor.survivor.Survivor;
import zombicide.actor.zombie.Zombie;
import zombicide.actor.zombie.type.Walker;

import zombicide.map.cell.Cell;
import zombicide.map.cell.Room;

public class ActionAttackZombieTest {

    @Test
    public void make_AttacksSurvivorWhenAvailable(){
        Zombie zombie = new Walker();
        AttackZombie action = new AttackZombie(zombie);
        Cell cell = new Room();
        Survivor survivor1 = new Survivor("Survivor1");
        survivor1.setCell(cell);
        zombie.setCell(cell);
        cell.welcomeActor(zombie);
        cell.welcomeActor(survivor1);
        // Act
        zombie.makeAction(action, cell);
        assertEquals(3,survivor1.getLifePoints());
        }

    @Test
    public void make_NoSurvivorInCell() {
        // Arrange
        Zombie zombie = new Walker();
        AttackZombie action = new AttackZombie(zombie);
        Cell cell = new Room();
        zombie.setCell(cell);
        cell.welcomeActor(zombie);

        // Act
            zombie.makeAction(action, cell);
            assertEquals(0, cell.howManySurvivors());
    }
}
