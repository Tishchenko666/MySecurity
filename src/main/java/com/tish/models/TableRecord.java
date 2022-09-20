package com.tish.models;

import javafx.beans.property.SimpleStringProperty;

public class TableRecord {
    SimpleStringProperty dataType;
    SimpleStringProperty dataSource;
    SimpleStringProperty dataCreationDate;


    public TableRecord(String dt, String ds) {
        this.dataType = new SimpleStringProperty(dt);
        this.dataSource = new SimpleStringProperty(ds);
    }

    public TableRecord(String dt, String ds, String dcd) {
        this.dataType = new SimpleStringProperty(dt);
        this.dataSource = new SimpleStringProperty(ds);
        this.dataCreationDate = new SimpleStringProperty(dcd);
    }

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

    public String getDataCreationDate() {
        return dataCreationDate.get();
    }

    public void setDataCreationDate(String dataCreationDate) {
        this.dataCreationDate.set(dataCreationDate);
    }
}
