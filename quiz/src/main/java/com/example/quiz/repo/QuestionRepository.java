package com.example.quiz.repo;

import com.example.quiz.entities.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Quiz repo.
 */
@Repository
public interface QuestionRepository extends CrudRepository<Question, Integer> {

    /**
     * Find questions by quiz id.
     * @param id of quiz.
     * @return questions.
     */
    List<Question> findByQuizId(int id);

    /**
     * Find question by id.
     * @param id of the question.
     * @return question.
     */
    Question findByQuestionId(int id);

}
