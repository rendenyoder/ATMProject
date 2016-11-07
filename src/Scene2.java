import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Scene2{
    //Scene 2 variable
    protected static Scene scene2;
    private static String pinNumber = "";

    //Set Scene 2
    protected static Scene setScene2(Stage window){
        //Create layout for upper part of screen
        VBox upperlayout = new VBox(20);
        upperlayout.setAlignment(Pos.CENTER);
        //Welcome Label
        Label prompt = new Label("Please enter your ATM pin");
        prompt.setId("top-label");
        //Instruction label
        Label pinLabel = new Label("");
        pinLabel.setId("big-label");
        //Set Layout variables
        upperlayout.getChildren().addAll(prompt, pinLabel);

        //Create grid for lower part of screen
        GridPane lowerGrid = new GridPane();
        lowerGrid.setAlignment(Pos.CENTER);
        lowerGrid.setPadding(new Insets(10, 10, 10, 10));
        lowerGrid.setVgap(8);
        lowerGrid.setHgap(10);

        //Print button
        Button printReciept = new Button("Print Reciept");
        printReciept.getStyleClass().add("button-blue");
        printReciept.setMinWidth(100);
        lowerGrid.setConstraints(printReciept, 0, 0);
        //Enter button
        Button enter = new Button("Enter");
        enter.getStyleClass().add("button-blue");
        enter.setMinWidth(100);
        lowerGrid.setConstraints(enter, 4, 0);
        enter.setOnAction(e -> window.setScene(Scene3.setScene3(window)));
        //Clear button
        Button clear = new Button("Clear");
        clear.setMinWidth(100);
        lowerGrid.setConstraints(clear, 0, 3);
        //Cancel button that return to home scene (scene 1)
        Button cancel = new Button("Cancel");
        cancel.setOnAction(e -> window.setScene(Scene1.getScene1()));
        cancel.setMinWidth(100);
        lowerGrid.setConstraints(cancel, 4, 3);

        //Create each button for number pad
        Button button1 = new Button("1");
        lowerGrid.setConstraints(button1, 1, 0);
        Button button2 = new Button("2");
        lowerGrid.setConstraints(button2, 2, 0);
        Button button3 = new Button("3");
        lowerGrid.setConstraints(button3, 3, 0);
        Button button4 = new Button("4");
        lowerGrid.setConstraints(button4, 1, 1);
        Button button5 = new Button("5");
        lowerGrid.setConstraints(button5, 2, 1);
        Button button6 = new Button("6");
        lowerGrid.setConstraints(button6, 3, 1);
        Button button7 = new Button("7");
        lowerGrid.setConstraints(button7, 1, 2);
        Button button8 = new Button("8");
        lowerGrid.setConstraints(button8, 2, 2);
        Button button9 = new Button("9");
        lowerGrid.setConstraints(button9, 3, 2);
        Button button0 = new Button("0");
        lowerGrid.setConstraints(button0, 2, 3);

        //Set button action
        button1.setOnAction(e -> setPin(1, pinLabel));
        button2.setOnAction(e -> setPin(2, pinLabel));
        button3.setOnAction(e -> setPin(3, pinLabel));
        button4.setOnAction(e -> setPin(4, pinLabel));
        button5.setOnAction(e -> setPin(5, pinLabel));
        button6.setOnAction(e -> setPin(6, pinLabel));
        button7.setOnAction(e -> setPin(7, pinLabel));
        button8.setOnAction(e -> setPin(8, pinLabel));
        button9.setOnAction(e -> setPin(9, pinLabel));
        button0.setOnAction(e -> setPin(0, pinLabel));
        clear.setOnAction(e -> {
            pinLabel.setText("");
            pinNumber = "";
        });

        //Add each to lower grid
        lowerGrid.getChildren().addAll(
                printReciept, enter, clear, cancel, button1, button2, button3,
                button4, button5, button6, button7, button8, button9, button0);

        //Combine top and bottom into one pane
        BorderPane layout = new BorderPane();
        layout.setTop(upperlayout);
        layout.setCenter(lowerGrid);

        //Draw scene
        scene2 = new Scene(layout, Main.WIDTH, Main.HEIGHT);
        //Get style sheet
        scene2.getStylesheets().add("screen.css");
        //Return new scene
        return scene2;
    }

    //Get Scene 2 if it has already been set
    public Scene getScene2(){return scene2;}

    private static void setPin(int x, Label label){
        if(pinNumber.length() < 4) {
            pinNumber += x;
            label.setText(label.getText() + " * ");
        }
    }
}