package com.tish.models;

import javafx.beans.property.SimpleStringProperty;

public class TableRecord {
    private Long recordId;
    SimpleStringProperty dataType;
    SimpleStringProperty dataSource;
    SimpleStringProperty dataCreationDate;


    public TableRecord(String dt, String ds) {
        this.dataType = new SimpleStringProperty(dt);
        this.dataSource = new SimpleStringProperty(ds);
    }

    public TableRecord(Long recordId, String dt, String ds, String dcd) {
        this.recordId = recordId;
        this.dataType = new SimpleStringProperty(dt);
        this.dataSource = new SimpleStringProperty(ds);
        this.dataCreationDate = new SimpleStringProperty(dcd);
    }

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
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
