import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;

public class Main extends Application{
    //Launch application
    public static void main(String[] args){launch(args);}

    //Height & width of window for project
    protected static final int WIDTH = 500;
    protected static final int HEIGHT = 400;
    protected static final ArrayList<User> userList = User.getUserList();

    //Start Application
    @Override
    public void start(Stage window) throws Exception{
        //Set title for window
        window.setTitle("Rock Solid Credit Union");
        window.setResizable(false);
        //Load First Scene
        window.setScene(Scene1.setScene1(window));
        window.show();
    }
}
