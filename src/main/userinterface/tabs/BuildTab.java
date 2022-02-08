package main.userinterface.tabs;

import javafx.scene.layout.VBox;
import main.fractal.Seed;
import main.userinterface.SeedlingList;
import main.userinterface.UIButton;

public class BuildTab extends UITab {
    private VBox mainBox;
    private SeedlingList list;
    private UIButton button;

    public BuildTab() {
        super("Build");
        list = new SeedlingList();

        button = new UIButton(128, 32, "Add");
        button.setOnAction(event -> list.addSeedling());

        mainBox = new VBox(button.getContent(), list.getContent());


        setContent(mainBox);
    }

    public Seed getSeed() {
        this.list.updateSeed();
        return this.list.getSeed();
    }
}
