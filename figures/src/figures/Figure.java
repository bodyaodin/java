package figures;

public abstract class Figure {

    protected String color;
    protected double area;

    public Figure() {
    }

    public String getColor() {
        return color;
    }

    public double getArea() {
        return area;
    }


    public String drawFigure() {
        return toString();
    }

    protected abstract void setAreaValue();
}
