import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by rendenyoder on 11/4/16.
 */
public class Scene3 {
    //Scene 1 variable
    protected static Scene scene3;

    //Set scene 1
    protected static Scene setScene3(Stage window){
        VBox layout = new VBox();
        scene3 = new Scene(layout, Main.WIDTH, Main.HEIGHT);
        scene3.getStylesheets().add("screen.css");
        return scene3;
    }

    //Get Scene 1 if it has already been set
    protected static Scene getScene3(){return scene3;}
}
