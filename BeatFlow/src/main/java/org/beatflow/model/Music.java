package org.beatflow.model;

public class Music {
    private String title;
    private String artist;
    private String filePath;
    private int duration;

    public Music() {}

    public Music(String title, String artist, String filePath, int duration) {
        this.title = title;
        this.artist = artist;
        this.filePath = filePath;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
