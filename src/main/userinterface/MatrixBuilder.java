package main.userinterface;

import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import main.fractal.FractalView;
import main.geometry.Matrix;
import main.geometry.shapes.Rhomboid;
import main.userinterface.textfields.DoubleField;

public class MatrixBuilder implements UIContent, UpdateCallback {
    private DoubleField[] numberFields = new DoubleField[6];
    private HBox mainBox;
    private GridPane grid;
    private Canvas canvas;
    private FractalView view;

    private UpdateCallback callback;

    public MatrixBuilder() {
        grid = new GridPane();

        for (int i = 0; i < 6; i++) {
            //the formula constructs a identity matrix
            numberFields[i] = new DoubleField(64, 32, -2, 2, (i % 3 == 0 ? 1 : 0));
            numberFields[i].setCallback(this);
            grid.add(numberFields[i].getContent(), i / 2, i % 2);
        }

        canvas = new Canvas(64, 64);
        view = new FractalView(canvas, new Rhomboid());
        view.setColors(Color.valueOf("202020"), Color.valueOf("e0e0e0"));

        mainBox = new HBox(grid, canvas);

        onUpdate();
    }

    public Matrix getMatrix() {
        return new Matrix(new double[][]{
                {numberFields[0].getValue(), numberFields[2].getValue(), numberFields[4].getValue()},
                {numberFields[1].getValue(), numberFields[3].getValue(), numberFields[5].getValue()},
                {0, 0, 1}});
    }

    public void setCallback(UpdateCallback callback) {
        this.callback = callback;
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
        if (callback != null)
            callback.onUpdate();
    }
}
