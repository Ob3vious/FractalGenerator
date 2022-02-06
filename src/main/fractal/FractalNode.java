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
     * @param view    the image to draw the fractal on
     */
    public void iterate(double scaleCap, FractalView view) {
        if (scaleCap > this.transform.getScalar()) {
            view.drawNode(this.transform);
            return;
        }

        for (Seedling seedling : seed.getSeedlings())
            iterateSingle(seedling).iterate(scaleCap, view);
    }

    private FractalNode iterateSingle(Seedling seedling) {
        Matrix newTransform = this.transform.multiplyBy(seedling.getTransform());
        Seed newSeed = seedling.getSeed();
        return new FractalNode(newTransform, newSeed);
    }
}
