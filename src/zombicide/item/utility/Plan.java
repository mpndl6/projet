package zombicide.item.utility;
import grid.GridOfPlan;
import zombicide.callable.Callable;
import zombicide.map.*;

public class Plan extends Utility {
    protected Map map;

    public Plan(Map m){
        this.map = m;
    }

    /**
     * Uses the plan utility item to display the associated map.
     * This method overrides the use method from the Utility class.
     */
    @Override
    public void use(Callable callable) {
        GridOfPlan grid= new GridOfPlan(this.map);
         grid.displayGrid();
         this.survivor.getCell().makeNoise(); // quand un plan est utilisé il fera du bruit
    }

    /**
     * Gives a description o the item
     * @return a description of the item
     */
    public String toString(){
        return "Plan";
    }
}