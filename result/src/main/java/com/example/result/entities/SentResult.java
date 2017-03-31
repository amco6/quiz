package com.example.result.entities;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * Result sent.
 */
public class SentResult {

    /**
     * Quiz.
     */
    @NotNull
    private int quizId;

    /**
     * User name.
     */
    @NotNull
    @Length(max = 45)
    private String name;

    /**
     * Score.
     */
    @NotNull
    private int score;

    /**
     * Get quiz id.
     * @return id.
     */
    public int getQuizId() {
        return quizId;
    }

    /**
     * Set quiz id.
     * @param newQuizId to set.
     */
    public void setQuizId(final int newQuizId) {
        this.quizId = newQuizId;
    }

    /**
     * Get name.
     * @return name.
     */
    public String getName() {
        return name;
    }

    /**
     * Set name.
     * @param newName to set.
     */
    public void setName(final String newName) {
        this.name = newName;
    }

    /**
     * Get score.
     * @return score.
     */
    public int getScore() {
        return score;
    }

    /**
     * Set score.
     * @param newScore to set.
     */
    public void setScore(final int newScore) {
        this.score = newScore;
    }
}
