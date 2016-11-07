import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Scene1{
    //Scene 1 variable
    protected static Scene scene1;

    //Set scene 1
    protected static Scene setScene1(Stage window){
        //Set up scene1
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        //Welcome Label
        Label welcome = new Label("Welcome to Rock Solid Credit Union");
        welcome.setId("big-label");
        //Instruction label
        Label instruction = new Label("Please insert your ATM card!");
        instruction.setId("med-label");
        //Button that directs to scene 2
        Button button = new Button("Insert ATM Card");
        button.setOnAction(e -> window.setScene(Scene2.setScene2(window)));
        //Set Layout variables
        layout.getChildren().addAll(welcome, instruction, button);
        //Create sceen with layout set and window width & height
        scene1 = new Scene(layout, Main.WIDTH, Main.HEIGHT);
        //Get style sheet
        scene1.getStylesheets().add("screen.css");
        //Return scene
        return scene1;
    }

    //Get Scene 1 if it has already been set
    protected static Scene getScene1(){return scene1;}
}
