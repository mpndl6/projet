package zombicide.map.cell;
import java.util.*;

import zombicide.map.util.*;
import zombicide.item.*;
import zombicide.map.cell.util.*;

public class Room extends Cell {

    protected Map<Location,Boolean> doors;
    protected CellType cellType;

    public Room() {
        super();
        this.cellType = CellType.ROOM;
        super.items = new ArrayList<Item>();
        this.doors = new HashMap<Location,Boolean>();

        List<Location> locations = this.locationOfDoors();

        for(Location l : locations) {
            this.doors.put(l,false);
        }
    }

    /**
     * get type of cell
     *
     *@return type of cell
     */
    public CellType getTypeOfCell() {
        return this.cellType;
    }

    @Override
    public String description() {
        return "Cell de type:" + this +"\n" + "nombre de survivants:" + this.howManySurvivors() +"\n" + "nombre de zombies:" + this.howManyZombies() + "\n"+"nombre d'objets:" + this.getNbItem() +"\n";
    }

    /**
     * Determines the possible locations for doors in the room.
     *
     * @return A list of possible door locations.
    */
    private List<Location> locationOfDoors() {
        List<Location> locations =new ArrayList<Location>();
        locations.add(Location.NORTH);
        locations.add(Location.SOUTH);
        locations.add(Location.EAST);
        locations.add(Location.WEST);
        return locations;
    }

/*
    /**
     * Checks if it is possible to leave the room through a specific door.
     *
     * @param l The location of the door.
     * @return True if the door is open, false otherwise.

    public boolean canLeaveByDoor(Location l) {
        if(!this.doors.containsKey(l))
            return false;
        return this.doors.get(l).isOpen();
    }*/



    /**
     * Adds an item to the room.
     *
     * @param i The item to be added.
     */
    public void addItem(Item i) {
        super.items.add(i);
    }

    /**
     * Removes an item from the room.
     *
     * @param i The item to be removed.
     */
    public void removeItem(Item i) {
        super.items.remove(i);
    }

    /**
     * Tell is the door at location l is open or not
     * @param l the location of the door
     * @return true isf the door is open
     */
    public Boolean isOpen(Location l){
    return doors.get(l);
    }

    /**
     * Opens a specific door in the room.
     *
     * @param l The location of the door to be opened.
     */
    public void openDoor(Location l) {
            doors.put(l,true);

    }
    public boolean canFight() {
    	return true;
    }

    /**
     * Returns the description of the cell
     * @return the description of the cell
     */
    public String toString(){
        return "R";

    }

}


