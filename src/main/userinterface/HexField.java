package main.userinterface;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class HexField implements UIContent {
    private TextField input;
    private Label square;
    private String hexcode;

    public HexField(int width, int height, String initialCode) {
        hexcode = initialCode;
        input = new TextField(initialCode);
        input.setPrefSize(width - height, height);

        input.setOnAction(event -> validate());
        input.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                validate();
            }
        });

        square = new Label();
        square.setPrefSize(height, height);
        validate();
    }

    public void validate() {
        if (input.getText().matches("^[0-9a-f]{6}$")) {
            hexcode = input.getText();
            square.setStyle("-fx-background-color:#" + hexcode);
        } else {
            input.setText(hexcode);
        }
    }

    public Color getColor() {
        return Color.valueOf(hexcode);
    }

    @Override
    public Node getContent() {
        return new HBox(input, square);
    }
}