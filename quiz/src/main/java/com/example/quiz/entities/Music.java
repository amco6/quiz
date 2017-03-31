package com.example.quiz.entities;

/**
 * Music.
 */
public class Music {

    /**
     * Artist name.
     */
    private String artistName;

    /**
     * Track id.
     */
    private int trackId;

    /**
     * Track name.
     */
    private String trackName;

    /**
     * Album name.
     */
    private String albumName;

    /**
     * Year.
     */
    private int year;

    /**
     * Genre.
     */
    private String genre;

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
