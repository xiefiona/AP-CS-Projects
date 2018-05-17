import com.gawdl3y.util.DynamicValue;
import info.gridworld.grid.Location;
import org.masonacm.actorwars.*;

import java.awt.*;
import java.util.ArrayList;

public class FionaActor extends Peon {

    public final static int WHEAT_RANGE = 5;
    public final static int WHEAT_AGE_LIMIT = 20;

    private int steps = 0;
    private int index = 0;
    private boolean wheatMode = false;
    private boolean attackMode = false;
    private int highestHealth = 0;
    private int highestEnergy = 0;
    private int numKills = 0;

    public FionaActor(){
        setColor(Color.PINK);
    }

    public void peonAct() {
        if (!attackWheat()) {
            moveToWheat();
            consumeWheat();
        }
        if (myactions.size() == 1) {
            wheatMode = false;
        }
        if (canKill() || getWheatPositions().size() <= 0) {
            fightPeon();
        }
        steps++;
        if (getOtherPeons().size() > 0){
            printStats();
        }
    }

    public void printStats() {
        if (getEnergy() > highestEnergy) {
            highestEnergy = getEnergy();
        }
        if (getHealth() > highestHealth) {
            highestHealth = getHealth();
        }
        System.out.println("steps: " + steps + " Energy: " + getEnergy() + " HP: " + getHealth() + " Highest Energy: " + highestEnergy + " Highest Health: " + highestHealth + "Kills: " + numKills);
    }


    //returns locations of all wheat on the map
    public ArrayList<Location> getWheatPositions(){
        ArrayList<Location> arrWheat = new ArrayList<>();
        for (int r = 0; r < getGrid().getNumRows(); r++){
            for (int c = 0; c < getGrid().getNumCols(); c++){
                if (getGrid().get(new Location(r,c)) instanceof Wheat) {
                    arrWheat.add(new Location(r,c));
                }
            }
        }
        return arrWheat;
    }

    //returns locations of all wheat within a range of a position
    public ArrayList<Location> getCloseWheat(Location loc1){
        ArrayList<Location> arrCloseWheat = new ArrayList<>();
        for (Location l : getWheatPositions()) {
            if (getDistance(loc1, l) <= WHEAT_RANGE){
                arrCloseWheat.add(l);
            }
        }
        return arrCloseWheat;
    }

    public boolean attackWheat(){
        if (getFacing() instanceof Wheat) {
            myactions.add(0, Action.attackHP(((Wheat)getFacing()).getHealth()));
            return true;
        } else if (getWheatPositions().size() > 0){
            myactions.add(Action.turn(LocationFinder.directionTo(getLocation(), LocationFinder.findClosestInstanceLocation(new DynamicValue<Location>() {
                @Override
                public Location getValue() {
                    return getLocation();
                }
            }, Wheat.class, getGrid()))));
        }
        return false;
    }

    public void moveToWheat(){
        if (!wheatMode) {
            if (steps == 0){
                for (int i = 0; i < getWheatPositions().size(); i++) {
                    if (getDistance(getWheatPositions().get(i), getLocation()) >= WHEAT_AGE_LIMIT) {
                        index = i;
                    }
                }
                myactions.add(moveToGradual(new DynamicValue<Location>() {
                    @Override
                    public Location getValue() {
                        return getWheatPositions().get(index);
                    }
                }));
                wheatMode = true;
            } else {
                if (getWheatPositions().size() > 0){
                    if (getCloseWheat(getLocation()).size() >= 1){
                        myactions.add(moveToGradual(new DynamicValue<Location>() {
                            @Override
                            public Location getValue() {
                                index = 0;
                                return getCloseWheat(getLocation()).get(index);
                            }
                        }));
                    } else {
                        myactions.add(moveToGradual(new DynamicValue<Location>() {
                            @Override
                            public Location getValue() {
                                return getWheatPositions().get(0);
                            }
                        }));
                    }
                    wheatMode = true;
                } else {
                    wheatMode = false;
                }
            }
        }

    }

    public void consumeWheat(){
        if (getItemCount(Wheat.class) > 0){
            myactions.add(Action.use(Wheat.class));
        } else {
            //do later
        }
    }

    //returns locations of all other peons on the map
    public ArrayList<Location> getOtherPeons(){
        ArrayList<Location> arrPeons = new ArrayList<>();
        for (int r = 0; r < getGrid().getNumRows(); r++){
            for (int c = 0; c < getGrid().getNumCols(); c++){
                if (!(getGrid().get(new Location(r,c)) instanceof FionaActor)){
                    if (getGrid().get(new Location(r,c)) instanceof Peon || getGrid().get(new Location(r,c)) instanceof ActiveActor) {
                        arrPeons.add(new Location(r,c));
                    }
                }
            }
        }
        return arrPeons;
    }

    public void moveToPeon() {
        if (!attackMode) {
            myactions.add(moveToGradual(new DynamicValue<Location>() {
                @Override
                public Location getValue() {
                    return getWeakestPeon().getLocation();
                }
            }));
            attackMode = true;
        }
    }

    public ActiveActor getWeakestPeon(){
        ActiveActor weakestActor = (ActiveActor)getGrid().get(getOtherPeons().get(0));
        for (int i = 0; i < getOtherPeons().size(); i++){
            if ((((ActiveActor)(getGrid().get(getOtherPeons().get(i)))).getHealth() < weakestActor.getHealth())) {
                weakestActor = (ActiveActor)getGrid().get(getOtherPeons().get(i));
            }
        }
        return weakestActor;

    }

    public boolean attackPeon(){
        if (getFacing() instanceof Peon) {
            myactions.add(0, Action.attackHP(((Peon)getFacing()).getHealth()));
            numKills++;
            return true;
        }
        else if (getOtherPeons().size() > 0){
            myactions.add(Action.turn(LocationFinder.directionTo(getLocation(), getWeakestPeon().getLocation())));
        }
        return false;
    }

    public void fightPeon(){
        if (!attackPeon()){
            moveToPeon();
        }
        if (myactions.size() == 1){
            attackMode = false;
        }
    }

    //returns distance between two locations
    public int getDistance(Location loc1, Location loc2){
        return (int) Math.floor(Math.sqrt((loc1.getRow() - loc2.getRow())*(loc1.getRow() - loc2.getRow()) + (loc1.getCol() - loc2.getCol()) * (loc1.getCol() - loc2.getCol())) + .5);
    }

    public boolean canKill(){
        return Math.pow(getEnergy() + 4, .5) + 2 > getWeakestPeon().getHealth();
    }
}
