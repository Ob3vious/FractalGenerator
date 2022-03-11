package main.geometry.shapes;

import javafx.scene.canvas.GraphicsContext;
import main.geometry.Matrix;

import java.awt.*;

public interface Shape {
    /**
     * Draws the shape at a given transform.
     *
     * @param g         the image to draw on
     * @param transform the transform to draw at
     */
    void drawTransform(GraphicsContext g, Matrix transform);
}
