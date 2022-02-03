package main.geometry;

import java.util.Arrays;

public class Matrix {
    //note: rows then columns
    private double[][] values;

    public Matrix(double[][] values) {
        this.values = values;
    }

    public int getWidth() {
        return this.values[0].length;
    }

    public int getHeight() {
        return this.values.length;
    }

    public double get(int row, int column) {
        return this.values[row][column];
    }

    public Matrix multiplyBy(Matrix secondMatrix) {
        if (this.getWidth() != secondMatrix.getHeight()) {
            return null;
        }

        double[][] newValues = new double[this.getHeight()][secondMatrix.getWidth()];
        for (int i = 0; i < this.getHeight(); i++) {
            for (int j = 0; j < secondMatrix.getWidth(); j++) {
                for (int k = 0; k < this.getWidth(); k++) {
                    newValues[i][j] += this.get(i, k) * secondMatrix.get(k, j);
                }
            }
        }

        return new Matrix(newValues);
    }

    public double getScalar() {
        // note that the determinant of a 2x2 matrix returns the area of the parallelogram formed from square at 0,0 and 1,1
        // only the top left 2x2 of the 3x3 matrix is relevant for scaling as the third column is for shifting only
        return Math.abs(
                this.get(0, 0) * this.get(1, 1)
                - this.get(1, 0) * this.get(0, 1));
    }
}
