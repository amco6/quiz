package com.example.result.service;

import com.example.result.entities.Result;
import com.example.result.entities.SentResult;

import java.util.List;

/**
 * Result service.
 */
public interface ResultService {

    /**
     * Save result.
     * @param sentResult result.
     * @return id.
     */
    Integer saveResult(SentResult sentResult);

    /**
     * Get results.
     * @return results.
     */
    List<Result> getResults();

    /**
     * Get results for quiz.
     * @param quizId id.
     * @return results.
     */
    List<Result> getResultsByQuizId(int quizId);

}
