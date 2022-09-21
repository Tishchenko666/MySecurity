package com.tish.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
//import java.net.URL;

public class WelcomeController {
    Stage window = new Stage();
    Parent root;
    Scene scene;

    @FXML
    private void guestGenrButtonClicked() throws IOException {
        windowCreate("Генерация пароля");
    }

    @FXML
    private void guestRegistrButtonClicked() throws IOException {
        windowCreate("Регистрация");
    }

    @FXML
    private void guestEnterButtonClicked() throws IOException {
        windowCreate("Вход");
    }

    public void changePage(String buttonName) {
        windowCreate(buttonName);
    }

    private void windowCreate(String buttonName) {

        switch (buttonName) {
            case "Генерация пароля":
                loadPage("src/main/resources/GuestGenerationPage.fxml");
                break;
            case "Регистрация":
                loadPage("src/main/resources/RegistrationPage.fxml");
                break;
            case "Вход":
                loadPage("src/main/resources/EnterPage.fxml");
                break;
            case "Войти в аккаунт":
                loadPage("src/main/resources/UserPage.fxml");
                break;
        }
    }

    private void loadPage(String fileAddress) {
        try {
            root = FXMLLoader.load(new File(fileAddress).toURI().toURL());
            scene = new Scene(root);
            window.setScene(scene);
            window.setTitle("MySecurity");
            window.setResizable(false);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
