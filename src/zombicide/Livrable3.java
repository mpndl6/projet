package zombicide;

import grid.Grid;
import zombicide.action.*;
import zombicide.actor.survivor.Survivor;
import zombicide.actor.survivor.type.Fighter;
import zombicide.actor.survivor.type.Healer;
import zombicide.actor.survivor.type.Nosy;
import zombicide.actor.zombie.Zombie;
import zombicide.actor.zombie.type.Abomination;
import zombicide.actor.zombie.type.Powerful;
import zombicide.actor.zombie.type.Runner;
import zombicide.actor.zombie.type.Walker;
import zombicide.item.Item;
import zombicide.item.utility.Vial;
import zombicide.item.weapon.Axe;
import zombicide.item.weapon.Carabine;
import zombicide.map.Map;
import zombicide.map.TrainingMap3;
import zombicide.map.cell.Cell;
import listchooser.util.*;
import listchooser.*;
import zombicide.map.cell.StreetWW;
import zombicide.map.cell.room.Continental;
import zombicide.map.util.Location;
import zombicide.map.util.Position;

import java.util.ArrayList;
import java.util.*;

public class Livrable3 {
    public static void main(String args[]) {
        //actors
        Survivor julien = new Fighter("julien");
        Survivor youssef = new Nosy("Youssef");
        Survivor gabrielle = new Healer("gabrielle");
        Survivor annie = new Survivor("Annie-N");

        Zombie walker = new Walker();
        Zombie runner = new Runner();
        Zombie abomination = new Abomination();
        Zombie powerful = new Powerful();

        //map
        //Add of special room and special street
        List<Cell> listrooms = new ArrayList<Cell>();
        List<Cell> liststreets = new ArrayList<Cell>();
        liststreets.add(new StreetWW());
        listrooms.add(new Continental());


        Map trainningMap = new TrainingMap3(listrooms, liststreets);
        Game game = new Game(trainningMap);
        julien.setGame(game);
        annie.setGame(game);
        youssef.setGame(game);
        gabrielle.setGame(game);
        abomination.setGame(game);
        runner.setGame(game);
        walker.setGame(game);
        powerful.setGame(game);
        game.addZombieGame(abomination);
        game.addZombieGame(walker);
        game.addZombieGame(powerful);
        game.addZombieGame(runner);

        //Les survivants sur une cell
        trainningMap.putActorONCell(julien,new Position(0,2));
        trainningMap.putActorONCell(youssef,new Position(0,2));
        trainningMap.putActorONCell(annie,new Position(0,2));
        trainningMap.putActorONCell(gabrielle,new Position(0,2));
        //Zombie sur wastewater
        trainningMap.putActorONCell(abomination,new Position(0,2));
        trainningMap.putActorONCell(walker,new Position(2,0));
        trainningMap.putActorONCell(runner,new Position(4,2));
        trainningMap.putActorONCell(powerful,new Position(2,4));

        //Premier affichage
        Grid grid = new Grid(trainningMap, 10);
        grid.displayGrid();

        //Action pour donner la hache et une fiole a 2 survivants
        Item axe = new Axe();
        TakeInHand takeInHand = new TakeInHand(youssef);
        takeInHand.make(axe);
        Item vial = new Vial();
        TakeInHand takevial = new TakeInHand(annie);
        annie.makeAction(takevial,vial);

        //Action par survivor
        Search search = new Search(gabrielle);
        MoveAside moveAside = new MoveAside(julien);
        LookAround lookaround = new LookAround(julien);
        MakeNoise makeNoise = new MakeNoise(annie);
        AttackSurvivor attack = new AttackSurvivor(youssef);



        attack.make(abomination);
        julien.makeAction(moveAside,Location.SOUTH);
        annie.makeAction(makeNoise,annie.getCell());
        gabrielle.makeAction(search,gabrielle.getCell());



        System.out.println(gabrielle.getCell().getNoiseLevel());
        System.out.println(gabrielle.getCell().description());

        //Action des zombies
        for (Zombie zombie : game.listZombies) {
            ActionZombie actionAttack = zombie.getAction(1);
            if (actionAttack.make(zombie.getCell())) {
                System.out.println("Le zombie a attaque");
            } else {
                ActionZombie actionMove = zombie.getAction(0);
                boolean hasMoved = false;

                // Vérifier si le zombie peut bouger dans au moins une direction
                if (actionMove.make(Location.NORTH) && !hasMoved) {
                    System.out.println("Le zombie se déplace vers le nord");
                    hasMoved = true;
                } else if (actionMove.make(Location.EAST) && !hasMoved) {
                    System.out.println("Le zombie se déplace vers l'est");
                    hasMoved = true;
                } else if (actionMove.make(Location.WEST) && !hasMoved) {
                    System.out.println("Le zombie se déplace vers l'ouest");
                    hasMoved = true;
                } else if (actionMove.make(Location.SOUTH) && !hasMoved) {
                    System.out.println("Le zombie se déplace vers le sud");
                    hasMoved = true;
                }
            }
        }
        //Affichage map final après toutes les actions
        grid.displayGrid();


         //Affichage statut des survivants
         System.out.println(julien.toString());
         System.out.println(gabrielle.toString());
         System.out.println(annie.toString());
         System.out.println(youssef.toString());

            //mettre en main les object à chaue acteur

        // methode MoveAside pour les Zombie (on peut utiliser la même ue dans survivor)
        System.out.println("Which action do you want to use?");
        System.out.println("1 - MOVE\n2 - LOOK AROUND\n3 - MAKE NOISE\n4 - OPEN A DOOR\n 5 - SEARCH\n6 - TAKE IN HAND\n7 - USE AN ITEM");

        //listChooser

}}
