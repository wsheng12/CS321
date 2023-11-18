package org.openjfx;

import java.util.concurrent.Flow;

import org.openjfx.otherClasses.WorkflowTable;

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

public class ReviewerScene {

    public Scene createScene() {

        // Create a new scene with the layout

        BorderPane border = new BorderPane();
        HBox hbox = new HBox();

        // top part
        hbox.getStyleClass().add("top-hbox");

        Text reviewer_title = new Text("Reviewer");
        reviewer_title.getStyleClass().add("reviewer-title");

        hbox.getChildren().addAll(reviewer_title);

        border.setTop(hbox);

        Button aButton = new Button("Submit");

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

        GridPane.setHalignment(aButton, HPos.LEFT);

        GridPane CenterNode = new GridPane();
        CenterNode.getStyleClass().addAll("center-hbox");

        CenterNode.add(rootNode, 0, 2);
        Button loadRequestButton = new Button("Load Request");
        CenterNode.add(loadRequestButton, 0, 1);
        // CenterNode.add(leftHbox);

        Label success = new Label(
                "Re-enter the information above and click the submit button to send to approver (any edits will be validated before sending - you should only edit the email if needed)");

        // this button loads the request
        EventHandler<ActionEvent> loadRequest = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {

                rootNode.add(aButton, 1, 4);
                CenterNode.add(success, 0, 5);

                // workflow table pulls in the id - since workflow table class is not done yet I
                // will be adding my own ID here.
                String id = WorkflowTable.popReviewer();

                // dummy add internal database
                NewGreenCard request = NewGreenCard.createNewGreenCard("1829 Lois Lane", "Brian Andres", "ABC123456789",
                        "brian@gmail.com");
                InternalDatabase.add("ABC123456789", request);

                NewGreenCard load = InternalDatabase.get(id);
                Text reviewer_title = new Text(
                        "Name: " + load.getName() + " | Address: " + load.getAddress() + " | email: " + load.getEmail()
                                + " | id: " + load.getId());

                CenterNode.add(reviewer_title, 0, 0);

            }
        };

        EventHandler<ActionEvent> submit = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                ExternalDatabase external = new ExternalDatabase();
                int count = 0;
                int checkNull = 0;
                NewGreenCard greenCard = NewGreenCard.createNewGreenCard(address.getText(), name.getText(),
                        id.getText(), email.getText());

                if (external.searchExternalDatabase(id.getText()) == null) {
                    checkNull--;
                } else if (external.searchExternalDatabase(id.getText()).getName() == null) {
                    checkNull--;
                } else if (external.searchExternalDatabase(id.getText()).getAddress() == null) {
                    checkNull--;
                } else if (external.searchExternalDatabase(id.getText()).getEmail() == null) {
                    checkNull--;
                }

                if (checkNull == 0) {
                    if (id.getText().equals(external.searchExternalDatabase(id.getText()).getId())) {
                        count++;
                    }

                    if (name.getText().equals(external.searchExternalDatabase(id.getText()).getName())) {
                        count++;
                    }

                    if (address.getText().equals(external.searchExternalDatabase(id.getText()).getAddress())) {
                        count++;
                    }

                    // don't check gmail because reviewer can change the gmail when they edit data
                    // (this is the only field they should change).

                }

                if (count == 3) {
                    InternalDatabase.replace(id.getText(), greenCard);
                    success.setText("Data is correct and validated. It has been sent to the approver for final approval.");
                    WorkflowTable.addApprover(id.getText());

                } else {
                    success.setText("Data is incorrect and has not been validated, please re-enter data.");
                    // dummy send to the workflow table

                }

            }
        };

        aButton.setOnAction(submit);

        loadRequestButton.setOnAction(loadRequest);

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
        Text botText = new Text("bottomText");
        botHbox.getChildren().addAll(botText);
        botHbox.getStyleClass().add("bot-hbox");

        border.setLeft(lefthBox);
        border.setRight(rightHbox);
        border.setBottom(botHbox);

        border.setCenter(CenterNode);
        // addStackPane(hbox); // Add stack to HBox in top region

        Scene scene = new Scene(border, Constants.SCREEN_SIZE_X, Constants.SCREEN_SIZE_Y);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        // Return the created scene
        return scene;
    }

}