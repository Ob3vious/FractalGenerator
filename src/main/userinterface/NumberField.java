package main.userinterface;

import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.util.converter.DoubleStringConverter;
import main.userinterface.UIContent;

public class NumberField implements UIContent {
    private TextField input;
    private String value;
    private double min;
    private double max;

    private UpdateCallback callback;

    public NumberField(int width, int height, double min, double max, double initialValue, UpdateCallback callback) {
        value = "0";
        input = new TextField("" + initialValue);
        input.setPrefSize(width, height);

        input.setOnAction(event -> validate());
        input.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                validate();
            }
        });

        this.min = min;
        this.max = max;

        this.callback = callback;

        validate();
    }

    public void validate() {
        if (input.getText().isEmpty()) {
            input.setText("0");
        } else {
            try {
                double newValue = Math.round(Double.parseDouble(input.getText()) * 1000) / 1000.0;
                if (!(newValue >= min && newValue <= max)) {
                    input.setText(value);
                } else {
                    input.setText("" + newValue);
                }
            } catch (Exception e) {
                input.setText(value);
            } finally {
                input.setText(input.getText().replaceAll("\\.0+$", ""));
                value = input.getText();
            }
        }
        callback.onUpdate();
    }

    public double getValue() {
        return Double.parseDouble(input.getText());
    }

    @Override
    public Node getContent() {
        return input;
    }
}
