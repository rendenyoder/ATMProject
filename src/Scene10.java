import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Scene10 {
    //Scene 10 variable
    protected static Scene scene10;

    //Set scene 10
    protected static Scene setScene10(Stage window){
        //Set up scene4
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        //Labels
        Label warning = new Label("Unable to process request!");
        Label description = new Label("Are you done using the ATM?");
        //Set Id
        warning.setId("big-label");
        description.setId("med-label");
        //Button that directs to scene 4
        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");
        yesButton.setOnAction(e -> window.setScene(Scene1.getScene1()));
        noButton.setOnAction(e -> window.setScene(Scene5.getScene5()));
        //Set width
        yesButton.setMinWidth(100);
        noButton.setMinWidth(100);
        yesButton.getStyleClass().add("button-red");
        noButton.getStyleClass().add("nav-button");
        //Set Layout variables
        layout.getChildren().addAll(warning, description, yesButton, noButton);
        //Create sceen with layout set and window width & height
        scene10 = new Scene(layout, Main.WIDTH, Main.HEIGHT);
        //Get style sheet
        scene10.getStylesheets().add("screen.css");
        return scene10;
    }

    //Get Scene 8 if it has already been set
    protected static Scene getScene10(){return scene10;}
}