package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {//ham main ke thua tu Applicaition
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Dictionary");//tieu de Dictionary
        primaryStage.setScene(new Scene(root, 741, 644));//giao dien noai cua tu dien kich thuoc 741x644
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}

