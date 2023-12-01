package org.openjfx;

import java.util.concurrent.Flow;

import org.openjfx.otherClasses.NewGreenCard;
import org.openjfx.otherClasses.WorkflowTable;

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
import javafx.stage.Stage;

public class ApproverScene {
    String id;

    public Scene createScene(Stage s) {

        // dummy object
        NewGreenCard request = NewGreenCard.createNewGreenCard("1829 Lois Lane", "Brian Andres", "ABC123456789",
                "brian@gmail.com");

        // Create a new scene with the layout

        BorderPane border = new BorderPane();
        HBox hbox = new HBox();

        border.setTop(hbox);

        // input box
        GridPane origin = new GridPane();
        origin.getStyleClass().addAll("submission");

        Button aButton = new Button("Approve");

        Button daButton = new Button("Disapprove");

        GridPane.setHalignment(aButton, HPos.LEFT);
        TextField result = new TextField();

        GridPane assess = new GridPane();
        assess.getStyleClass().addAll("center-hbox");

        assess.add(origin, 0, 0);

        aButton.setOnAction(e -> {

        });

        Label success = new Label("Click approve or disapprove.");

        Button loadRequestButton = new Button("Load Request");
        origin.add(loadRequestButton, 0, 1);

        EventHandler<ActionEvent> loadRequest = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                origin.add(aButton, 0, 2);
                origin.add(daButton, 0, 3);
                origin.add(success, 0, 4);
                // origin.add(new Label("Approve"), 0, 4);
                // origin.add(new Label("Disapprove"), 1, 4);

                // workflow table pulls in the id - since workflow table class is not done yet I
                // will be adding my own ID here.
                id = WorkflowTable.popApprover();

                // dummy add internal database
                NewGreenCard request = NewGreenCard.createNewGreenCard("1829 Lois Lane", "Brian Andres", "ABC123456789",
                        "brian@gmail.com");
                InternalDatabase.add("ABC123456789", request);

                NewGreenCard load = InternalDatabase.get(id);
                Text reviewer_title = new Text("Name: " + load.getName() + " | Address: " + load.getAddress()
                        + " | email: " + load.getEmail() + " | id: " + load.getId());

                origin.add(reviewer_title, 0, 0);

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
                
                WorkflowTable.addReviewer(id);
            }
        };

        daButton.setOnAction(disapproverEntryClick);

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

        border.setRight(rightHbox);
        border.setBottom(botHbox);

        border.setCenter(assess);
        // addStackPane(hbox); // Add stack to HBox in top region

        BackButton createBackButton = new BackButton();
        Button backButton = createBackButton.createButton(s);
        origin.add(backButton, 3, 6);

        Scene scene = new Scene(border, Constants.SCREEN_SIZE_X, Constants.SCREEN_SIZE_Y);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        // Return the created scene
        return scene;
    }

}
