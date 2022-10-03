package com.tish.controllers;

import com.tish.dbconnectors.DataConnector;
import com.tish.models.TableRecord;
import com.tish.utils.CurrentDataUtils;
import com.tish.utils.StageUtils;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.time.LocalDate;

public class UserController {
    Stage window = new Stage();
    Parent root;
    Scene scene;
    ObservableList<TableRecord> tableList = FXCollections.observableArrayList();

    @FXML
    TextField searchField;
    @FXML
    TableView<TableRecord> enterRecTable;
    @FXML
    TableColumn<TableRecord, String> typeColumn;
    @FXML
    TableColumn<TableRecord, String> sourceColumn;
    @FXML
    TableColumn<TableRecord, LocalDate> dateColumn;

    public UserController() {
    }

    @FXML
    public void tableButtonClicked() throws IOException {
        /*FileReader reader = new FileReader("Records.txt");
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line;
        String recordFile = "";
        while ((line = bufferedReader.readLine()) != null) {
            recordFile = recordFile.concat(line).concat("\n");
        }
        reader.close();
        bufferedReader.close();
        TableRecord tr;
        String[] records = recordFile.split("\n");
        if (tableList.isEmpty()) {
            for (int i = 0; i < records.length; i++) {
                if (!records[i].equals("")) {
                    String[] rcs = records[i].split(" ");
                    tr = new TableRecord(rcs[0], rcs[2]);
                    tableList.add(tr);
                } else
                    continue;
            }
        } else {
            enterRecTable.getItems().removeAll(tableList);
            tableList.removeAll();
            for (int i = 0; i < records.length; i++) {
                if (!records[i].equals("")) {
                    String[] rcs = records[i].split(" ");
                    tr = new TableRecord(rcs[0], rcs[2]);
                    tableList.add(tr);
                } else
                    continue;
            }
        }*/

        if (!tableList.isEmpty()) {
            enterRecTable.getItems().clear();
        }

        tableList.addAll(DataConnector.getUserRecords());

        typeColumn.setCellValueFactory(new PropertyValueFactory<>("dataType"));
        sourceColumn.setCellValueFactory(new PropertyValueFactory<>("dataSource"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("dataCreationDate"));
        dateColumn.setCellFactory(dc -> new TableCell<TableRecord, LocalDate>() {
            @Override
            protected void updateItem(LocalDate item, boolean empty) {
                super.updateItem(item, empty);
                if (empty)
                    setText("No date");
                else
                    setText(item.format(TableRecord.getFormatter()));
            }
        });
        enterRecTable.setItems(tableList);
        enterRecTable.setVisible(true);

        TableView.TableViewSelectionModel<TableRecord> selectionRecord = enterRecTable.getSelectionModel();
        selectionRecord.selectedItemProperty().addListener(new ChangeListener<TableRecord>() {
            @Override
            public void changed(ObservableValue<? extends TableRecord> observable, TableRecord oldValue, TableRecord newValue) {
                /*try {
                    URL url = new File("src/main/resources/RecordPage.fxml").toURI().toURL();
                    root = FXMLLoader.load(url);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                scene = new Scene(root);
                window.setScene(scene);
                window.setTitle("MySecurity");
                window.setResizable(false);
                window.show();*/
                CurrentDataUtils.setCurrentRecord(oldValue);
                StageUtils.openPage("RecordPage.fxml");
            }
        });
    }

    @FXML
    public void createRecButtonClicked() throws IOException {
        /*URL url = new File("src/main/resources/NewRecordPage.fxml").toURI().toURL();
        root = FXMLLoader.load(url);
        scene = new Scene(root);
        window.setScene(scene);
        window.setTitle("MySecurity");
        window.setResizable(false);
        window.show();*/
        StageUtils.openPage("NewRecordPage.fxml");
    }

    @FXML
    public void deleteRecsButtonClicked() throws IOException {
        enterRecTable.getItems().removeAll(tableList);
        FileWriter writer = new FileWriter("Records.txt");
        writer.write("");
        writer.close();
    }

    @FXML
    public void userGenerButtonClicked() {
        StageUtils.openPage("GuestGenerationPage.fxml");
    }

    @FXML
    public void profileButtonClicked() throws IOException {
        URL url = new File("src/main/resources/AccountPage.fxml").toURI().toURL();
        root = FXMLLoader.load(url);
        scene = new Scene(root);
        window.setScene(scene);
        window.setTitle("MySecurity");
        window.setResizable(false);
        window.show();
    }

    @FXML
    public void searchButtonClicked() {
        String sRec = searchField.getText();
        TableRecord tr;
        if (sRec.equals("Password")) {
            for (int i = 0; i < tableList.size(); i++) {
                tr = (TableRecord) tableList.get(i);
                if (!(tr.getDataType().equals(sRec))) {
                    enterRecTable.getItems().remove(tr);
                }
            }
        } else if (sRec.equals("Pin")) {
            for (int i = 0; i < tableList.size(); i++) {
                tr = (TableRecord) tableList.get(i);
                if (!(tr.getDataType().equals(sRec))) {
                    enterRecTable.getItems().remove(tr);
                }
            }
        } else {
            for (int i = 0; i < tableList.size(); i++) {
                tr = (TableRecord) tableList.get(i);
                if (tr.getDataSource().compareTo(sRec) != 0) {
                    enterRecTable.getItems().remove(tr);
                }
            }
        }
    }
}
