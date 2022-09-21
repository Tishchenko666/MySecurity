package com.tish;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class WelcomeController {
  Stage window = new Stage();
  Parent root;
  Scene scene;
  public WelcomeController() {
  }

  void WindowCreate(String buttonName) throws IOException {
    URL url;
    switch (buttonName) {
      case "Генерация пароля":
        url = new File("src/main/resources/GuestGenerationPage.fxml").toURI().toURL();
        root = FXMLLoader.load(url);
        scene = new Scene(root);
        window.setScene(scene);
        window.setTitle("MySecurity");
        window.setResizable(false);
        window.show();
        break;
      case "Регистрация":
        url = new File("src/main/resources/RegistrationPage.fxml").toURI().toURL();
        root = FXMLLoader.load(url);
        scene = new Scene(root);
        window.setScene(scene);
        window.setTitle("MySecurity");
        window.setResizable(false);
        window.show();
        break;
      case "Вход":
        url = new File("src/main/resources/EnterPage.fxml").toURI().toURL();
        root = FXMLLoader.load(url);
        scene = new Scene(root);
        window.setScene(scene);
        window.setTitle("MySecurity");
        window.setResizable(false);
        window.show();
        break;
      case "Войти в аккаунт":
        url = new File("src/main/resources/UserPage.fxml").toURI().toURL();
        root = FXMLLoader.load(url);
        scene = new Scene(root);
        window.setScene(scene);
        window.setTitle("MySecurity");
        window.setResizable(false);
        window.show();
        break;
    }
  }


}
