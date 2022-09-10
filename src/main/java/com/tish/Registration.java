package com.tish;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Registration {
  @FXML
  TextField loginField;
  @FXML
  TextField passField;

  @FXML
  TextField enterLoginField;
  @FXML
  TextField enterPassField;



  public Registration() {
  }

  @FXML
  public void registrationButtonClicked() throws IOException {
    FileWriter writer = new FileWriter("Accounts.txt", true);
    String accountData = loginField.getText().concat(" ").concat(passField.getText());
    writer.write(accountData);
    writer.close();
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
        Welcome nextStep = new Welcome();
        nextStep.WindowCreate("Войти в аккаунт");
        break;
      }
    }
    reader.close();
    bufferedReader.close();
  }
}
