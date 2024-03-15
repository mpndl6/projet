package zombicide.actor.survivor.type;

import zombicide.actor.survivor.Survivor;

public class Nosy extends Survivor {

    private boolean firstSearchFree;
    /**
     * Contruct a survivor with their name in parameter.
     * At creation, a survivor has a Pistol in hand
     * 5 life points, 0 XP, 0 action points et nothing in backpack
     *
     * @param name the nickname of the survivor
     */
    public Nosy(String name) {
        super(name);
        this.firstSearchFree = true;
    }

    //Quand on sera au rendu pour les actions il faudra ajouter l'action fouiller ici
    public void search() {
        if (firstSearchFree) {
            firstSearchFree = false;
        } else {
            decreaseActionPoints();
        }
    }

}