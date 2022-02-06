package main.geometry.shapes;

import javafx.scene.canvas.GraphicsContext;
import main.geometry.Matrix;
import main.geometry.Vector;

import java.awt.*;

public class Rhomboid implements Shape {
    @Override
    public void drawTransform(Graphics2D g, Matrix transform) {

    }

    @Override
    public void drawTransform(GraphicsContext g, Matrix transform) {
        Vector p1 = new Vector(-1, 1).applyMatrix(transform);
        Vector p2 = new Vector(1, 1).applyMatrix(transform);
        Vector p3 = new Vector(1, -1).applyMatrix(transform);
        Vector p4 = new Vector(-1, -1).applyMatrix(transform);
        g.fillPolygon( new double[] {p1.getX(), p2.getX(), p3.getX(), p4.getX()},
                new double[] {p1.getY(), p2.getY(), p3.getY(), p4.getY()}, 4);
    }
}
