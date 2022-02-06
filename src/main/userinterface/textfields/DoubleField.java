package main.userinterface.textfields;


public class DoubleField extends UITextField {
    private double min;
    private double max;

    public DoubleField(int width, int height, double min, double max, double initialValue) {
        super(width, height, "" + initialValue);

        this.min = min;
        this.max = max;

        validate();
    }

    @Override
    public void validate() {
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
            update();
        }
    }

    public double getValue() {
        return Double.parseDouble(value);
    }
}
