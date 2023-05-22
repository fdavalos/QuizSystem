package com.fdavalos.quizsystem.util;

import java.util.List;

/**
 * Represents a quiz question in the Quiz System.
 *
 * <p>
 *     This class encapsulates a quiz question, including the question itself, a list of options,
 *     and the correct answer.
 * </p>
 *
 * <p>
 *     Author: Francisco Davalos
 *     Date: May 17, 2023
 * </p>
 */
public class QuizQuestion {
    private String question;
    private List<String> options;
    private String answer;

    /**
     * Constructs a QuizQuestion with the specified question, options, and answer.
     *
     * @param question the question
     * @param options the list of options
     * @param answer the correct answer
     */
    public QuizQuestion(String question, List<String> options, String answer){
        this.question = question;
        this.options = options;
        this.answer = answer;
    }

    /**
     * Retrieves the question.
     *
     * @return the question
     */
    public String getQuestion(){
        return question;
    }

    /**
     * Retrieves the question.
     *
     * @return the question
     */
    public List<String> getOptions(){
        return options;
    }

    /**
     * Retrieves the correct answer.
     *
     * @return the correct answer
     */
    public String getAnswer(){
        return answer;
    }
}
