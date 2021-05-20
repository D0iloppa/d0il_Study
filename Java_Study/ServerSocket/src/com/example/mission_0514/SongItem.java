package com.example.mission_0514;

import java.io.Serializable;

public class SongItem implements Serializable{

    String title;
    String singer;
    int imageResource;


    public SongItem(String title, String singer,int imageResource) {
        this.title = title;
        this.singer = singer;
        this.imageResource = imageResource;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

}
