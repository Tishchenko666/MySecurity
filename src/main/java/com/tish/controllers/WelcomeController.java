package com.tish.controllers;

import com.tish.utils.StageUtils;
import javafx.fxml.FXML;

import java.io.IOException;
//import java.net.URL;

public class WelcomeController {

    //private final String PAGE_SOURCE = "src/main/resources/";

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
                openWindow("GuestGenerationPage.fxml");
                break;
            case "Регистрация":
                openWindow("RegistrationPage.fxml");
                break;
            case "Вход":
                openWindow("EntrancePage.fxml");
                break;
            case "Войти в аккаунт":
                loadPage();
                break;
        }
    }

    private void loadPage() {
        StageUtils.changePage("UserPage.fxml");
    }

    private void openWindow(String fileName) {
        StageUtils.openPage(fileName);
    }
}
