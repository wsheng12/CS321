package org.openjfx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage s) {
        // set title for the stage
        s.setTitle("creating buttons");

        MainScene mainScene = new MainScene();
        Scene mainScreen = mainScene.createScene(s);

        // set the scene
        s.setScene(mainScreen);

        s.show();
        s.setMaximized(true);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
