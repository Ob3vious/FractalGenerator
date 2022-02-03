package main.geometry.shapes;

import main.geometry.Matrix;
import main.geometry.Vector;

import java.awt.*;

public class Point implements Shape {
    @Override
    public void drawTransform(Graphics2D g, Matrix transform) {
        Vector p = new Vector(0, 0).applyMatrix(transform);
        g.drawRect((int)p.getX(), (int)p.getY(), 0, 0);
    }
}
