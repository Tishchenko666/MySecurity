package com.tish.models;

public enum RecordType {
    PASSWORD("password"), PIN("pin");

    private final String value;

    RecordType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
