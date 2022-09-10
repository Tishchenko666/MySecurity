package com.tish;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        URL url = new File("src/main/resources/WelcomePage.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        primaryStage.setTitle("MySecurity");
        primaryStage.setResizable(false);

        primaryStage.show();
    }

    @FXML
    public void guestGenrButtonClicked() throws IOException {
        Welcome nextStep = new Welcome();
        nextStep.WindowCreate("Генерация пароля");
    }

    public void guestRegistrButtonClicked() throws IOException {
        Welcome nextStep = new Welcome();
        nextStep.WindowCreate("Регистрация");
    }

    public void guestEnterButtonClicked() throws IOException {
        Welcome nextStep = new Welcome();
        nextStep.WindowCreate("Вход");
    }


}
