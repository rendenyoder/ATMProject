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
    protected static final ArrayList<User> userList = new ArrayList<User>(Arrays.asList(
            new User(100, User.hashPin("1234")),
            new User(200, User.hashPin("0000")),
            new User(300, User.hashPin("6423"))));

    //Start Application
    @Override
    public void start(Stage window) throws Exception{
        System.out.println("User #1 Pin: 1234 \nUser #2 Pin: 0000 \nUser #3 Pin: 6423 \n");
        //Set title for window
        window.setTitle("Rock Solid Credit Union");
        window.setResizable(false);
        //Load First Scene
        window.setScene(Scene1.setScene1(window));
        window.show();
    }
}
