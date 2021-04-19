package com.doiloppa.selfchk;

public class SongItem {
    private String songName,singer;
    private int resId; // 앨범커버

    public SongItem(String songName, String singer, int resId) {
        this.songName = songName;
        this.singer = singer;
        this.resId = resId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}
