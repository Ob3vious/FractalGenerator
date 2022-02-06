package main.userinterface;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import main.geometry.Matrix;

public class TransformPicker implements UIContent {
    private NumberField[] numberFields = new NumberField[6];
    private GridPane grid;

    public TransformPicker() {
        grid = new GridPane();

        for (int i = 0; i < 6; i++) {
            //the formula constructs a identity matrix
            numberFields[i] = new NumberField(96, 32, -2, 2, (i % 3 == 0 ? 1 : 0));
        }

        for (int i = 0; i < 6; i++) {
            grid.add(numberFields[i].getContent(), i / 2, i % 2);
        }
    }

    public Matrix getMatrix() {
        return new Matrix(new double[][]{
                {numberFields[0].getValue(), numberFields[2].getValue(), numberFields[4].getValue()},
                {numberFields[1].getValue(), numberFields[3].getValue(), numberFields[5].getValue()},
                {0, 0, 1}});
    }

    @Override
    public Node getContent() {
        return grid;
    }
}
