package com.example.quiz.service;

import com.example.quiz.entities.Quiz;

import java.util.List;

/**
 * Quiz Service.
 */
public interface QuizService {

    /**
     * Get quiz game.
     * @param quizId id of the quiz.
     * @return quiz.
     */
    Quiz getQuiz(int quizId);

    /**
     * Create quiz game.
     * @param quizObject the quiz.
     * @return quiz.
     */
    Quiz createQuiz(Quiz quizObject);

    /**
     * Get all quizzes.
     * @return quizzes.
     */
    List<Quiz> getQuizzes();

    /**
     * Gets music and films object and creates a quiz.
     * @param musicId music id.
     * @param filmTitle film.
     * @return quiz.
     */
    Quiz getMusicFilmQuiz(int musicId, String filmTitle);
}
