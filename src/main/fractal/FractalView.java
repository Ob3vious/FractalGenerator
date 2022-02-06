package main.fractal;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import main.geometry.Matrix;
import main.geometry.shapes.Shape;

import javax.imageio.ImageIO;
import java.io.File;

public class FractalView {

    private GraphicsContext g;
    private Shape shape;
    private double size;
    private FractalNode node;

    private Color background;
    private Color foreground;

    public FractalView(Canvas canvas, Shape shape) {
        this.g = canvas.getGraphicsContext2D();
        this.size = canvas.getWidth();
        canvas.setHeight(this.size);

        this.shape = shape;
        this.clear();
    }

    public void setColors(Color background, Color foreground) {
        this.background = background;
        this.foreground = foreground;
    }

    public void clear() {
        g.clearRect(0, 0, size, size);
        g.setFill(background);
        g.fillRect(0, 0, size, size);
        g.setFill(foreground);
    }

    public void setNode(FractalNode node) {
        this.node = node;
    }

    /**
     * Draws the fractal
     *
     * @param scaleCap the scale limit
     */
    public void draw(double scaleCap) {
        clear();
        node.iterate(scaleCap, this);
    }

    /**
     * Draws a shape with the given transform.
     *
     * @param transform the transform to apply to the shape.
     */
    public void drawNode(Matrix transform) {
        shape.drawTransform(g, new Matrix(new double[][]{
                {size / 2.0, 0, size / 2.0},
                {0, -size / 2.0, size / 2.0},
                {0, 0, 1}}).multiplyBy(transform));
    }

    /**
     * Exports an image to the fractals folder
     *
     * @param size the image size
     * @param name the image name
     * @return the success of the upload
     */
    public boolean export(int size, double scaleCap, String name) {
        Canvas canvas = new Canvas(size, size);
        FractalView exportView = new FractalView(canvas, shape);
        exportView.setColors(background, foreground);
        exportView.setNode(node);
        exportView.draw(scaleCap);

        WritableImage image = new WritableImage(size, size);
        canvas.snapshot(null, image);
        File file = new File("fractals\\" + name + ".png");
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "PNG", file);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
