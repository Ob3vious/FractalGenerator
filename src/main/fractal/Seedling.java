package main.fractal;

import main.geometry.Matrix;

public class Seedling {
    private Matrix transform;
    private Seed seed;

    public Seedling(Matrix transform, Seed seed) {
        this.transform = transform;
        this.seed = seed;
    }

    public Matrix getTransform() {
        return transform;
    }

    public Seed getSeed() {
        return seed;
    }
}
