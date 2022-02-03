package main;

import main.fractal.*;
import main.geometry.Matrix;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        Seed seed = new Seed();

        seed.addSeedling(new Seedling(new Matrix(new double[][] {
                {0, .5, 0},
                {-1, 0, 0},
                {0, 0, 1}}), seed));
        seed.addSeedling(new Seedling(new Matrix(new double[][] {
                {.5, 0, -.5},
                {-.5, .5, 0},
                {0, 0, 1}}), seed));
        seed.addSeedling(new Seedling(new Matrix(new double[][] {
                {.5, 0, .5},
                {.5, .5, 0},
                {0, 0, 1}}), seed));

        FractalNode node = new FractalNode(new Matrix(new double[][] {
                {2048, 0, 2048},
                {0, -2048, 2048},
                {0, 0, 1}}), seed);

        Fractal fractal = new Fractal(4096, node, 1);
    }
}
