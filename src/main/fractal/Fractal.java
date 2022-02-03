package main.fractal;

import main.geometry.Matrix;
import main.geometry.shapes.Point;

import java.awt.*;

public class Fractal {
    private FractalImage image;
    private FractalNode node;

    public Fractal(int resolution, FractalNode node, double scaleCap) {
        image = new FractalImage(resolution, resolution, new Color(64, 64, 64), new Color(192, 192, 192), new Point());
        this.node = node;
        node.iterate(scaleCap, image);

        try {
            image.upload("temp");
            System.out.println("Upload successful");
        } catch (Exception e) {
            System.out.println("fuck!");
        }
    }
}
