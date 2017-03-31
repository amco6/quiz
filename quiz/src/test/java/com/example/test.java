package com.example;

import com.example.quiz.controller.QuizController;
import com.example.quiz.entities.Quiz;
import com.example.quiz.service.QuizService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;

/**
 * Test app.
 */
public class test {

    @InjectMocks
    private QuizController quizController;

    @Mock
    private QuizService quizService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetQuizzes() {
        Quiz quiz = new Quiz();
        quiz.setQuizName("Mock quiz");
        Quiz quiz2 = new Quiz();
        quiz2.setQuizName("Mock quiz 2");
        List<Quiz> quizzes = new ArrayList<>();
        quizzes.add(quiz);
        quizzes.add(quiz2);

        when(quizService.getQuizzes()).thenReturn(quizzes);

        assertThat(quizController.getQuizGames().get(0), is(quiz));

    }
}
