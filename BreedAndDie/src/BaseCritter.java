import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

import java.awt.*;
import java.util.ArrayList;

public class BaseCritter extends Critter {

    static final int DEATH_STEPS = 20;
    static final int MATURE_STEPS = 5;
    static final String[] maleColors = {"#880E4F", "#AD1457", "#C2185B", "#D81B60", "#E91E63", "#EC407A", "#F06292", "#F48FB1", "#F8BBD0"};
    static final String[] femaleColors = {"#006064", "#00838F", "#0097A7", "#00ACC1", "#00BCD4", "#26C6DA", "#4DD0E1", "#80DEEA", "#B2EBF2"};
    static final String[] blackWidowColors = {"#212121", "#424242", "#616161", "#757575", "#9E9E9E", "#BDBDBD", "#E0E0E0", "#EEEEEE", "#F5F5F5"};
    static final String[] infectedColors = {"#1B5E20", "#2E7D32", "#388E3C", "#43A047", "#4CAF50", "#66BB6A", "#81C784", "#A5D6A7"};

    protected int steps;
    protected int generations;
    protected boolean isInfected;

    public BaseCritter(){
        steps = generations = 0;
        isInfected = false;
    }
    public BaseCritter(int generations) {
        this.generations = generations + 1;
    }

    public void setSteps(int steps){
        this.steps = steps;
    }
    public void setGenerations(int generations){
        this.generations = generations;
    }
    public void setInfected(boolean infected){
        this.isInfected = infected;
        setColor(Color.decode(infectedColors[generations % infectedColors.length]));
    }

    public int getSteps(){
        return steps;
    }
    public int getGenerations() {
        return generations;
    }
    public boolean getIsInfected(){
        return isInfected;
    }

    public void act() {
        if (this.getGrid() != null) {
            if (checkDeath()){
                return;
            }
            ArrayList<Actor> actors = this.getActors();
            this.processActors(actors);
            ArrayList<Location> moveLocs = this.getMoveLocations();
            Location loc = this.selectMoveLocation(moveLocs);
            this.makeMove(loc);
            steps++;
        }
    }
    public boolean checkDeath(){
        if (steps >= DEATH_STEPS || (isInfected && steps >= 10)){
            removeSelfFromGrid();
            return true;
        }
        return false;
    }
    public boolean checkMature(){
        return  (steps >= MATURE_STEPS);
    }
}
