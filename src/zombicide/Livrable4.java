package zombicide;

import grid.Grid;
import zombicide.action.Action;
import zombicide.action.actionZombie.ActionZombie;
import zombicide.actor.Actor;
import zombicide.actor.survivor.Survivor;
import zombicide.actor.zombie.Zombie;
import zombicide.actor.zombie.type.Abomination;
import zombicide.actor.zombie.type.Walker;
import zombicide.map.Map;
import zombicide.map.TrainingMap3;
import zombicide.map.cell.Cell;
import zombicide.map.cell.StreetWW;
import zombicide.map.cell.room.Continental;
import zombicide.map.util.Position;

import java.util.ArrayList;
import java.util.List;

public class Livrable4 {
    public static void main(String[] args) {
        Zombie walker = new Abomination();
        List<Cell> listrooms = new ArrayList<Cell>();
        List<Cell> liststreets = new ArrayList<Cell>();
        liststreets.add(new StreetWW());
        listrooms.add(new Continental());


        Map trainningMap = new TrainingMap3(listrooms, liststreets);
        Game game = new Game(trainningMap);
        walker.setGame(game);
        walker.setGame(game);
        game.addZombieGame(walker);

        Grid grid = new Grid(trainningMap, 10);
        trainningMap.putActorONCell(walker, new Position(4,2));

        Cell cellJul = trainningMap.getCell(new Position(2,4));
        cellJul.welcomeActor(new Survivor("jul"));

        Cell cellGab = trainningMap.getCell(new Position(1,3));
        cellGab.welcomeActor(new Survivor("gab"));


        cellJul.makeNoise();
        cellGab.makeNoise();

        grid.displayGrid();
        ActionZombie moveWalker = walker.getAction(0);
        while (!walker.getCell().equals(cellGab) & walker.makeAction(moveWalker, cellGab)){
            grid.displayGrid();
        } // quand ça ne montre rien c'est parce que le zombie veut aller à droit (c'est aléatoire) sauf qu'il ne peut pas il faut re run

    }

}
