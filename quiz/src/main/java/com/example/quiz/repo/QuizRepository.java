package com.example.quiz.repo;

import com.example.quiz.entities.Quiz;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Quiz repo.
 */
@Repository
public interface QuizRepository extends CrudRepository<Quiz, Integer> {

    /**
     * Find quiz by id.
     * @param id id.
     * @return quiz.
     */
    Quiz findByQuizId(int id);

    /**
     * Find all quizzes.
     * @return quiz.
     */
    List<Quiz> findAll();

    /**
     * Find quiz by name.
     * @param name the name.
     * @return the quiz.
     */
    Quiz findByQuizName(String name);
}
