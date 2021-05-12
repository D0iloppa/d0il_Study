package SelfTest;

public class Board {
    int idx;
    private String song,artist,album,date;

    public String getDb(){
        return String.format("%s/%s/%s/%s\n",getSong(),getArtist(),getAlbum(),getDate());
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
