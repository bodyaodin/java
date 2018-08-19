package figures;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Trapeze extends Figure {

    private int upperSide;
    private int downSide;
    private int sides;

    public Trapeze() {
        color = "blue";

        upperSide = 3;
        downSide = 5;
        sides = 4;

        setAreaValue();
    }

    public int getUpperSide() {
        return upperSide;
    }

    public int getDownSide() {
        return downSide;
    }

    public int getSides() {
        return sides;
    }


    @Override
    protected void setAreaValue() {
        area = (upperSide + downSide) / 4 * Math.sqrt(4 * Math.pow(sides, 2) - Math.pow((downSide - upperSide), 2));
        area = Double.parseDouble(String.valueOf(new BigDecimal(area).setScale(2, BigDecimal.ROUND_HALF_UP)));
    }

    @Override
    public String toString() {
        return "Figure: " + getClass().getSimpleName() + "; area: " + area + " sq. units; " +
                "upper side: " + upperSide + " units; down side: " + downSide + " units; " +
                "both sides: " + sides + " units; color: " + color + ".";
    }
}
