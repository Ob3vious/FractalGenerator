package main.geometry.shapes;

import main.geometry.Matrix;

import java.awt.*;

public interface Shape {
    void drawTransform(Graphics2D g, Matrix transform);
}
