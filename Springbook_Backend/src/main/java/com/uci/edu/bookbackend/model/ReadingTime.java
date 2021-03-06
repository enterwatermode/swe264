package com.uci.edu.bookbackend.model;

import javax.persistence.*;

@Entity(name = "readingtime")
@Table(name = "readingtime")
public class ReadingTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "time")
    private String time;

    public ReadingTime() {

    }

    public ReadingTime(String time) {
        super();
        this.time = time;
    }


    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return this.time;
    }
}
