package com.tish.models;

import java.time.LocalDate;

public class PinData extends BaseData {
    private Integer pin;

    public PinData(RecordType type, LocalDate creationDate, String source, Integer pin) {
        super(type, creationDate, source);
        this.pin = pin;
    }

    public PinData() {
        super();
    }

    public Integer getPin() {
        return pin;
    }

    public void setPin(Integer pin) {
        this.pin = pin;
    }
}
