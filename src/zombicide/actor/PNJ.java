package zombicide.actor;

import zombicide.item.Item;
import zombicide.item.utility.Vial;
import zombicide.item.weapon.*;
import zombicide.map.cell.room.Armory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PNJ extends Actor{

    protected static final String PNJ = "PNJ";
    protected static final int PNJ_LF = 1;
    protected Armory armory;
    protected List<Item> fabricateObject;
    protected static Random rand = new Random();
    protected static final int MAX_ITEMS =10;
    /**
     * Constrcut a PNJ
     */
    public PNJ() {
        super(PNJ, PNJ_LF);
        this.armory = new Armory();
        super.setCell(this.armory);
        this.fabricateObject = new ArrayList<>();
    }

    /**
     *
     * @return
     */
    @Override
    public ActorType getTypeOfActor() {
        return null;
    }

    /**
     *
     */
    public void createRandomItem(){
        List<Item> items = new ArrayList<>();
        items.add(new Carabine());
        items.add(new Vial());
        items.add(new Axe());
        items.add(new Chainsaw());
        items.add(new Crowbar());
        items.add(new Pistol());
        while (this.fabricateObject.size()!=MAX_ITEMS) {
            int randomIndex = rand.nextInt(items.size());
            Item i = items.get(randomIndex);
            fabricateObject.add(i); // Not on the cell it's just the possible object to create
        }
    }

    /**
     *
     */
    public Item fabricate(){
        int randomIndex = rand.nextInt(fabricateObject.size());
        Item item = fabricateObject.get(randomIndex);
        this.getCell().addItem(item);
        System.out.println("Let's find out what i can make.");
        for (int i = 0; i < 10; i++)
            System.out.print(".");
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("I made a "+item+" if you want it, just put it in you bag.");
        return item;
    }

}
