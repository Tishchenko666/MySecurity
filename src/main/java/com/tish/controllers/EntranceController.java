package com.tish.controllers;

import com.tish.utils.StageUtils;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EntranceController {
    @FXML
    TextField enterLoginField;
    @FXML
    TextField enterPassField;

    public EntranceController() {
    }

    @FXML
    public void enterAccountButtonClicked() throws IOException {
        FileReader reader = new FileReader("Accounts.txt");
        BufferedReader bufferedReader = new BufferedReader(reader);
        String accountData = enterLoginField.getText().concat(" ").concat(enterPassField.getText());
        String accountFile = "";
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            accountFile = line;
            if (accountData.equals(accountFile)) {
                //WelcomeController nextStep = new WelcomeController();
                //nextStep.changePage("Войти в аккаунт");
                StageUtils.changePage("UserPage.fxml");
                StageUtils.getTempStage().close();
                break;
            }
        }
        reader.close();
        bufferedReader.close();
    }
}
