package main.userinterface;

import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class TabViewer implements UIContent {
    private TabPane tabPane;

    public TabViewer(Tab... tabs) {
        this.tabPane = new TabPane(tabs);
    }

    @Override
    public Node getContent() {
        return this.tabPane;
    }
}
