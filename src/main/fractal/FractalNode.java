package main.fractal;

import main.geometry.*;

public class FractalNode {
    private Matrix transform;
    private Seed seed;

    public FractalNode(Matrix transform, Seed seed) {
        this.transform = transform;
        this.seed = seed;
    }

    /**
     * Processes part of the fractal generation by generating all of its copies.
     * If the node is too small, its image will be drawn.
     *
     * @param scaleCap the scale at which iterating is stopped
     * @param image    the image to draw the fractal on
     */
    public void iterate(double scaleCap, FractalImage image) {
        if (scaleCap > this.transform.getScalar()) {
            image.drawNode(this.transform);
            return;
        }

        for (Seedling seedling : seed.getSeedlings())
            iterateSingle(seedling).iterate(scaleCap, image);
    }

    private FractalNode iterateSingle(Seedling seedling) {
        Matrix newTransform = this.transform.multiplyBy(seedling.getTransform());
        Seed newSeed = seedling.getSeed();
        return new FractalNode(newTransform, newSeed);
    }
}
