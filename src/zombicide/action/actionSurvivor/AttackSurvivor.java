package zombicide.action.actionSurvivor;
import zombicide.action.actionSurvivor.ActionSurvivor;
import zombicide.actor.Actor;
import zombicide.actor.survivor.Survivor;
import zombicide.actor.zombie.Zombie;
import zombicide.callable.Callable;
import zombicide.item.weapon.*;

/**
 * This is the class of the action that permits to attack a zombie, by a survivor.
 */
public class AttackSurvivor implements ActionSurvivor {

    protected Survivor survivor;
    /**
     * Constructs an AttackSurvivor with a survivor at construction
     * @param s the survivor that will attack
     */
    public AttackSurvivor(Survivor s) {
        this.survivor = s;
    }

    /**
     * Verify if the survivor can attack or not( verify if he had a weapon in their hands)
     * @return true if the survivor has the correct item in hand
     */
    @Override
    public boolean canMakeAction() {
        return this.survivor.getWhatINHand() instanceof Weapon;
    }

    @Override
    public int getCost() {
        return 0;
    }

    @Override
    public Actor getActor() {
        return this.survivor;
    }

    /**
     * Performs the action of making the action attack by a survivor;
     * Survivor can attack a Zombie if and only if, they have a weapon on hand
     * @param callable the callable, here it's an instance of Zombie
     * @return true if the action has be realised successfully
     */
    @Override
    public boolean make(Callable callable){
        if(!canMakeAction()){
            System.out.println("There's no weapon in their hand");
            return false;
        }
        Zombie zombie = (Zombie)callable;
        Weapon weapon = (Weapon)this.survivor.getWhatINHand();
        return weapon.attack(zombie);
    }

}