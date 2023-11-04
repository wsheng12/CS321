package org.openjfx;

import java.util.concurrent.Flow;

import org.openjfx.otherClasses.NewGreenCard;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Box;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class ApproverScene {

    public Scene createScene() {
        // dummy object
        NewGreenCard request = NewGreenCard.createNewGreenCard("1829 Lois Lane", "Brian Andres", "ABC123456789",
                "brian@gmail.com");

        // Create a new scene with the layout

        BorderPane border = new BorderPane();
        HBox hbox = new HBox();

        // top part
        hbox.getStyleClass().add("top-hbox");

        Text reviewer_title = new Text("Reviewer");
        reviewer_title.getStyleClass().add("reviewer-title");

        hbox.getChildren().addAll(reviewer_title);

        border.setTop(hbox);

        // input box
        GridPane rootNode = new GridPane();
        rootNode.getStyleClass().addAll("submission");

        rootNode.add(new Label("Name:"), 0, 0);
        TextField name = new TextField();
        rootNode.add(name, 1, 0);

        rootNode.add(new Label("Address:"), 0, 1);
        TextField address = new TextField();
        rootNode.add(address, 1, 1);

        rootNode.add(new Label("Email:"), 0, 2);
        TextField email = new TextField();
        rootNode.add(email, 1, 2);

        rootNode.add(new Label("ID:"), 0, 3);
        TextField id = new TextField();
        rootNode.add(id, 1, 3);

        rootNode.add(new Label("Submit"), 0, 4);

        Button aButton = new Button("Submit");
        rootNode.add(aButton, 1, 4);

        GridPane.setHalignment(aButton, HPos.LEFT);
        TextField result = new TextField();

        GridPane test = new GridPane();
        test.getStyleClass().addAll("center-hbox");

        test.add(rootNode, 0, 0);
        // test.add(leftHbox);

        aButton.setOnAction(e -> {
            System.out.println(address.getText());
            System.out.println(name.getText());
            System.out.println(email.getText());
            System.out.println(id.getText());

        });

        // left side
        HBox lefthBox = new HBox();
        Text reviewer_titles = new Text("Reviewer");
        lefthBox.getChildren().addAll(reviewer_titles);
        lefthBox.getStyleClass().add("left-hbox");

        // right side
        HBox rightHbox = new HBox();
        Text rightHboxText = new Text("Reviewer");
        rightHbox.getChildren().addAll(rightHboxText);
        rightHbox.getStyleClass().add("right-hbox");

        // bottom
        HBox botHbox = new HBox();
        Text botText = new Text("bottomTextLOL");
        botHbox.getChildren().addAll(botText);
        botHbox.getStyleClass().add("bot-hbox");

        border.setLeft(lefthBox);
        border.setRight(rightHbox);
        border.setBottom(botHbox);

        border.setCenter(test);
        // addStackPane(hbox); // Add stack to HBox in top region

        Scene scene = new Scene(border, Constants.SCREEN_SIZE_X, Constants.SCREEN_SIZE_Y);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        // Return the created scene
        return scene;
    }

}
