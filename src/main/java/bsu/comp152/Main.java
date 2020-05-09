package bsu.comp152;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
        }catch (IOException e){
            System.out.println("FXML file not found");
        }
        Scene windowContents = new Scene(root, 300,400);
        primaryStage.setScene(windowContents);
        primaryStage.setTitle("Project 5");
        primaryStage.show();
    }

    @FXML
    public void exit(ActionEvent event){
        System.exit(0);
    }

    @FXML
    public void openPhonWindow(ActionEvent event){
        Parent root = null;
        var loc = getClass().getResource("PhonWindow.fxml");
        try {
            root = FXMLLoader.load(loc);
        }catch (IOException e){
            System.out.println("FXML file not found");
        }
        //here is where we are creating the new window
        Scene windowContents = new Scene(root, 900,400);
        Stage recipeWindow = new Stage();
        recipeWindow.setScene(windowContents);
        recipeWindow.setTitle("Recipe Finder Demo");
        recipeWindow.show();
    }
}

