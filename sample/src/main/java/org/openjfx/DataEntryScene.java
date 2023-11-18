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

public class DataEntryScene {

    public Scene createScene(Stage s) {
        // dummy object
        NewGreenCard request = NewGreenCard.createNewGreenCard("1829 Lois Lane", "Brian Andres", "ABC123456789",
                "brian@gmail.com");

        // Create a new scene with the layout

        BorderPane border = new BorderPane();

        // input box
        GridPane rootNode = new GridPane();

        rootNode.getStyleClass().addAll("enter");

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

        TextField result = new TextField();

        GridPane test = new GridPane();
        test.getStyleClass().addAll("center-hbox");

        test.add(rootNode, 0, 0);

        Label success = new Label("Click the button to send to be sent for review");
        rootNode.add(success, 0, 5);

        EventHandler<ActionEvent> dataEntryClick = new EventHandler<ActionEvent>() {

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
                }

                if (checkNull == 0) {
                    if (id.getText().equals(external.searchExternalDatabase(id.getText()).getId())) {
                        count++;
                    }
                    ;
                    if (name.getText().equals(external.searchExternalDatabase(id.getText()).getName())) {
                        count++;
                    }
                    ;
                    if (address.getText().equals(external.searchExternalDatabase(id.getText()).getAddress())) {
                        count++;
                    }
                    ;

                }

                if (count == 3) {
                    InternalDatabase.add(id.getText(), greenCard);
                    success.setText("Data is validated, and will be sent to be reviewed");
                    WorkflowTable.addReviewer(id.getText());

                } else {
                    success.setText("Data is incorrect and has not been validated, please re-enter data.");

                }

            }
        };

        aButton.setOnAction(dataEntryClick);

        HBox rightHbox = new HBox();
        Text rightHboxText = new Text("Data Entry");
        rightHbox.getChildren().addAll(rightHboxText);
        rightHbox.getStyleClass().add("right-hbox");

        HBox botHbox = new HBox();
        Text botText = new Text("bottomText");
        botHbox.getChildren().addAll(botText);
        botHbox.getStyleClass().add("bot-hbox");

        border.setRight(rightHbox);
        border.setBottom(botHbox);

        border.setCenter(test);

        Scene scene = new Scene(border, Constants.SCREEN_SIZE_X, Constants.SCREEN_SIZE_Y);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        // Return back
        BackButton createBackButton = new BackButton();
        Button backButton = createBackButton.createButton(s);
        rootNode.add(backButton, 3, 6);

        return scene;
    }

}
