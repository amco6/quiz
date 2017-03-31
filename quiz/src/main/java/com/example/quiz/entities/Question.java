package com.example.quiz.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;

/**
 * Quiz questions and answers.
 */
@Entity
public class Question {

    /**
     * Question id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "question_id")
    private int questionId;

    /**
     * Question.
     */
    @NotNull
    @Length(max = 100)
    @Column(name = "question")
    private String question;

    /**
     * Answer Option A.
     */
    @NotNull
    @Length(max = 45)
    @Column(name = "answer_a")
    private String answerA;

    /**
     * Answer Option B.
     */
    @NotNull
    @Length(max = 45)
    @Column(name = "answer_b")
    private String answerB;

    /**
     * Answer Option C.
     */
    @NotNull
    @Length(max = 45)
    @Column(name = "answer_c")
    private String answerC;

    /**
     * Answer Option D.
     */
    @NotNull
    @Length(max = 45)
    @Column(name = "answer_d")
    private String answerD;

    /**
     * Correct answer letter.
     */
    @NotNull
    @Length(max = 1)
    @Column(name = "correct_answer")
    @JsonIgnore
    private String correctAnswer;

    /**
     * Quiz Id.
     */
    @Column(name = "quiz_id")
    private int quizId;


    /**
     * Get question id.
     * @return question id.
     */
    public int getQuestionId() {
        return questionId;
    }

    /**
     * Set question id.
     * @param newQuestionId to set.
     */
    public void setQuestionId(final int newQuestionId) {
        this.questionId = newQuestionId;
    }

    /**
     * Get Question.
     * @return question.
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Set question.
     * @param newQuestion to set.
     */
    public void setQuestion(final String newQuestion) {
        this.question = newQuestion;
    }

    /**
     * Get answer a.
     * @return answer a
     */
    public String getAnswerA() {
        return answerA;
    }

    /**
     * Set answer a.
     * @param newAnswerA to set
     */
    public void setAnswerA(final String newAnswerA) {
        this.answerA = newAnswerA;
    }

    /**
     * Get answer b.
     * @return answer b.
     */
    public String getAnswerB() {
        return answerB;
    }

    /**
     * Set answer b.
     * @param newAnswerB to set.
     */
    public void setAnswerB(final String newAnswerB) {
        this.answerB = newAnswerB;
    }

    /**
     * Get answer c.
     * @return answer c.
     */
    public String getAnswerC() {
        return answerC;
    }

    /**
     * Set answer c.
     * @param newAnswerC to set.
     */
    public void setAnswerC(final String newAnswerC) {
        this.answerC = newAnswerC;
    }

    /**
     * Get answer d.
     * @return answer d.
     */
    public String getAnswerD() {
        return answerD;
    }

    /**
     * Set answer D.
     * @param newAnswerD to set.
     */
    public void setAnswerD(final String newAnswerD) {
        this.answerD = newAnswerD;
    }

    /**
     * Get correct answer.
     * @return correct answer.
     */
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    /**
     * Set correct answer.
     * @param newCorrectAnswer to set.
     */
    public void setCorrectAnswer(final String newCorrectAnswer) {
        this.correctAnswer = newCorrectAnswer;
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
