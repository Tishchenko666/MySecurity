package com.tish.controllers;

import com.tish.dbconnectors.DataConnector;
import com.tish.models.BaseData;
import com.tish.models.PasswordData;
import com.tish.models.PinData;
import com.tish.models.RecordType;
import com.tish.utils.CurrentDataUtils;
import com.tish.utils.GenerationUtils;
import com.tish.utils.StageUtils;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class RecordCreationController {

    @FXML
    TextField newSourсeField;
    @FXML
    RadioButton newPassRB;
    @FXML
    RadioButton newPinRB;
    @FXML
    TextField newPassField;

    @FXML
    ToggleGroup dataType;

    public RecordCreationController() {
    }

    @FXML
    public void newGenerButtonClicked() {
        newPassField.setText(generation());
    }

    @FXML
    public void newSaveButtonClicked() throws IOException {
        /*FileWriter writer = new FileWriter("Records.txt", true);
        newRecord = "";
        if (newPassRB.isSelected())
            newRecord = newRecord.concat("Password ");
        else
            newRecord = newRecord.concat("Pin ");

        newRecord = newRecord.concat(newPassField.getText()).concat(" ").concat(newSourсeField.getText()).concat("\n");
        writer.write(newRecord);
        writer.close();*/
        BaseData recordBaseData = new BaseData();
        // todo: add MyException if nothing is chosen
        recordBaseData.setType(newPassRB.isSelected() ? RecordType.PASSWORD : RecordType.PIN);
        recordBaseData.setSource(newSourсeField.getText());
        recordBaseData.setCreationDate(LocalDate.now());
        recordBaseData.setUser(CurrentDataUtils.getCurrentUser());

        if (newPassRB.isSelected()) {
            PasswordData passwordData = new PasswordData();
            passwordData.setPassword(newPassField.getText());
            passwordData.setData(recordBaseData);
            DataConnector.savePassword(passwordData);
        } else if (newPinRB.isSelected()) {
            PinData pinData = new PinData();
            pinData.setPin(Integer.valueOf(newPassField.getText()));
            pinData.setData(recordBaseData);
            DataConnector.savePin(pinData);
        }

        StageUtils.getTempStage().close();
    }

    private String generation() {
        String pass = "";
        if (newPassRB.isSelected()) {
            int number = (int) (Math.random() * 8 + 13);
            pass = GenerationUtils.passGenerator(number);
        } else if (newPinRB.isSelected()) {
            pass = GenerationUtils.pinGenerator();
        }
        return pass;
    }

  /*private String passGenerator(int length) {
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
  }*/
}
