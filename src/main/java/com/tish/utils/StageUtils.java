package com.tish.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class StageUtils {

    private static final String PAGE_SOURCE = "src/main/resources/pages/";

    private static Stage mainStage;
    private static Stage tempStage;

    public static Stage getInstance(Stage stage) {
        if (mainStage == null) {
            mainStage = stage;
        }
        return mainStage;
    }

    public static Stage getInstance() {
        if (mainStage == null) {
            mainStage = new Stage();
        }
        return mainStage;
    }

    public static void changePage(String pageName) {
        try {
            Parent root = FXMLLoader.load(new File(PAGE_SOURCE + pageName).toURI().toURL());
            if (mainStage.getScene() != null)
                mainStage.getScene().setRoot(root);
            else
                mainStage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void openPage(String fileName) {
        Stage window = new Stage();
        try {
            Parent root = FXMLLoader.load(new File(PAGE_SOURCE + fileName).toURI().toURL());
            window.setScene(new Scene(root));
            window.setTitle("MySecurity");
            window.setResizable(false);
            window.show();
            tempStage = window;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Stage getTempStage(){
        return tempStage;
    }
}
