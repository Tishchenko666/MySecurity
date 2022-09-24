package com.tish;

//import com.tish.controllers.WelcomeController;
import com.tish.utils.StageUtils;
import javafx.application.Application;
//import javafx.fxml.FXML;
import javafx.stage.Stage;

//import java.io.IOException;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        /*URL url = new File("src/main/resources/WelcomePage.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);*/

        primaryStage = StageUtils.getInstance(primaryStage);
        StageUtils.changePage("pages/WelcomePage.fxml");
        primaryStage.setTitle("MySecurity");
        primaryStage.setResizable(false);

        primaryStage.show();
    }
}
