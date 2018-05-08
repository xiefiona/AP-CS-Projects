import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("GUI.fxml"));
        primaryStage.setTitle("Recursion Project");
        primaryStage.setScene(new Scene(root));
        primaryStage.getIcons().add(new Image("file:src/Assets/icon.png"));
        primaryStage.setResizable(false);
        /*
        Removes maximize button but forces FX scene to front, thus creating
        issues on TreePanel creation. Find a fix to this at some point.
        */
        //primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.sizeToScene();
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}
