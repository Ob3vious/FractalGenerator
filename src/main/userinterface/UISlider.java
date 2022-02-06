package main.userinterface;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Slider;


public class UISlider implements UIContent{
    private Slider slider;

    public UISlider(int width, int height) {
        slider = new Slider(0, 1, 0);
        slider.setPrefSize(width, height);
    }

    public void setOnAction(SliderCallback callback) {
        slider.valueProperty().addListener((ov, old_val, new_val) -> callback.onChange());
    }

    public double getValue() {
        return slider.getValue();
    }

    @Override
    public Node getContent() {
        return slider;
    }
}
