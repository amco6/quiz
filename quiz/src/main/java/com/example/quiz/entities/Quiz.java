package com.example.quiz.entities;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.OneToMany;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Quiz Object.
 */
@Entity
public class Quiz {

    /**
     * Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "quiz_id")
    private int quizId;

    /**
     * Quiz Name.
     */
    @NotNull
    @Length(max = 100)
    @Column(name = "quiz_name")
    private String quizName;

    /**
     * Questions.
     */
    @OneToMany(mappedBy = "quizId")
    private List<Question> questions;

    /**
     * Get quizId.
     * @return quizId.
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
     * Get Quiz Name.
     * @return name.
     */
    public String getQuizName() {
        return quizName;
    }

    /**
     * Set quiz name.
     * @param newQuizName to set.
     */
    public void setQuizName(final String newQuizName) {
        this.quizName = newQuizName;
    }

    /**
     * Get questions.
     * @return questions.
     */
    public List<Question> getQuestions() {
        return questions;
    }

    /**
     *  Set questions.
     * @param newQuestions to set.
     */
    public void setQuestions(final List<Question> newQuestions) {
        this.questions = newQuestions;
    }
}
