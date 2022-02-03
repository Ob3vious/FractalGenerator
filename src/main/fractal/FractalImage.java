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

    public FractalImage(int width, int height, Color background, Color foreground, Shape shape) {
        this.shape = shape;
        this.img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        this.g = img.createGraphics();
        g.setPaint(background);
        g.fillRect(0, 0, width, height);
        g.setPaint(foreground);
    }

    public void drawNode(Matrix transform) {
        //Vector pos = new Vector(0, 0).applyMatrix();
        shape.drawTransform(g, transform);
        //g.fillRect((int) pos.getX(), (int) pos.getY(), 1, 1);
        //g.fillRect((int)Math.round(node.getX() - node.getSize()), (int)Math.round(node.getY() - node.getSize()), (int)Math.round(node.getSize() * 2), (int)Math.round(node.getSize() * 2));
        //g.fillPolygon();
    }

    public void upload(String filename) throws IOException {
        ImageIO.write(img, "PNG", new File("fractals\\" + filename + ".png"));
    }
}
