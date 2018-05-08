import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class BlackWidowCritter extends FemaleCritter {
    public BlackWidowCritter(){
        setColor(Color.BLACK);
    }
    public BlackWidowCritter(int generations){
        super(generations);
        setColor(Color.decode(blackWidowColors[generations % blackWidowColors.length]));
    }

    public void processActors(ArrayList<Actor> actors){
        Iterator i$ = actors.iterator();
        int numKids = 0;

        while(i$.hasNext()) {
            Actor a = (Actor)i$.next();
            if (a instanceof MaleCritter && ((MaleCritter) a).checkMature() && checkMature() && getSteps() < MENOPAUSE_STEPS && numTurns >= 4) {
                //check empty spaces
                if (getMoveLocations() != null) {
                    if (getEmptySpaces().size() > 0){
                        //random number of kids
                        numKids = new Random().nextInt(getEmptySpaces().size());
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
                            c.putSelfInGrid(getGrid(),selectMoveLocation(getMoveLocations()));
                            c.act();
                        } else {
                            Critter c = new BlackWidowCritter(generations);
                            c.putSelfInGrid(getGrid(),selectMoveLocation(getMoveLocations()));
                            c.act();
                        }
                    }
                }

                a.removeSelfFromGrid();

                //make cooldown
                numTurns = 0;
            }
        }
    }

}
