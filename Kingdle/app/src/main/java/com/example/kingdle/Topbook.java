package com.example.kingdle;

import com.google.gson.annotations.SerializedName;

public class Topbook {
    //	• Cover image
    //	• ISBN
    //	• Author
    //	• Pages
    //	• Ratings
    //Simple description
    @SerializedName("title")
    private String title;
    @SerializedName("authors")
    private String author;
    @SerializedName("averageRating")
    private Float rating;
    @SerializedName("description")
    private String description;
    @SerializedName("publisher")
    private String isbn;
    @SerializedName("imageLinks")
    private String img_path;
    
    public Topbook(String _title,
                   String _author,
                   Float _rating,
                   String _description,
                   String _isbn,
                   String _img_path) {
        this.title = _title;
        this.author = _author;
        this.rating = _rating;
        this.description = _description;
        this.isbn = _isbn;
        this.img_path = _img_path;
    }
    public String get_title () {
        return title;
    }
    public String get_author () { return author; }
    public Float get_rating () {
        return rating;
    }
    public String get_description () {
        return description;
    }
    public String get_isbn () {
        return isbn;
    }
    public String get_img_path () {
        return img_path;
    }


}
