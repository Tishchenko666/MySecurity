package com.tish.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "records")
public class BaseData extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "data_type", nullable = false)
    private RecordType type;

    @Column(name = "creation_date")
    private LocalDate creationDate;

    @Column(name = "source")
    private String source;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
