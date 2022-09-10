package com.tish;

import javafx.beans.property.SimpleStringProperty;

public class TableRecord {
  SimpleStringProperty dataType;
  SimpleStringProperty dataSource;


  public TableRecord(String dt, String ds) {
    this.dataType = new SimpleStringProperty(dt);
    this.dataSource = new SimpleStringProperty(ds);
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
}
