package com.example.quiz.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Film.
 */
public class Film {

    /**
     * Title.
     */
    @JsonProperty("Title")
    private String title;

    /**
     * Director.
     */
    @JsonProperty("Director")
    private String director;

    /**
     * Release date.
     */
    @JsonProperty("Released")
    private String released;

    /**
     * Runtime.
     */
    @JsonProperty("Runtime")
    private String runtime;

    /**
     * Genre.
     */
    @JsonProperty("Genre")
    private String genre;

    /**
     * Writer.
     */
    @JsonProperty("Writer")
    private String writer;

    /**
     * Actors.
     */
    @JsonProperty("Actors")
    private String actors;

    /**
     * imdb id.
     */
    @JsonProperty("imdbID")
    private String imdbID;

    /**
     * imdb rating.
     */
    @JsonProperty("imdbRating")
    private String imdbRating;

    /**
     * Get Title.
     * @return title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set title.
     * @param newTitle to set.
     */
    public void setTitle(final String newTitle) {
        this.title = newTitle;
    }

    /**
     * Get director.
     * @return director.
     */
    public String getDirector() {
        return director;
    }

    /**
     * Set director.
     * @param newDirector to set.
     */
    public void setDirector(final String newDirector) {
        this.director = newDirector;
    }

    /**
     * Get release date.
     * @return released.
     */
    public String getReleased() {
        return released;
    }

    /**
     * Set release date.
     * @param newReleased to set.
     */
    public void setReleased(final String newReleased) {
        this.released = newReleased;
    }

    /**
     * Get runtime.
     * @return runtime.
     */
    public String getRuntime() {
        return runtime;
    }

    /**
     * Set runtime.
     * @param newRuntime to set.
     */
    public void setRuntime(final String newRuntime) {
        this.runtime = newRuntime;
    }

    /**
     * Get genre.
     * @return genre.
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Set genre.
     * @param newGenre to set.
     */
    public void setGenre(final String newGenre) {
        this.genre = newGenre;
    }

    /**
     * Get imdb rating.
     * @return rating.
     */
    public String getImdbRating() {
        return imdbRating;
    }

    /**
     * Set imdb rating.
     * @param newImdbRating to set.
     */
    public void setImdbRating(final String newImdbRating) {
        this.imdbRating = newImdbRating;
    }
}
