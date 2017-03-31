package com.example.quiz.controller;

import com.example.quiz.repo.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Question Controller.
 */
@RestController
public class QuestionController {

    /**
     * Question repo.
     */
    @Autowired
    private QuestionRepository questionRepository;

    /**
     * Get the question.
     * @param questionId id of the question.
     * @return the answer.
     */
    @RequestMapping(value = "/question/{id}", method = RequestMethod.GET)
    public String getQuestionAnswer(
            @PathVariable("id") final int questionId) {
        return questionRepository.findByQuestionId(questionId).getCorrectAnswer();
    }

}
