package main.userinterface.textfields;

import javafx.scene.Node;
import javafx.scene.control.TextField;
import main.userinterface.UIContent;
import main.userinterface.UpdateCallback;

public abstract class UITextField implements UIContent {
    protected TextField input;
    protected String value;

    private UpdateCallback callback;

    public UITextField(int width, int height, String initialValue) {
        value = initialValue;
        input = new TextField(initialValue);
        input.setPrefSize(width, height);

        input.setOnAction(event -> validate());
        input.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                validate();
            }
        });
    }

    public abstract void validate();

    public void setCallback(UpdateCallback callback) {
        this.callback = callback;
    }

    protected void update() {
        if (callback != null)
            callback.onUpdate();
    }

    @Override
    public Node getContent() {
        return input;
    }
}
