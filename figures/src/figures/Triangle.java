package figures;

import java.math.BigDecimal;

/**
 * The rectangular triangle is taken as the basis
 */
public class Triangle extends Figure {

    private int catechismA;
    private int catechismB;
    private int hypotenuse;

    public Triangle() {
        color = "orange";

        catechismA = 3;
        catechismB = 4;
        hypotenuse = 5;

        setAreaValue();
    }

    public int getCatechismA() {
        return catechismA;
    }

    public int getCatechismB() {
        return catechismB;
    }

    public int getHypotenuse() {
        return hypotenuse;
    }

    @Override
    protected void setAreaValue() {
        area = (catechismA * catechismB) / 2;
        area = Double.parseDouble(String.valueOf(new BigDecimal(area).setScale(2, BigDecimal.ROUND_HALF_UP)));
    }

    @Override
    public String toString() {
        return "Figure: " + getClass().getSimpleName() + "; area: " + area + " sq. units; " +
                "catechism A: " + catechismA + " units; catechism B: " + catechismB + " units; " +
                "hypotenuse: " + hypotenuse + " units; color: " + color + ".";
    }
}
