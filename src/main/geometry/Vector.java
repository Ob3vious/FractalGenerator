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

    /**
     * Applies a matrix transform to the vector. Note that this changes this vector.
     *
     * @param secondMatrix the matrix to transform the vector by
     * @return the vector resulting from the transformation
     */
    public Vector applyMatrix(Matrix secondMatrix) {
        this.matrix = secondMatrix.multiplyBy(this.matrix);
        return this;
    }
}
