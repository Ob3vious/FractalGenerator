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
        BuildTab build = new BuildTab();
        ViewTab view = new ViewTab();
        TabViewer tabViewer = new TabViewer(build.getContent(), view.getContent());

        build.getContent().selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                view.setSeed(build.getSeed());
            }
        });

        Scene scene = new Scene((Parent) tabViewer.getContent());
        stage.setScene(scene);
        stage.setTitle("Fractal Generator");
        stage.setResizable(false);
        stage.show();
    }
}
