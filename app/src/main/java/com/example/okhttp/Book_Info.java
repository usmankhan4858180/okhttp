package com.example.okhttp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Created by DEll1 on 1/12/2018.
 */

public class Book_Info {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("book_name")
    @Expose
    private String bookName;
    @SerializedName("author_name")
    @Expose
    private String authorName;
    @SerializedName("edition")
    @Expose
    private Integer edition;
    @SerializedName("course_name")
    @Expose
    private String courseName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Integer getEdition() {
        return edition;
    }

    public void setEdition(Integer edition) {
        this.edition = edition;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

}