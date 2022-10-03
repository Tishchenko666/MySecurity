package com.tish.models;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TableRecord {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    //private Long recordId;
    SimpleStringProperty dataType;
    SimpleStringProperty dataSource;
    SimpleObjectProperty<LocalDate> dataCreationDate;


    public TableRecord(String dt, String ds) {
        this.dataType = new SimpleStringProperty(dt);
        this.dataSource = new SimpleStringProperty(ds);
    }

    public TableRecord(/*Long recordId,*/RecordType dt, String ds, LocalDate dcd) {
        //this.recordId = recordId;
        this.dataType = new SimpleStringProperty(dt.getValue());
        this.dataSource = new SimpleStringProperty(ds);
        this.dataCreationDate = new SimpleObjectProperty<>(dcd);
    }

    /*public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }*/

    public String getDataType() {
        return dataType.get();
    }

    public String getDataSource() {
        return dataSource.get();
    }

    public void setDataType(String dataType) {
        this.dataType.set(dataType);
    }

    public void setDataSource(String dataSource) {
        this.dataSource.set(dataSource);
    }

    public LocalDate getDataCreationDate() {
        return dataCreationDate.get();
    }

    public void setDataCreationDate(LocalDate dataCreationDate) {
        this.dataCreationDate.set(dataCreationDate);
    }

    public static DateTimeFormatter getFormatter() {
        return formatter;
    }
}
