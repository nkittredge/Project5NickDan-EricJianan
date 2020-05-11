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
        Parent phoneRoot = null;
        var loc = getClass().getResource("PhonWindow.fxml");
        try {
            phoneRoot = FXMLLoader.load(loc);
        }catch (IOException e){
            System.out.println("FXML file not found");
            System.out.println(e);
            System.exit(-1);
        }
        Scene windowContents = new Scene(phoneRoot, 430,150);
        Stage PhoneWindow = new Stage();
        PhoneWindow.setScene(windowContents);
        PhoneWindow.setTitle("International Phone Number");
        PhoneWindow.show();
    }
}

