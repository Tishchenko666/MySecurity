package com.tish.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RegistrationController {
  @FXML
  TextField loginField;
  @FXML
  TextField passField;


  public RegistrationController() {
  }

  @FXML
  public void registrationButtonClicked() throws IOException {
    FileWriter writer = new FileWriter("Accounts.txt", true);
    String accountData = loginField.getText().concat(" ").concat(passField.getText());
    writer.write(accountData);
    writer.close();
  }

}
