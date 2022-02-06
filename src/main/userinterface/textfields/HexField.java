package main.userinterface.textfields;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class HexField extends UITextField {
    private Label square;

    public HexField(int width, int height, String initialValue) {
        super(width - height, height, initialValue);

        square = new Label();
        square.setPrefSize(height, height);

        validate();
    }

    @Override
    public void validate() {
        if (input.getText().matches("^[0-9a-f]{6}$")) {
            value = input.getText();
            square.setStyle("-fx-background-color:#" + value);
        } else {
            input.setText(value);
        }
    }

    public Color getColor() {
        return Color.valueOf(value);
    }

    @Override
    public Node getContent() {
        return new HBox(input, square);
    }
}