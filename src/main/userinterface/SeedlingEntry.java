package main.userinterface;

import javafx.scene.Node;
import javafx.scene.layout.HBox;
import main.fractal.Seed;
import main.fractal.Seedling;

public class SeedlingEntry implements UIContent {
    private MatrixBuilder matrix;
    private UIButton deleteButton;
    private HBox mainBox;

    private SeedlingList seedList;
    private Seed seed;

    public SeedlingEntry(Seed seed, SeedlingList seedList) {
        this.seedList = seedList;
        this.seed = seed;

        this.matrix = new MatrixBuilder();
        this.deleteButton = new UIButton(64, 32, "Delete");
        this.deleteButton.setOnAction(event -> this.seedList.removeSeedling(this));
        this.mainBox = new HBox(matrix.getContent(), deleteButton.getContent());
    }

    public Seedling getSeedling() {
        return new Seedling(matrix.getMatrix(), seed);
    }

    @Override
    public Node getContent() {
        return mainBox;
    }
}
