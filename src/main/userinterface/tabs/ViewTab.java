package main.userinterface.tabs;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import main.fractal.*;
import main.geometry.Matrix;
import main.geometry.shapes.Rhomboid;
import main.userinterface.*;
import main.userinterface.textfields.HexField;
import main.userinterface.textfields.IntegerField;
import main.userinterface.textfields.DoubleField;
import main.userinterface.textfields.NameField;

public class ViewTab extends UITab implements UpdateCallback {
    private HBox mainBox;
    private Canvas canvas;
    private VBox secondaryBox;
    private TransformPicker transform;
    private HBox colorBox;
    private HexField backgroundColor;
    private HexField foregroundColor;
    private UIButton viewButton;
    private VBox exportMenu;
    private HBox resolutionBox;
    private IntegerField imageSize;
    private DoubleField scaleCapper;
    private NameField imageName;
    private UIButton exportButton;

    private Seed seed;
    private FractalView view;

    public ViewTab() {
        super("View");


        seed = new Seed();

        seed.addSeedling(new Seedling(new Matrix(new double[][]{
                {0, -.25, 0},
                {.75, 0, -.25},
                {0, 0, 1}}), seed));
        seed.addSeedling(new Seedling(new Matrix(new double[][]{
                {0, .25, 0},
                {-.75, 0, .25},
                {0, 0, 1}}), seed));
        seed.addSeedling(new Seedling(new Matrix(new double[][]{
                {.5, 0, -.5},
                {-.25, .5, 0},
                {0, 0, 1}}), seed));
        seed.addSeedling(new Seedling(new Matrix(new double[][]{
                {.5, 0, .5},
                {.25, .5, 0},
                {0, 0, 1}}), seed));

        canvas = new Canvas(512, 512);

        transform = new TransformPicker();


        backgroundColor = new HexField(128, 32, "202020");
        foregroundColor = new HexField(128, 32, "e0e0e0");
        colorBox = new HBox(backgroundColor.getContent(), foregroundColor.getContent());

        view = new FractalView(canvas, new Rhomboid());

        imageSize = new IntegerField(64, 32, 32, 4096, 512);
        scaleCapper = new DoubleField(64, 32, 0.0005, 1, 0.25);
        imageName = new NameField(128, 32, "fractal");
        resolutionBox = new HBox(imageSize.getContent(), scaleCapper.getContent(), imageName.getContent());
        exportButton = new UIButton(256, 64, "Export");
        exportButton.setOnAction(event -> {
            Matrix m = transform.getMatrix();
            view.setColors(backgroundColor.getColor(), foregroundColor.getColor());
            view.setNode(new FractalNode(m, seed));
            System.out.println(view.export(imageSize.getValue(), scaleCapper.getValue() * Math.pow(1.0 / imageSize.getValue(), 2), imageName.getValue()));
        });
        exportMenu = new VBox(resolutionBox, exportButton.getContent());

        viewButton = new UIButton(256, 64, "Generate");
        viewButton.setOnAction(event -> {
            Matrix m = transform.getMatrix();
            view.setColors(backgroundColor.getColor(), foregroundColor.getColor());
            view.setNode(new FractalNode(m, seed));
            view.draw(0.25 * Math.pow(1.0 / 512, 2));
        });

        secondaryBox = new VBox(transform.getContent(), colorBox, viewButton.getContent(), exportMenu);
        secondaryBox.setSpacing(32);

        mainBox = new HBox(canvas, secondaryBox);

        super.setContent(mainBox);
    }

    @Override
    public void onUpdate() {

    }
}
