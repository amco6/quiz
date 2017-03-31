package com.example.result.repo;

import com.example.result.entities.Result;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Result repository.
 */
@Repository
public interface ResultRepository  extends CrudRepository<Result, Integer> {

    /**
     * Find all results.
     * @return results.
     */
    List<Result> findAll();

    /**
     * Find results by quiz.
     * @param id of the quiz.
     * @return results.
     */
    List<Result> findByQuizId(int id);
}
