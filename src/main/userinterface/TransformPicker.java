package main.userinterface;

import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import main.fractal.FractalView;
import main.geometry.Matrix;
import main.geometry.shapes.Rhomboid;

public class TransformPicker implements UIContent, UpdateCallback {
    private NumberField[] numberFields = new NumberField[6];
    private HBox mainBox;
    private GridPane grid;
    private Canvas canvas;
    private FractalView view;

    public TransformPicker() {
        grid = new GridPane();

        for (int i = 0; i < 6; i++) {
            //the formula constructs a identity matrix
            numberFields[i] = new NumberField(64, 32, -2, 2, (i % 3 == 0 ? 1 : 0), this);
            grid.add(numberFields[i].getContent(), i / 2, i % 2);
        }

        canvas = new Canvas(64, 64);
        view = new FractalView(canvas, Color.valueOf("202020"), Color.valueOf("e0e0e0"), new Rhomboid());

        mainBox = new HBox(grid, canvas);

        onUpdate();
    }

    public Matrix getMatrix() {
        return new Matrix(new double[][]{
                {numberFields[0].getValue(), numberFields[2].getValue(), numberFields[4].getValue()},
                {numberFields[1].getValue(), numberFields[3].getValue(), numberFields[5].getValue()},
                {0, 0, 1}});
    }

    @Override
    public Node getContent() {
        return mainBox;
    }

    @Override
    public void onUpdate() {
        if (view != null) {
            view.clear();
            view.drawNode(getMatrix());
        }
    }
}
