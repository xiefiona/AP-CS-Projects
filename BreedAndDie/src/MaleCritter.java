import java.awt.*;

public class MaleCritter extends BaseCritter {

    public MaleCritter(){
        setColor(Color.PINK);
    }
    public MaleCritter(int generations) {
        super(generations);
        setColor(Color.decode(maleColors[generations % maleColors.length]));
    }
}
