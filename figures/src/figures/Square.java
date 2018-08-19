package figures;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Square extends Figure {

    private int side;

    public Square() {
        color = "red";

        side = 10;

        setAreaValue();
    }

    public int getSide() {
        return side;
    }


    @Override
    protected void setAreaValue() {
        area = Math.pow(side, 2);
        area = Double.parseDouble(String.valueOf(new BigDecimal(area).setScale(2, BigDecimal.ROUND_HALF_UP)));
    }

    @Override
    public String toString() {
        return "Figure: " + getClass().getSimpleName() + "; area: " + area + " sq. units; " +
                "side: " + side + " units; color: " + color + ".";
    }
}
