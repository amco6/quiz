package com.example.result.service.Impl;

import com.example.quiz.entities.Question;
import com.example.quiz.entities.Quiz;
import com.example.result.entities.Result;
import com.example.result.entities.SentResult;
import com.example.result.repo.ResultRepository;
import com.example.result.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Result service impl.
 */
@Service
public class ResultServiceImpl implements ResultService {

    /**
     * Result Repository.
     */
    @Autowired
    private ResultRepository resultRepository;

    /**
     * Rest template.
     */
    private RestTemplate restTemplate = new RestTemplate();

    /**
     * Question url.
     */
    @Value("${question}")
    private String QUESTION_URL;

    /**
     * Save the result.
     * @param sentResult result.
     * @return id.
     */
    public Integer saveResult(final SentResult sentResult) {

        Result result = new Result();
        List<Question> questions = restTemplate.getForObject(QUESTION_URL + sentResult.getQuizId(), Quiz.class).getQuestions();

        result.setQuizId(sentResult.getQuizId());
        result.setName(sentResult.getName());
        result.setPercentage(getPercentage(sentResult.getScore(), questions.size()));

        return resultRepository.save(result).getResultId();
    }

    /**
     * Get results.
     * @return results.
     */
    public List<Result> getResults() {
        return resultRepository.findAll();
    }

    /**
     * Get results by quiz id.
     * @param quizId id.
     * @return results.
     */
    public List<Result> getResultsByQuizId(final int quizId) {
        return resultRepository.findByQuizId(quizId);
    }

    /**
     * Get the percentage.
     * @param score amount correct.
     * @param questions amount of questions.
     * @return percentage.
     */
    private Integer getPercentage(final double score, final double questions) {
        return (int) Math.round((score / questions) * 100);
    }
}
