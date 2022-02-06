package main.userinterface;

import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.util.converter.DoubleStringConverter;
import main.userinterface.UIContent;

public class NumberField implements UIContent {
    private TextField input;

    public NumberField(int width, int height) {
        input = new TextField();
        input.setTextFormatter(new TextFormatter<>(new DoubleStringConverter()));
        input.setPrefSize(width, height);
    }

    public double getValue() {
        if (input.getText().isEmpty()) {
            input.setText("0.0");
        }
        return Double.parseDouble(input.getText());
    }

    @Override
    public Node getContent() {
        return input;
    }
}
