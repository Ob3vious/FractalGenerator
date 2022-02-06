package main.userinterface.tabs;

import javafx.embed.swt.FXCanvas;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import main.fractal.*;
import main.geometry.Matrix;
import main.geometry.shapes.Point;
import main.geometry.shapes.Rhomboid;
import main.userinterface.TransformPicker;
import main.userinterface.UIButton;

import java.awt.*;

public class ViewTab extends UITab {
    private HBox mainBox;
    private Canvas canvas;
    private VBox secondaryBox;
    private TransformPicker transform;
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
        button = new UIButton(288, 64, "Generate!");
        FractalView view = new FractalView(canvas, new Color(0.125, 0.125, 0.125, 1), new Color(0.875, 0.875, 0.875, 1), new Rhomboid());
        button.setOnAction(event -> {
            Matrix m = transform.getMatrix();
            view.clear();
            new FractalNode(m, seed).iterate(Math.pow(1.0/1024, 2), view);
        });

        secondaryBox = new VBox(transform.getContent(), button.getContent());

        mainBox = new HBox(canvas, secondaryBox);

        super.setContent(mainBox);
    }
}
