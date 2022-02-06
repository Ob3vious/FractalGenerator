package main.userinterface.textfields;

public class IntegerField extends UITextField {
    private int min;
    private int max;

    public IntegerField(int width, int height, int min, int max, int initialValue) {
        super(width, height, "" + initialValue);

        this.min = min;
        this.max = max;

        validate();
    }

    @Override
    public void validate() {
        try {
            int newValue = Integer.parseInt(input.getText());
            if (!(newValue >= min && newValue <= max)) {
                input.setText(value);
            } else {
                input.setText("" + newValue);
            }
        } catch (Exception e) {
            input.setText(value);
        } finally {
            value = input.getText();
            update();
        }
    }

    public int getValue() {
        return Integer.parseInt(value);
    }
}
