import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.*;

public class JumpingBug extends Bug {

    /**
     * Constructs a box bug that traces a square of a given side length
     */
    public JumpingBug() {
        this.setColor(Color.BLUE);
    }

    public void act() {
        if (canJump()) {
            jump();
        } else {
            turn();
        }
    }

    public boolean canJump(){
        Grid<Actor> gr = getGrid();
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (gr == null || !gr.isValid(next)) {
            System.out.println("not valid");
            return false;
        }
        Actor closeNeighbor = (Actor)gr.get(next);
        if (!(closeNeighbor == null || closeNeighbor instanceof Rock || closeNeighbor instanceof Flower)) {
            System.out.println("error 1");
            return false;
        }
        if (!gr.isValid(next.getAdjacentLocation(getDirection()))) {
            System.out.println("error 2");
            return false;
        }
        Actor neighbor = (Actor)gr.get(next.getAdjacentLocation(getDirection()));
        return (neighbor == null || neighbor instanceof Flower);
    }

    public void jump(){
        Grid<Actor> gr = getGrid();
        if (gr != null) {
            Location loc = getLocation();
            Location next = loc.getAdjacentLocation(getDirection());
            if (gr.isValid(next)) {
                moveTo(next.getAdjacentLocation(getDirection()));
            } else {
                removeSelfFromGrid();
            }
        }
    }
}
