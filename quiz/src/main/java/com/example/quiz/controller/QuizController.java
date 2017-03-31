package com.example.quiz.controller;

import com.example.quiz.entities.Quiz;
import com.example.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

/**
 * Controller for the quiz game.
 */
@RestController
public class QuizController {

    /**
     * Quiz service.
     */
    @Autowired
    private QuizService quizService;

    /**
     * Get the quiz game.
     * @param quizId id of the game.
     * @return the quiz.
     */
    @RequestMapping(value = "/quiz/{id}", method = RequestMethod.GET)
    public Quiz getQuizGame(
            @PathVariable("id") final int quizId) {
        return quizService.getQuiz(quizId);
    }

    /**
     * Get all quizzes.
     * @return quizzes.
     */
    @RequestMapping(value = "/quizzes", method = RequestMethod.GET)
    public List<Quiz> getQuizGames() {
        return quizService.getQuizzes();
    }

    /**
     * Create quiz.
     * @param newQuiz the quiz.
     * @return response.
     */
    @RequestMapping(value = "/quiz/new", method = RequestMethod.POST)
    public Integer createQuizGame(@RequestBody @Valid final Quiz newQuiz) {
        return quizService.createQuiz(newQuiz).getQuizId();
    }

    /**
     * Gets music film quiz.
     * @param musicId music id.
     * @param filmTitle film.
     * @return quiz.
     */
    @RequestMapping(value = "/music/{musicId}/film", method = RequestMethod.GET)
    public Quiz getMusicFilmQuiz(
            @PathVariable("musicId") final int musicId,
            @RequestParam(value = "title") final String filmTitle
    ) {
        return quizService.getMusicFilmQuiz(musicId, filmTitle);
    }
}
