package com.tish;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.io.FileWriter;
import java.io.IOException;

public class RecordCreater {

  @FXML
  TextField newSourсeField;
  @FXML
  RadioButton newPassRB;
  @FXML
  RadioButton newPinRB;
  @FXML
  TextField newPassField;

  String newRecord;

  public RecordCreater() {
  }

  @FXML
  public void newGenerButtonClicked() {
    newPassField.setText(generation());
  }

  @FXML
  public void newSaveButtonClicked() throws IOException {
    FileWriter writer = new FileWriter("Records.txt", true);
    newRecord = "";
    if (newPassRB.isSelected())
      newRecord = newRecord.concat("Password ");
    else
      newRecord = newRecord.concat("Pin ");

    newRecord = newRecord.concat(newPassField.getText()).concat(" ").concat(newSourсeField.getText()).concat("\n");
    writer.write(newRecord);
    writer.close();
  }

  public String generation() {
    String pass = "";
    if (newPassRB.isSelected()) {
      int number = (int) (Math.random() * 8 + 13);
      pass = passGenerator(number);
    } else if (newPinRB.isSelected()) {
      pass = String.valueOf(pinGenerator());
    }
    return pass;
  }

  private String passGenerator(int length) {
    String pass = "";
    char c;
    for (int i = 0; i < length; i++) {
      c = (char) ((int) (Math.random() * 33 + 94));
      pass = pass.concat(String.valueOf(c));
    }
    return pass;
  }

  private int pinGenerator() {
    return (int) (Math.random() * 1000 + 9000);
  }
}
