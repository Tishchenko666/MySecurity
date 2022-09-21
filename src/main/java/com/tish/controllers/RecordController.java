package com.tish;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.*;

public class Record {

  @FXML
  TextField sourсeField;
  @FXML
  TextField passField;

  String recordFile = "";
  String[] records;
  String tRec = "Pin 9134 аро";
  String tRec2 = "Pin 9134 ароn";

  public Record() {
  }

  @FXML
  public void changeRecButtonClicked() throws IOException {
    readRecord();
    String[] sdt = tRec.split(" ");
    String newRec = sdt[0].concat(" ").concat(passField.getText()).concat(" ").concat(sourсeField.getText());
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
    writer.close();
  }

  @FXML
  public void deleteRecButtonClicked() throws IOException {
    readRecord();
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
    writer.close();
  }

  @FXML
  public void viewRecButtonClicked() throws IOException {
    readRecord();
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
    }
  }

  private void readRecord() throws IOException {
    FileReader reader = new FileReader("Records.txt");
    BufferedReader bufferedReader = new BufferedReader(reader);
    String line;
    while ((line = bufferedReader.readLine()) != null) {
      recordFile = recordFile.concat(line).concat("\n");
    }
    reader.close();
    bufferedReader.close();
    records = recordFile.split("\n");
  }


}
