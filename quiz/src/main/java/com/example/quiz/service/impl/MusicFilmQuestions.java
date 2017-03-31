package com.example.quiz.service.impl;

import com.example.quiz.entities.Film;
import com.example.quiz.entities.Music;
import com.example.quiz.entities.Question;
import com.example.quiz.entities.QuestionType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Music film questions.
 */
public class MusicFilmQuestions {

    /**
     * Generates the music and film questions.
     * @param music the specific track.
     * @param musicList a list of tracks for the incorrect answers.
     * @param film the specific film
     * @param filmList a list of films for the incorrect answers.
     * @return music and film questions.
     */
    public List<Question> createQuestions(final Music music, final List<Music> musicList, final Film film, final List<Film> filmList) {
        List<Question> musicQuestions = createMusicQuestions(music, musicList);
        List<Question> filmQuestions = createFilmQuestions(film, filmList);

        List<Question> questionList = new ArrayList<>();
        questionList.addAll(musicQuestions);
        questionList.addAll(filmQuestions);

        Collections.shuffle(questionList);

        return questionList;
    }

    /**
     * Creates the music questions.
     * @param music the specific track.
     * @param musicList all the tracks.
     * @return a list of the movie questions.
     */
    private List<Question> createMusicQuestions(final Music music, final List<Music> musicList) {
        String track = music.getTrackName();
        String yearQ = "In what year was the song '" + track + "' released?";
        String genreQ = "What is the genre of the song '" + track + "'?";
        String albumQ = "What album is the song '" + track + "' on?";

        // Create the question from the music data.
        Question yearQuestion = setQuestion(yearQ, String.valueOf(music.getYear()), musicList, null, QuestionType.MUSIC_YEAR);
        Question genreQuestion = setQuestion(genreQ, music.getGenre(), musicList, null, QuestionType.MUSIC_GENRE);
        Question albumQuestion = setQuestion(albumQ, music.getAlbumName(), musicList, null, QuestionType.ALBUM);

        // Create list of questions
        List<Question> questionList = new ArrayList<>();
        questionList.add(yearQuestion);
        questionList.add(genreQuestion);
        questionList.add(albumQuestion);

        return questionList;
    }

    /**
     * Creates the film questions.
     * @param film the specific film.
     * @param filmList all the films.
     * @return a list of film questions.
     */
    private List<Question> createFilmQuestions(final Film film, final List<Film> filmList) {
        String title = film.getTitle();
        String releasedQ = "When was the film '" + title + "' released?";
        String directorQ = "Who was the director of the film '" + title + "'?";
        String runtimeQ = "How long is the film '" + title + "'?";
        String filmGenreQ = "What genre is the film '" + title + "'?";
        String imdbRatingQ = "What is the imdb rating of the film '" + title + "'";

        // Create the question from the music data.
        Question releasedQuestion = setQuestion(releasedQ, film.getReleased(), null, filmList, QuestionType.FILM_RELEASED);
        Question directorQuestion = setQuestion(directorQ, film.getDirector(), null, filmList, QuestionType.DIRECTOR);
        Question runtimeQuestion = setQuestion(runtimeQ, film.getRuntime(), null, filmList, QuestionType.RUNTIME);
        Question filmGenreQuestion = setQuestion(filmGenreQ, film.getGenre(), null, filmList, QuestionType.FILM_GENRE);
        Question imdbRatingQuestion = setQuestion(imdbRatingQ, film.getImdbRating(), null, filmList, QuestionType.IMDB_RATING);


        // Create list of questions
        List<Question> questionList = new ArrayList<>();
        questionList.add(releasedQuestion);
        questionList.add(directorQuestion);
        questionList.add(runtimeQuestion);
        questionList.add(filmGenreQuestion);
        questionList.add(imdbRatingQuestion);

        return questionList;
    }

