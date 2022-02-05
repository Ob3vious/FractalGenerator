package main.fractal;

import main.geometry.Matrix;
import main.geometry.shapes.Point;
import main.geometry.shapes.Shape;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FractalImage {
    private BufferedImage img;
    private Graphics2D g;
    private Shape shape;
    private int size;

    public FractalImage(int size, Color background, Color foreground, Shape shape) {
        this.size = size;
        this.shape = shape;
        this.img = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        this.g = img.createGraphics();
        g.setPaint(background);
        g.fillRect(0, 0, size, size);
        g.setPaint(foreground);
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

    /**
     * Uploads the image file into the fractals folder.
     * @param filename the name of the image file
     * @throws IOException the exception that is thrown if uploading went wrong
     */
    public void upload(String filename) throws IOException {
        ImageIO.write(img, "PNG", new File("res\\" + filename + ".png"));
    }
}
