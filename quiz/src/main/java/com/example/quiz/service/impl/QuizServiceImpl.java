package com.example.quiz.service.impl;

import com.example.quiz.entities.Film;
import com.example.quiz.entities.Music;
import com.example.quiz.entities.Quiz;
import com.example.quiz.repo.QuestionRepository;
import com.example.quiz.repo.QuizRepository;
import com.example.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

/**
 * Quiz service.
 */
@Service
public class QuizServiceImpl implements QuizService {

    /**
     * Music url.
     */
    @Value("${music}")
    private String MUSIC_URL;

    /**
     * Film url.
     */
    @Value("${film}")
    private String FILM_URL;

    /**
     * Quiz repo.
     */
    @Autowired
    private QuizRepository quizRepository;

    /**
     * Question repo.
     */
    @Autowired
    private QuestionRepository questionRepository;

    /**
     * Rest template.
     */
    private RestTemplate restTemplate = new RestTemplate();

    /**
     * Music film questions.
     */
    private MusicFilmQuestions musicFilmQuestions = new MusicFilmQuestions();


    /**
     * Get quiz object.
     * @param quizId id of the quiz.
     * @return quiz.
     */
    public Quiz getQuiz(final int quizId) {
        return quizRepository.findByQuizId(quizId);
    }

    /**
     * Get quizzes.
     * @return quizzes.
     */
    public List<Quiz> getQuizzes() {
        return quizRepository.findAll();
    }

    /**
     * Create quiz object, if the quiz exists it returns that quiz.
     * @param newQuiz the quiz.
     * @return response.
     */
    @Transactional
    public Quiz createQuiz(final Quiz newQuiz) {

        try {
            Quiz savedQuiz = quizRepository.save(newQuiz);

            if (!savedQuiz.getQuizName().isEmpty()) {
                savedQuiz.getQuestions().forEach(q -> q.setQuizId(savedQuiz.getQuizId()));
                savedQuiz.getQuestions().forEach(q -> questionRepository.save(q));
            }

            return savedQuiz;
        } catch (DataIntegrityViolationException e) {

            System.out.println("The quiz will not be added to the database as there already exists a quiz with the name '" + newQuiz.getQuizName() + "'");
            return quizRepository.findByQuizName(newQuiz.getQuizName());
        }
    }

    /**
     * Gets the music and film object and generates a quiz.
     * @param musicId music id.
     * @param filmTitle film.
     * @return quiz.
     */
    public Quiz getMusicFilmQuiz(final int musicId, final String filmTitle) {

        // Get music
        Music music = restTemplate.getForObject(MUSIC_URL + musicId, Music.class);
        List<Music> musicList = Arrays.asList(restTemplate.getForObject(MUSIC_URL, Music[].class));
        musicList.remove(music);

        // Get Film.
        Film film = restTemplate.getForObject(FILM_URL + "?title=" + filmTitle, Film.class);
        List<Film> filmList = Arrays.asList(restTemplate.getForObject(FILM_URL + "/20", Film[].class));

        // Create new quiz.
        Quiz quiz = new Quiz();
        quiz.setQuizName("Song: '" + music.getTrackName() + "' and Film: '" + film.getTitle() +  "' Quiz");
        quiz.setQuestions(musicFilmQuestions.createQuestions(music, musicList, film, filmList));

        return createQuiz(quiz);
    }





}
