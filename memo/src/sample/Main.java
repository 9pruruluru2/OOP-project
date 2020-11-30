package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;

public class Main extends Application {
    public void start(Stage primaryStage) throws FileNotFoundException {
        int i = 0;
        AutoSavePane textPane = new TextPane(i);

        Scene scene = new Scene(textPane.getPane(), 600, 300);
        primaryStage.setTitle("text_"+i+".txt");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}