package com.tish.models;

import java.time.LocalDate;

public class BaseData {
    private RecordType type;
    private LocalDate creationDate;
    private String source;

    public BaseData(RecordType type, LocalDate creationDate, String source) {
        this.type = type;
        this.creationDate = creationDate;
        this.source = source;
    }

    public BaseData() {
    }

    public RecordType getType() {
        return type;
    }

    public void setType(RecordType type) {
        this.type = type;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
