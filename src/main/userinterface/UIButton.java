package main.userinterface;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;

public class UIButton implements UIContent {
    private Button button;

    public UIButton(int width, int height, String label) {
        button = new Button(label);
        button.setPrefSize(width, height);
    }

    public void setOnAction(EventHandler<ActionEvent> handler) {
        button.setOnAction(handler);
    }

    @Override
    public Node getContent() {
        return button;
    }
}
