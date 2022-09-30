package com.tish.controllers;

import com.tish.dbconnectors.AccountConnector;
import com.tish.models.User;
import com.tish.utils.StageUtils;
import com.tish.utils.CurrentDataUtils;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/*import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;*/

public class EntranceController {
    @FXML
    TextField enterLoginField;
    @FXML
    TextField enterPassField;

    public EntranceController() {
    }

    @FXML
    public void enterAccountButtonClicked() /*throws IOException*/ {
        /*FileReader reader = new FileReader("Accounts.txt");
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
        bufferedReader.close();*/
        User checkUser = new User(enterLoginField.getText(), enterPassField.getText());
        Long id = AccountConnector.checkAccount(checkUser);
        if (id > 0) {
            StageUtils.changePage("UserPage.fxml");
            StageUtils.getTempStage().close();
            checkUser.setId(id);
            CurrentDataUtils.setCurrentUser(checkUser);
        }
        // todo: add error comment to entrance page in if-else
    }
}
