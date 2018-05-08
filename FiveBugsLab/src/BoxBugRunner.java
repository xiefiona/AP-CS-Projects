/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Cay Horstmann
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 */

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import info.gridworld.grid.UnboundedGrid;
import javafx.scene.shape.Circle;

import java.awt.Color;

/**
 * This class runs a world that contains box bugs. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class BoxBugRunner
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld(new BoundedGrid<>(40,40));

        BoxBug bob = new BoxBug(3);
        bob.setColor(Color.ORANGE);

        CircleBug bugbug = new CircleBug(4);
        bugbug.setColor(Color.RED);

        SpiralBug baldbug = new SpiralBug(3);
        baldbug.setColor(Color.BLACK);

        ZBug zellowbug = new ZBug(4);
        zellowbug.setColor(Color.YELLOW);

        int[] dizzyPos = {2,3,4,5};
        DancingBug dizzyBug = new DancingBug(dizzyPos);
        dizzyBug.setColor(Color.GREEN);

        JumpingBug bahJumpBug = new JumpingBug();

        world.add(new Location(7, 28), bob);
        world.add(new Location(35,10), bugbug);
        world.add(new Location(10,12), baldbug);
        world.add(new Location(32,31), zellowbug);
        world.add(new Location(25,25), dizzyBug);
        world.add(new Location(20,35), bahJumpBug);
        world.show();
    }
}