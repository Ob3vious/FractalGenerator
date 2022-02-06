package main.userinterface;

import javafx.scene.Node;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class ColorPicker implements UIContent, SliderCallback {
    private VBox sliderBox;
    private UISlider[] sliders;
    private Color color;

    public ColorPicker(int width) {
        sliders = new UISlider[3];
        for (int i = 0; i < 3; i++) {
            sliders[i] = new UISlider(width, 32);
            sliders[i].setOnAction(this);
        }
        sliderBox = new VBox(sliders[0].getContent(), sliders[1].getContent(), sliders[2].getContent());
        color = new Color(0, 0, 0, 1);
    }

    public Color getColor() {
        return this.color;
    }

    @Override
    public Node getContent() {
        return this.sliderBox;
    }

    @Override
    public void onChange() {
        this.color = new Color(sliders[0].getValue(), sliders[1].getValue(), sliders[2].getValue(), 1);
        System.out.println(this.color);
    }
}
