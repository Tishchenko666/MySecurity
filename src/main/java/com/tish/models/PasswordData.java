package com.tish.models;

import java.time.LocalDate;

public class PasswordData extends BaseData {
    private String password;

    public PasswordData(RecordType type, LocalDate creationDate, String source, String password) {
        super(type, creationDate, source);
        this.password = password;
    }

    public PasswordData() {
        super();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
