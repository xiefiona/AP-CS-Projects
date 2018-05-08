import java.awt.*;

public class InfectedCritter extends MaleCritter {
    public InfectedCritter(){
        setColor(Color.GREEN);
        isInfected = true;
    }
    public InfectedCritter(int generations){
        super(generations);
        setColor(Color.decode(infectedColors[generations % infectedColors.length]));
        isInfected = true;
    }

}
