package com.tish.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "passwords", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class PasswordData extends BaseEntity {

    @Column(name = "password", nullable = false)
    private String password;

    @OneToOne
    private BaseData data;

    public PasswordData(RecordType type, LocalDate creationDate, String source, String password) {
        this.password = password;
        data = new BaseData(type, creationDate, source);
    }

    public PasswordData() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BaseData getData() {
        return data;
    }

    public void setData(BaseData data) {
        this.data = data;
    }
}
