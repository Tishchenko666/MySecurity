package com.tish.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pins", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class PinData extends BaseEntity {

    @Column(name = "pin", nullable = false)
    private Integer pin;

    @OneToOne
    private BaseData data;

    public PinData(RecordType type, LocalDate creationDate, String source, Integer pin) {
        this.pin = pin;
        data = new BaseData(type, creationDate, source);
    }

    public PinData() {
    }

    public Integer getPin() {
        return pin;
    }

    public void setPin(Integer pin) {
        this.pin = pin;
    }

    public BaseData getData() {
        return data;
    }

    public void setData(BaseData data) {
        this.data = data;
    }
}
