package org.openjfx;

import java.util.concurrent.Flow;

import org.openjfx.otherClasses.NewGreenCard;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

        Text approver_title = new Text("Approver");
        approver_title.getStyleClass().add("approver-title");

        hbox.getChildren().addAll(approver_title);

        border.setTop(hbox);

        // input box
        GridPane rootNode = new GridPane();
        rootNode.getStyleClass().addAll("submission");

        Button aButton = new Button("Approve");

        Button daButton = new Button("Disapprove");

        GridPane.setHalignment(aButton, HPos.LEFT);
        TextField result = new TextField();

        GridPane test = new GridPane();
        test.getStyleClass().addAll("center-hbox");

        test.add(rootNode, 0, 0);

        aButton.setOnAction(e -> {

        });

        Label success = new Label("Click approve or disapprove.");

        Button loadRequestButton = new Button("Load Request");
        rootNode.add(loadRequestButton, 0, 1);

        EventHandler<ActionEvent> loadRequest = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                rootNode.add(aButton, 0, 2);
                rootNode.add(daButton, 0, 3);
                rootNode.add(success, 0, 4);
                // rootNode.add(new Label("Approve"), 0, 4);
                // rootNode.add(new Label("Disapprove"), 1, 4);

                // workflow table pulls in the id - since workflow table class is not done yet I
                // will be adding my own ID here.
                String id = "ABC123456789";

                // dummy add internal database
                NewGreenCard request = NewGreenCard.createNewGreenCard("1829 Lois Lane", "Brian Andres", "ABC123456789",
                        "brian@gmail.com");
                InternalDatabase.add("ABC123456789", request);

                NewGreenCard load = InternalDatabase.get(id);
                Text reviewer_title = new Text(
                        "Name: " + load.getName() + " | Address: " + load.getAddress() + " | email: " + load.getEmail()
                                + " | id: " + load.getId());

                rootNode.add(reviewer_title, 0, 0);

            }
        };

        loadRequestButton.setOnAction(loadRequest);

        EventHandler<ActionEvent> approverEntryClick = new EventHandler<ActionEvent>() {

            public void handle(ActionEvent e) {
                // workflow table pulls in the id - since workflow table class is not done yet I
                // will be adding my own ID here.
                success.setText("It has been approved and an email has been sent to the user");

            }
        };

        aButton.setOnAction(approverEntryClick);

        EventHandler<ActionEvent> disapproverEntryClick = new EventHandler<ActionEvent>() {

            public void handle(ActionEvent e) {

                success.setText("It has been disapproved and has ben sent back to the reviewer.");
                ;

            }
        };

        daButton.setOnAction(disapproverEntryClick);

        // left side
        HBox lefthBox = new HBox();
        Text approver_titles = new Text("Approver");
        lefthBox.getChildren().addAll(approver_titles);
        lefthBox.getStyleClass().add("left-hbox");

        // right side
        HBox rightHbox = new HBox();
        Text rightHboxText = new Text("Approver");
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
