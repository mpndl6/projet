package zombicide.map.cell;

import java.util.ArrayList;
import java.util.List;

//import zombicide.map.grid.element.ElementGrid;
import zombicide.item.Item;
import zombicide.map.util.*;

import zombicide.actor.survivors.Survivor;
import zombicide.actor.zombies.Zombie;

public abstract class Cell /*implements ElementGrid*/ {
	
	//List to store survivors and zombies in the cell
	protected List<Survivor> survivors;
	protected List<Zombie> zombies;
	protected List<Item> items;
	// The noise level and position and the type of the cell
	protected int noiseLevel;
	protected Position position;

	
	// Constructor to initialize the cell with noise level and position
	public Cell(Position position) {
		
		this.noiseLevel=0;
		this.position=position;
		this.survivors=new ArrayList<Survivor>();
		this.zombies=new ArrayList<Zombie>();
	}
	
	  /**
     * Adds a zombie to the cell
     *@param z to be added to the cell
     */
	public void welcomeZombies(Zombie z) {
		this.zombies.add(z);
	}
	
	  /**
     * Adds a survivor to the cell
     *@param s to be added to the cell
     */
	public void welcomeSurvivor(Survivor s) {
		this.survivors.add(s);
	}
	
	  /**
     *  Removes a zombie from the cell
     *@param z to be removed from the cell
     */
	public void removeZombie(Zombie z) {
		this.zombies.remove(z);
	}
	
	  /**
     *  Removes a survivor from the cell
     *@param s to be removed from the cell
     */
	public void removeSurvivor(Survivor s) {
		this.survivors.remove(s);
	}
	
	 /**
     *  Gets the count of survivors in the cell
     *@return The number of survivors in the cell
     */
	public int howManySurvivors() {
		return this.survivors.size();
	}
	
	 /**
     *  Gets the count of zombies in the cell
     *@return The number of zombies in the cell
     */
	public int howManyZombies() {
		return this.zombies.size();
	}
	
	 /**
     *  
     *  Gets the list of survivors in the cell
     *@return List of survivors in the cell
     */
	public List<Survivor> getSurvivors(){
		return this.survivors;
	}
	
	/**
     *  
     *  Gets the list of zombies in the cell     
     * @return List of zombies in the cell
     */
	public List<Zombie> getZombies(){
		return this.zombies;
	}
	
	/**
     *  
     *  Gets the noise level in the cell     
     * @return The noise level of the cell
     */
	public int getNoiseLevel() {
		return this.noiseLevel;
	}

	/**
	 * Adds an item to the room.
	 *
	 * @param i The item to be added.
	 */
	public abstract void addItem(Item i);

	/**
	 * Removes an item from the room.
	 *
	 * @param i The item to be removed.
	 */
	public abstract void removeitem(Item i);

	/**
	 * Tells if the item in parameter is on cell
	 * @param i the item wanted
	 * @return true if the item i is on cell
	 */
	public boolean containsItem(Item i){
		return items.contains(i);
	}

	/**
	 * Returns the number of items in the room.
	 *
	 * @return The number of items.
	 */
	public int getNbItem() {
		return this.items.size();
	}
	
	/**
     *  
     *  Checks if actors can fitgh in area
     * @return true if there are survivors who can fight, false otherwise
     */ 
	public abstract boolean canFight();

	/**
	 * @return a description of the cell
	 */
	public abstract String toString();

	/**
     *  
     *  Gets the position of the cell
     * @return The position of the cell
     */ 
	public Position getPosition() {
		return this.position;
	}

	/**
	 * TODO
	 * @return
	 */
	public abstract Object getTypeOfCell();
	
	
}