package com.tish.controllers;

import com.tish.utils.GenerationUtils;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class PassGenerationController {
    @FXML
    RadioButton generPassRB;
    @FXML
    RadioButton generPinRB;
    @FXML
    TextField genedPassField;

    public PassGenerationController() {
    }

    @FXML
    public void generButtonClicked() {
        genedPassField.setText(generation());
    }

    public String generation() {
        String pass = "";
        if (generPassRB.isSelected()) {
            int number = (int) (Math.random() * 8 + 13);
            pass = GenerationUtils.passGenerator(number);
        } else if (generPinRB.isSelected()) {
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

    private String pinGenerator() {
        return String.valueOf((int) (Math.random() * 1000 + 9000));
    }*/
}
