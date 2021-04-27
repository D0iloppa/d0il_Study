package com.doiloppa.recycler_stagger;

public class Item {

    private String title;
    private int resID; // 사진 주소

    public Item(String title, int resID) {
        this.title = title;
        this.resID = resID;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getResID() {
        return resID;
    }

    public void setResID(int resID) {
        this.resID = resID;
    }
}
