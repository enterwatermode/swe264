package com.example.kingdle;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "Topbook_table")
public class TopbookTable {

    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "title")
    public String title;
    @ColumnInfo(name = "author")
    public String author;
    @ColumnInfo(name = "rating")
    public Float rating;
    @ColumnInfo(name = "description")
    public String description;
    @ColumnInfo(name = "isbn")
    public String isbn;
    @ColumnInfo(name = "img_path")
    public String img_path;

    public TopbookTable () {

    }

    public TopbookTable (Topbook book) {
        this.title = book.get_title();
        this.author = book.get_author();
        this.rating = book.get_rating();
        this.description = book.get_description();
        this.isbn = book.get_isbn();
        this.img_path = book.get_img_path();
    }

}

