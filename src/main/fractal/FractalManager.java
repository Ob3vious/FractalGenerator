package main.fractal;

import main.geometry.shapes.Point;

import java.awt.*;

public class FractalManager {
    private FractalImage image;
    private FractalNode node;
    private double scaleCap;

    public FractalManager(int resolution, FractalNode node, double scaleCap) {
        this.image = new FractalImage(resolution, new Color(64, 64, 64), new Color(192, 192, 192), new Point());
        this.scaleCap = scaleCap;
        this.node = node;
    }

    /**
     * Uploads the constructed fractal as a PNG in the folder fractals.
     *
     * @param filename the name of the image file
     */
    public void upload(String filename) {
        this.node.iterate(scaleCap, image);
        try {
            this.image.upload(filename);
            System.out.println("Upload successful");
        } catch (Exception e) {
            System.out.println("fuck!");
        }
    }
}
