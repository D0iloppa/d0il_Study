package com.doiloppa.recyclerview_ex;

public class Recycler_Model { // 리사이클러 뷰에 들어갈 아이템

    String title,author;

    public Recycler_Model(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
