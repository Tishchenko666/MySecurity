package com.tish.controllers;

import com.tish.dbconnectors.DataConnector;
import com.tish.models.*;
import com.tish.utils.CurrentDataUtils;
import com.tish.utils.StageUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

//import java.io.*;
import java.time.LocalDate;

public class RecordController {

    @FXML
    TextField sourceField;
    @FXML
    TextField passField;
    @FXML
    TextField dateField;
    @FXML
    Label passLabel;

    PasswordData passwordData;
    PinData pinData;
    boolean pass;

    /*String recordFile = "";
    String[] records;
    String tRec = "Pin 9134 аро";
    String tRec2 = "Pin 9134 ароn";*/

    public RecordController() {
        TableRecord tableRecord = CurrentDataUtils.getCurrentRecord();
        BaseData data = new BaseData(RecordType.valueOf(tableRecord.getDataType()), tableRecord.getDataCreationDate(), tableRecord.getDataSource());
        passLabel.setText(data.getType().getValue());
        if (data.getType().equals(RecordType.PASSWORD)) {
            passwordData = DataConnector.getPasswordData(data);
            pass = true;
        } else {
            pinData = DataConnector.getPinData(data);
            pass = false;
        }
    }

    @FXML
    public void changeRecButtonClicked() {
        /*readRecord();
        String[] sdt = tRec.split(" ");
        String newRec = sdt[0].concat(" ").concat(passField.getText()).concat(" ").concat(sourceField.getText());
        for (int i = 0; i < records.length; i++) {
            if (tRec.equals(records[i])) {
                records[i] = newRec;
                break;
            }
        }
        FileWriter writer = new FileWriter("Records.txt");
        for (int i = 0; i < records.length; i++) {
            writer.write(records[i].concat("\n"));
        }
        writer.close();*/
        if (pass) {
            passwordData.getData().setSource(sourceField.getText());
            passwordData.getData().setCreationDate(LocalDate.parse(dateField.getText(), TableRecord.getFormatter()));
            passwordData.setPassword(passField.getText());
            DataConnector.savePassword(passwordData);
        } else {
            pinData.getData().setSource(sourceField.getText());
            pinData.getData().setCreationDate(LocalDate.parse(dateField.getText(), TableRecord.getFormatter()));
            pinData.setPin(Integer.valueOf(passField.getText()));
            DataConnector.savePin(pinData);
        }
        StageUtils.getTempStage().close();
    }

    @FXML
    public void deleteRecButtonClicked() {
        /*readRecord();
        for (int i = 0; i < records.length; i++) {
            if (tRec.equals(records[i])) {
                records[i] = "";
                break;
            }
        }
        FileWriter writer = new FileWriter("Records.txt");
        for (int i = 0; i < records.length; i++) {
            if (!records[i].equals(""))
                writer.write(records[i].concat("\n"));
            else
                continue;
        }
        writer.close();*/
        boolean deleted = pass ? DataConnector.deletePassword(passwordData) : DataConnector.deletePin(pinData);
        if (deleted)
            StageUtils.getTempStage().close();
    }

    @FXML
    public void viewRecButtonClicked() {
        /*readRecord();
        boolean find = false;
        for (int i = 0; i < records.length; i++) {
            if (tRec.equals(records[i])) {
                String[] sd = tRec.split(" ");
                sourсeField.setText(sd[2]);
                passField.setText(sd[1]);
                find = true;
            }
        }
        if (!find) {
            String[] sd = tRec2.split(" ");
            sourсeField.setText(sd[2]);
            passField.setText(sd[1]);
        }*/
        sourceField.setText(pass ? passwordData.getData().getSource() : pinData.getData().getSource());
        passField.setText(pass ? passwordData.getPassword() : pinData.getPin().toString());
        dateField.setText(pass ? passwordData.getData().getCreationDate().toString() : pinData.getData().getCreationDate().toString());
    }

    /*private void readRecord() throws IOException {
        FileReader reader = new FileReader("Records.txt");
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            recordFile = recordFile.concat(line).concat("\n");
        }
        reader.close();
        bufferedReader.close();
        records = recordFile.split("\n");
    }*/


}
