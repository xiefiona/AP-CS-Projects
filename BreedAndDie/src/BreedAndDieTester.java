import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;

import java.awt.*;

public class BreedAndDieTester {

    public static void main (String[] args){
        ActorWorld world = new ActorWorld();

        FemaleCritter fbug1 = new FemaleCritter();
        FemaleCritter fbug2 = new FemaleCritter();
        MaleCritter bbug1 = new MaleCritter();
        MaleCritter bbug2 = new MaleCritter();
        BlackWidowCritter blackbug = new BlackWidowCritter();
        InfectedCritter ibug1 = new InfectedCritter();

        world.add(fbug1);
        world.add(fbug2);
        world.add(bbug1);
        world.add(bbug2);
        world.add(blackbug);
        world.add(ibug1);
        world.show();

    }
}