    /**
     * Sets the question with the music or film data.
     * @param question the question.
     * @param answer the correct answer.
     * @param musicList all tracks.
     * @param filmList all films.
     * @param type what kind of questions is it.
     * @return a question.
     */
    private Question setQuestion(final String question, final String answer, final List<Music> musicList, final List<Film> filmList, final QuestionType type) {

        // Create the question
        Question newQuestion = new Question();

        String correctAnswer = getRandomLetter();

        newQuestion.setQuestion(question);
        newQuestion.setCorrectAnswer(correctAnswer);

        List<String> answers = new ArrayList<>();

        switch (correctAnswer) {
            case "a":
                newQuestion.setAnswerA(answer);
                answers.add(answer);

                newQuestion.setAnswerB(setIncorrectAnswer(answers, musicList, filmList, type));
                answers.add(newQuestion.getAnswerB());
                newQuestion.setAnswerC(setIncorrectAnswer(answers, musicList, filmList, type));
                answers.add(newQuestion.getAnswerC());
                newQuestion.setAnswerD(setIncorrectAnswer(answers, musicList, filmList, type));

                break;
            case "b":
                newQuestion.setAnswerB(answer);
                answers.add(answer);

                newQuestion.setAnswerA(setIncorrectAnswer(answers, musicList, filmList, type));
                answers.add(newQuestion.getAnswerA());
                newQuestion.setAnswerC(setIncorrectAnswer(answers, musicList, filmList, type));
                answers.add(newQuestion.getAnswerC());
                newQuestion.setAnswerD(setIncorrectAnswer(answers, musicList, filmList, type));

                break;
            case "c":
                newQuestion.setAnswerC(answer);
                answers.add(answer);

                newQuestion.setAnswerA(setIncorrectAnswer(answers, musicList, filmList, type));
                answers.add(newQuestion.getAnswerA());
                newQuestion.setAnswerB(setIncorrectAnswer(answers, musicList, filmList, type));
                answers.add(newQuestion.getAnswerB());
                newQuestion.setAnswerD(setIncorrectAnswer(answers, musicList, filmList, type));

                break;
            case "d":
                newQuestion.setAnswerD(answer);
                answers.add(answer);

                newQuestion.setAnswerA(setIncorrectAnswer(answers, musicList, filmList, type));
                answers.add(newQuestion.getAnswerA());
                newQuestion.setAnswerB(setIncorrectAnswer(answers, musicList, filmList, type));
                answers.add(newQuestion.getAnswerB());
                newQuestion.setAnswerC(setIncorrectAnswer(answers, musicList, filmList, type));

                break;

        }

        return newQuestion;
    }

    /**
     * Generates an incorrect answer that does not match any of the other answers for that question.
     * @param answers to the question.
     * @param musicList all tracks.
     * @param filmList all films.
     * @param type what kind of question is it.
     * @return and incorrect answer.
     */
    private String setIncorrectAnswer(final List<String> answers, final List<Music> musicList, final List<Film> filmList, final QuestionType type) {
        String incorrectAnswer = "Other";

        if (musicList != null) {
            for (int i = 0; i < musicList.size(); i++) {
                if (incorrectAnswer.equals("Other")) {
                    switch (type) {
                        case MUSIC_GENRE:
                            if (!answers.contains(musicList.get(i).getGenre())) {
                                incorrectAnswer = musicList.get(i).getGenre();
                            }
                            break;
                        case ALBUM:
                            if (!answers.contains(musicList.get(i).getAlbumName())) {
                                incorrectAnswer = musicList.get(i).getAlbumName();
                            }
                            break;
                        case MUSIC_YEAR:
                            if (!answers.contains(String.valueOf((musicList.get(i).getYear())))) {
                                incorrectAnswer = String.valueOf(musicList.get(i).getYear());
                            }
                            break;
                    }
                }
            }
        }
        if (filmList != null) {
            for (int i = 0; i < filmList.size(); i++) {
                if (incorrectAnswer.equals("Other")) {
                    switch (type) {
                        case FILM_RELEASED:
                            if (!answers.contains(filmList.get(i).getReleased())) {
                                incorrectAnswer = filmList.get(i).getReleased();
                            }
                            break;
                        case DIRECTOR:
                            if (!answers.contains(filmList.get(i).getDirector())) {
                                incorrectAnswer = filmList.get(i).getDirector();
                            }
                            break;
                        case RUNTIME:
                            if (!answers.contains(filmList.get(i).getRuntime())) {
                                incorrectAnswer = filmList.get(i).getRuntime();
                            }
                            break;
                        case FILM_GENRE:
                            if (!answers.contains(filmList.get(i).getGenre())) {
                                incorrectAnswer = filmList.get(i).getGenre();
                            }
                            break;
                        case IMDB_RATING:
                            if (!answers.contains(filmList.get(i).getImdbRating())) {
                                incorrectAnswer = filmList.get(i).getImdbRating();
                            }
                            break;
                    }
                }
            }
        }
        return incorrectAnswer;
    }

    /**
     * Generates a random letter from a-d.
     * @return a letter.
     */
    private String getRandomLetter() {
        Random random = new Random();
        int number = random.nextInt(4);
        String answer = "a";
        switch (number) {
            case 0:
                answer = "a";
                break;
            case 1:
                answer = "b";
                break;
            case 2:
                answer = "c";
                break;
            case 3:
                answer =  "d";
                break;
        }
        return answer;
    }
}
