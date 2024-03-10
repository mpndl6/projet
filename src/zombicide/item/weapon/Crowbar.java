package zombicide.item.weapon;

/**
 * The class Crowbar represents a specific type of weapon, extending the Weapon class, for use in the game Zombicide.
 * It implements the characteristics and behavior of a Crowbar weapon.
 */
public class Crowbar extends Weapon{

    /**
     * Construct a new Crowbar
     * minimum range : 0
     * maximum range : 0
     * damage : 1
     * threshold : 4
     */
    public Crowbar(){
        super(0,0,1,4);
    }
    /**
     * Abstract method to determine the number of dice rolls needed for this weapon.
     * @return The number of dice rolls needed for this weapon.
     */
    @Override
    public int howManyThrows() {
        return 1;
    }
}