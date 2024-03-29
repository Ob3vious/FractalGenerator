package main.geometry.shapes;

import javafx.scene.canvas.GraphicsContext;
import main.geometry.Matrix;
import main.geometry.Vector;

import java.awt.*;

public class Point implements Shape {
    @Override
    public void drawTransform(GraphicsContext g, Matrix transform) {
        Vector p = new Vector(0, 0).applyMatrix(transform);
        g.fillRect(p.getX(), p.getY(), 1, 1);
    }
}
