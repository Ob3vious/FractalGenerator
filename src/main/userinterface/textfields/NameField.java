package main.userinterface.textfields;

public class NameField extends UITextField {
    public NameField(int width, int height, String initialValue) {
        super(width, height, initialValue);
    }

    @Override
    public void validate() {
        if (input.getText().matches("^[a-zA-Z]{4,16}$")) {
            value = input.getText();
        } else {
            input.setText(value);
        }
    }

    String getValue() {
        return value;
    }
}
