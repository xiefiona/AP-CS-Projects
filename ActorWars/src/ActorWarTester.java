import org.masonacm.actorwars.ActorWarWorld;
import org.masonacm.actorwars.Peon;

public class ActorWarTester {
    public static void main(String args[]){
        ActorWarWorld place = new ActorWarWorld();
        place.add(new FionaActor());
        place.add(new Peon() {
            @Override
            public void peonAct() {

            }
        });
        place.show();
    }
}
