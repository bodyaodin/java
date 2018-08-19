package figures;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Circle extends Figure {

    private int radius;

    public Circle() {
        color = "green";

        radius = 5;

        setAreaValue();
    }

    public int getRadius() {
        return radius;
    }

    @Override
    protected void setAreaValue() {
        area = Math.pow(Math.PI * radius, 2);
        area = Double.parseDouble(String.valueOf(new BigDecimal(area).setScale(2, BigDecimal.ROUND_HALF_UP)));
    }

    @Override
    public String toString() {
        return "Figure: " + getClass().getSimpleName() + "; area: " + area + " sq. units; " +
                "radius: " + radius + " units; color: " + color + ".";
    }
}
