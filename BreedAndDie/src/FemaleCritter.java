import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class FemaleCritter extends BaseCritter {

    public final int MENOPAUSE_STEPS = 15;
    protected int numTurns;     //number of turns since last breed (at least 4 turns)

    public FemaleCritter(){
        setColor(Color.BLUE);
        numTurns = 0;
    }
    public FemaleCritter(int generations) {
        super(generations);
        setColor(Color.decode(femaleColors[generations % femaleColors.length]));
    }

    public void processActors(ArrayList<Actor> actors){
        Iterator i$ = actors.iterator();
        int max = 0;
        int numKids = 0;

        while(i$.hasNext()) {
            Actor a = (Actor)i$.next();
            if (a instanceof MaleCritter && ((MaleCritter) a).checkMature() && checkMature() && getSteps() < MENOPAUSE_STEPS && numTurns >= 4) {
                //check empty spaces
                if (getMoveLocations() != null) {
                    if (getEmptySpaces().size() > 0){
                        max = getEmptySpaces().size();
                        //random number of kids
                        numKids = new Random().nextInt(max);
                    }
                    else {
                        numKids = 0;
                    }
                }

                //make kids
                for (int i = 0; i < numKids; i++) {
                    if (getMoveLocations().size() > 0) {
                        if (new Random().nextBoolean()) {
                            Critter c = new MaleCritter(generations);
                            if (((MaleCritter) a).isInfected || isInfected){
                                isInfected = true;
                                ((MaleCritter)c).setInfected(true);

                            }
                            c.putSelfInGrid(getGrid(),selectMoveLocation(getMoveLocations()));
                            c.act();
                        } else {
                            Critter c = new FemaleCritter(generations);
                            if (((MaleCritter) a).isInfected || isInfected){
                                isInfected = true;
                                ((FemaleCritter)c).setInfected(true);
                            }
                            c.putSelfInGrid(getGrid(),selectMoveLocation(getMoveLocations()));
                            c.act();
                        }
                    }
                }

                //make cooldown
                numTurns = 0;
            }
        }
    }

    public ArrayList<Location> getEmptySpaces(){
        ArrayList<Actor> nearbyActors = new ArrayList<>();
        ArrayList<Location> arrLocations = new ArrayList<>();
        ArrayList<Location> arrEmptyLocations = new ArrayList<>();

        int row, col;
        row = getLocation().getRow();
        col = getLocation().getCol();

        arrLocations.add(new Location(row + 2, col));
        arrLocations.add(new Location(row - 2, col));
        arrLocations.add(new Location(row, col + 2));
        arrLocations.add(new Location(row, col - 2));

        for (int i=0; i < arrLocations.size(); i++){
            if (getGrid().isValid(arrLocations.get(i)) && getGrid().get(arrLocations.get(i)) == null){
                arrEmptyLocations.add(arrLocations.get(i));
            }
        }

        arrEmptyLocations.addAll(this.getGrid().getEmptyAdjacentLocations(this.getLocation()));
        return arrEmptyLocations;
    }

    //override get actors: get an arraylist of nearby actors
    @Override
    public ArrayList<Actor> getActors() {
        ArrayList<Actor> nearbyActors = new ArrayList<>();
        ArrayList<Location> arrLocations = new ArrayList<>();

        int row, col;
        row = getLocation().getRow();
        col = getLocation().getCol();

        arrLocations.add(new Location(row + 2, col));
        arrLocations.add(new Location(row - 2, col));
        arrLocations.add(new Location(row, col + 2));
        arrLocations.add(new Location(row, col - 2));

        for (int i=0; i < arrLocations.size(); i++){
            if (getGrid().isValid(arrLocations.get(i)) && getGrid().get(arrLocations.get(i)) != null && getGrid().get(arrLocations.get(i)) instanceof Actor){
                nearbyActors.add(getGrid().get(arrLocations.get(i)));
            }
        }

        nearbyActors.addAll(this.getGrid().getNeighbors(this.getLocation()));
        return nearbyActors;
    }

    @Override
    public void act() {
        if (this.getGrid() != null) {
            if (checkDeath()){
                return;
            }
            ArrayList<Actor> actors = this.getActors();
            this.processActors(actors);
            ArrayList<Location> moveLocs = this.getMoveLocations();
            if (getMoveLocations() != null) {
                Location l = selectMoveLocation(moveLocs);
                makeMove(l);
            }
            steps++;
            numTurns++;
        }
    }

}
