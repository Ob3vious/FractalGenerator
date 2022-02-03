package main.geometry;

public class Vector {
    private Matrix matrix;

    public Vector(double x, double y) {
        matrix = new Matrix(new double[][]{{x}, {y}, {1}});
    }

    public double getX() {
        return this.matrix.get(0, 0);
    }

    public double getY() {
        return this.matrix.get(1, 0);
    }

    public Vector applyMatrix(Matrix secondMatrix) {
        this.matrix = secondMatrix.multiplyBy(this.matrix);
        return this;
    }
}
