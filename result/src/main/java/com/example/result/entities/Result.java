package com.example.result.entities;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.validation.constraints.Max;

/**
 * Result.
 */

@Entity
public class Result {

    /**
     * Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "result_id")
    private int resultId;

    /**
     * User Name.
     */
    @Length(max = 45)
    @Column(name = "name")
    private String name;

    /**
     * Percentage correct.
     */
    @Max(100)
    @Column(name = "percentage")
    private int percentage;

    /**
     * Quiz id.
     */
    @Column(name = "quiz_id")
    private int quizId;

    /**
     * Get result id.
     * @return id.
     */
    public int getResultId() {
        return resultId;
    }

    /**
     * Set result id.
     * @param newResultId to set.
     */
    public void setResultId(final int newResultId) {
        this.resultId = newResultId;
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
     * Get percentage.
     * @return percentage.
     */
    public int getPercentage() {
        return percentage;
    }

    /**
     * Set percentage.
     * @param newPercentage to set.
     */
    public void setPercentage(final int newPercentage) {
        this.percentage = newPercentage;
    }

    /**
     * Get quiz id.
     * @return quiz id.
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
}
