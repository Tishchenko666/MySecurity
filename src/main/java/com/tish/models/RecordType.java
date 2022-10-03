package com.tish.models;

public enum RecordType {
    PASSWORD("Password"), PIN("Pin");

    private final String value;

    RecordType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
