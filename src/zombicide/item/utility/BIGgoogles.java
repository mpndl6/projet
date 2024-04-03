package zombicide.item.utility;

import zombicide.callable.Callable;
import zombicide.map.Map;
import zombicide.map.cell.Cell;
import zombicide.map.util.Position;

/**
 *
 */
public class BIGgoogles extends Utility{

    protected Map map;

    /**
     *
     * @param map
     */
    public BIGgoogles(Map map){
        this.map = map;
    }

    /**
     *
     * @param callable the  parameter callable
     */
    @Override
    public void use(Callable callable){
        System.out.println("That's BIG GOOGLES you're using here\n");
       Position pos = (Position)callable;
      Cell cell = map.getCell(pos);
      System.out.println("In this cell you have :\n\n"+cell.description()); // Ajouter le type de la cellule
    }

    /**
     *
     */
    public String toString(){
        return "BIG googles";
    }


}
