package main.fractal;

import main.geometry.*;

public class FractalNode {
    private Matrix transform;
    private Seed seed;

    public FractalNode(Matrix transform, Seed seed) {
        this.transform = transform;
        this.seed = seed;
    }

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
