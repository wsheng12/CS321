package org.openjfx;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class ReviewerScene {

    public Scene createScene() {
        // Create a layout for the new scene
        StackPane layout = new StackPane();
        Button button = new Button("New Scene Button");
        layout.getChildren().add(button);

        // Create a new scene with the layout
        Scene scene = new Scene(layout, Constants.SCREEN_SIZE_X, Constants.SCREEN_SIZE_Y);

        // Return the created scene
        return scene;
    }
}
