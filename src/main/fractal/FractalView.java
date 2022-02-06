package main.fractal;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import main.geometry.Matrix;
import main.geometry.shapes.Shape;

public class FractalView {

    private GraphicsContext g;
    private Shape shape;
    private double size;

    private Color background;
    private Color foreground;

    public FractalView(Canvas canvas, Color background, Color foreground, Shape shape) {
        this.g = canvas.getGraphicsContext2D();
        this.size = canvas.getWidth();
        canvas.setHeight(this.size);

        this.background = background;
        this.foreground = foreground;

        this.shape = shape;
        this.clear();
    }

    public void clear() {
        g.clearRect(0, 0, size, size);
        g.setFill(background);
        g.fillRect(0, 0, size, size);
        g.setFill(foreground);
    }

    /**
     * Draws a shape with the given transform.
     * @param transform the transform to apply to the shape.
     */
    public void drawNode(Matrix transform) {
        shape.drawTransform(g, new Matrix(new double[][] {
                {size/2.0, 0, size/2.0},
                {0, -size/2.0, size/2.0},
                {0, 0, 1}}).multiplyBy(transform));
    }
}
