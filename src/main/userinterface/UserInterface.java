package main.userinterface;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.userinterface.tabs.UITab;
import main.userinterface.tabs.*;

public class UserInterface extends Application {

    @Override
    public void start(Stage stage) {
        UIContent uiContent = new TabViewer(new ViewTab().getContent());
        Scene scene = new Scene((Parent) uiContent.getContent());
        stage.setScene(scene);
        stage.setTitle("Fractal Generator");
        stage.show();
    }
}
