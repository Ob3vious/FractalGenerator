package main.userinterface.tabs;

import javafx.scene.Node;
import javafx.scene.control.Tab;

public class UITab {
    private Tab tab;

    public UITab(String name) {
        tab = new Tab(name);
        tab.setClosable(false);
    }

    public Tab getContent() {
        return this.tab;
    }

    public void setContent(Node content) {
        tab.setContent(content);
    }
}
