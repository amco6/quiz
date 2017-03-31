package com.example.result.controller;

import com.example.result.entities.Result;
import com.example.result.entities.SentResult;
import com.example.result.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.Valid;
import java.util.List;

/**
 * Result controller.
 */
@RestController
public class ResultController {

    /**
     * Result service.
     */
    @Autowired
    private ResultService resultService;

    /**
     * Save the result.
     * @param sentResult quiz and score.
     * @return id.
     */
    @RequestMapping(value = "/result", method = RequestMethod.POST)
    public Integer saveQuizResult(@RequestBody @Valid final SentResult sentResult) {
        return resultService.saveResult(sentResult);
    }

    /**
     * Get all results.
     * @return results.
     */
    @RequestMapping(value = "/results", method = RequestMethod.GET)
    public List<Result> results() {
        return resultService.getResults();
    }

    /**
     * Get results for a quiz.
     * @param quizId the quiz.
     * @return results.
     */
    @RequestMapping(value = "/quiz/{id}/results", method = RequestMethod.GET)
    public List<Result> results(@PathVariable("id") final int quizId) {
        return resultService.getResultsByQuizId(quizId);
    }

}
