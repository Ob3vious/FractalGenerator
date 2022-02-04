package main.fractal;

import main.geometry.shapes.Point;

import java.awt.*;

public class Fractal {
    private FractalImage image;
    private FractalNode node;

    public Fractal(int resolution, FractalNode node, double scaleCap) {
        this.image = new FractalImage(resolution, resolution, new Color(64, 64, 64), new Color(192, 192, 192), new Point());
        this.node = node;
        this.node.iterate(scaleCap, image);
    }

    /**
     * Uploads the constructed fractal as a PNG in the folder fractals.
     *
     * @param filename the name of the image file
     */
    public void upload(String filename) {
        try {
            this.image.upload(filename);
            System.out.println("Upload successful");
        } catch (Exception e) {
            System.out.println("fuck!");
        }
    }
}
