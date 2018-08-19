import figures.*;

import java.util.ArrayList;
import java.util.List;

public class FigureManager {

    private List<Figure> figures;

    public FigureManager() {
        figures = new ArrayList<>();

    }

    public List<Figure> getFigures() {
        return figures;
    }

    public void setFigures(int amount) {
        for (int i = 0; i < amount; i++) {
            int random = (int) Math.round((Math.random() * 3) + 1);

            if (random == 1) {
                figures.add(new Square());
            } else if (random == 2) {
                figures.add(new Triangle());
            } else if (random == 3) {
                figures.add(new Circle());
            } else {
                figures.add(new Trapeze());
            }
        }
    }

    public void drawFigures() {
        for (Figure figure : figures) {
            System.out.println(figure.drawFigure());
        }
    }
}
