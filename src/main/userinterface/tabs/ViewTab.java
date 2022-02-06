package main.userinterface.tabs;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import main.fractal.*;
import main.geometry.Matrix;
import main.geometry.shapes.Rhomboid;
import main.userinterface.HexField;
import main.userinterface.TransformPicker;
import main.userinterface.UIButton;

public class ViewTab extends UITab {
    private HBox mainBox;
    private Canvas canvas;
    private VBox secondaryBox;
    private TransformPicker transform;
    private HBox colorBox;
    private HexField backgroundColor;
    private HexField foregroundColor;
    private UIButton button;

    public ViewTab() {
        super("View");


        Seed seed = new Seed();

        seed.addSeedling(new Seedling(new Matrix(new double[][] {
                {0, -.25, 0},
                {.75, 0, -.25},
                {0, 0, 1}}), seed));
        seed.addSeedling(new Seedling(new Matrix(new double[][] {
                {0, .25, 0},
                {-.75, 0, .25},
                {0, 0, 1}}), seed));
        seed.addSeedling(new Seedling(new Matrix(new double[][] {
                {.5, 0, -.5},
                {-.25, .5, 0},
                {0, 0, 1}}), seed));
        seed.addSeedling(new Seedling(new Matrix(new double[][] {
                {.5, 0, .5},
                {.25, .5, 0},
                {0, 0, 1}}), seed));

        canvas = new Canvas(512, 512);

        transform = new TransformPicker();


        backgroundColor = new HexField(144, 32, "202020");
        foregroundColor = new HexField(144, 32, "e0e0e0");
        colorBox = new HBox(backgroundColor.getContent(), foregroundColor.getContent());

        button = new UIButton(288, 64, "Generate!");
        button.setOnAction(event -> {
            FractalView view = new FractalView(canvas, backgroundColor.getColor(), foregroundColor.getColor(), new Rhomboid());
            Matrix m = transform.getMatrix();
            view.clear();
            new FractalNode(m, seed).iterate(Math.pow(1.0/1024, 2), view);
        });

        secondaryBox = new VBox(transform.getContent(), colorBox, button.getContent());

        mainBox = new HBox(canvas, secondaryBox);

        super.setContent(mainBox);
    }
}
