package com.uci.edu.bookbackend.model;

import javax.persistence.*;

@Entity(name = "bookcontent")
@Table(name = "bookcontent")
public class BookContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "bookname")
    private String bookname;

    @Lob
    @Column(name = "content")
    private String content;


    public BookContent() {

    }

    public BookContent(String bookname, String content) {
        super();
        this.bookname = bookname;
        this.content = content;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getBookname() {
        return this.bookname;
    }

    public void setBookname(String bookname) {
        this.bookname=bookname;
    }

    public String getCcontent() {
        return this.content;
    }

    public void setContent (String content) {
        this.content = content;
    }


}
