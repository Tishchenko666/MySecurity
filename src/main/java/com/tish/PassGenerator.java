package com.tish;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class PassGenerator {
  @FXML
  RadioButton generPassRB;
  @FXML
  RadioButton generPinRB;
  @FXML
  TextField genedPassField;

  public PassGenerator() {
  }

  @FXML
  public void generButtonClicked() {
    genedPassField.setText(generation());
  }

  public String generation() {
    String pass = "";
    if (generPassRB.isSelected()) {
      int number = (int) (Math.random() * 8 + 13);
      pass = passGenerator(number);
    } else if (generPinRB.isSelected()) {
      pass = String.valueOf(pinGenerator());
    }
    return pass;
  }

  private String passGenerator(int length) {
    String pass = "";
    char c;
    for (int i = 0; i < length; i++) {
      c =(char) ((int) (Math.random() * 33 + 94));
      pass = pass.concat(String.valueOf(c));
    }
    return pass;
  }

  private int pinGenerator() {
    return (int) (Math.random() * 1000 + 9000);
  }
}
