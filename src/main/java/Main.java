import javafx.application.Application;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Parent root = null;
        var loc = getClass().getResource("Main.fxml");
        try {
            root = FXMLLoader.load(loc);
        } catch (IOException e) {
            System.out.println("FXML file not found");
        }

        Scene windowContents = new Scene(root, 300, 400);

        primaryStage.setScene(windowContents);

        primaryStage.setTitle("Project 5");

        primaryStage.show();
    }

    @FXML
    public void exit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    public void openSongWindow(ActionEvent event) {
        Parent songRoot = null;
        var loc = getClass().getResources("SongWindow.fxml");
        try {
            songRoot = FXMLLoader.load(loc);
        }catch (IOException e){
            System.out.println("FXML file not found");

        }
    }
}