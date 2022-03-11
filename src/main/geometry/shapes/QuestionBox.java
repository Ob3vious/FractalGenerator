package main.geometry.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.CubicCurve;
import main.geometry.Matrix;
import main.geometry.Vector;

import java.awt.*;

public class QuestionBox implements Shape {
    @Override
    public void drawTransform(GraphicsContext g, Matrix transform) {
        Vector p1 = new Vector(-1, 1).applyMatrix(transform);
        Vector p2 = new Vector(1, 1).applyMatrix(transform);
        Vector p3 = new Vector(1, -1).applyMatrix(transform);
        Vector p4 = new Vector(-1, -1).applyMatrix(transform);
        g.strokePolygon(new double[]{p1.getX(), p2.getX(), p3.getX(), p4.getX()},
                new double[]{p1.getY(), p2.getY(), p3.getY(), p4.getY()}, 4);

        p1 = new Vector(-0.375, 0.25).applyMatrix(transform);
        p2 = new Vector(-0.375, 0.75).applyMatrix(transform);
        p3 = new Vector(0.375, 0.75).applyMatrix(transform);
        p4 = new Vector(0.375, 0.25).applyMatrix(transform);
        Vector p5 = new Vector(0.375, -0.25).applyMatrix(transform);
        Vector p6 = new Vector(0, 0).applyMatrix(transform);
        Vector p7 = new Vector(0, -0.375).applyMatrix(transform);
        Vector p8 = new Vector(0, -0.625).applyMatrix(transform);

        g.beginPath();
        g.moveTo(p1.getX(), p1.getY());
        g.bezierCurveTo(p2.getX(), p2.getY(), p3.getX(), p3.getY(), p4.getX(), p4.getY());
        g.bezierCurveTo(p5.getX(), p5.getY(), p6.getX(), p6.getY(), p7.getX(), p7.getY());
        g.stroke();

        g.strokeOval(p8.getX() - 0.5, p8.getY() - 0.5, 1, 1);
    }
}
