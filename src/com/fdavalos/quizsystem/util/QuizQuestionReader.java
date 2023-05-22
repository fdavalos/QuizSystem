package com.fdavalos.quizsystem.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Reads quiz questions from the question bank.
 *
 * <p>
 *     This class provides a method to retrieve quiz questions from the question bank table in the database.
 *     It uses the DatabaseConnectionManager class to establish a database connection and execute the query.
 * </p>
 *
 * <p>
 *     Author: Francisco Davalos
 *     Date: May 17, 2023
 * </p>
 */
public class QuizQuestionReader {
    private static final DatabaseConnectionManager connectionManager = new DatabaseConnectionManager();

    /**
     * Reads quiz questions from the question bank.
     *
     * @return a list of QuizQuestion objects representing the quiz questions
     */
    public static List<QuizQuestion> readQuizQuestions() {
        List<QuizQuestion> quizQuestions = new ArrayList<>();
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM question_bank");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String question = resultSet.getString("question");
                String optionA = resultSet.getString("option_a");
                String optionB = resultSet.getString("option_b");
                String optionC = resultSet.getString("option_c");
                String optionD = resultSet.getString("option_d");
                String answer = resultSet.getString("answer");

                List<String> options = Arrays.asList(optionA,optionB,optionC,optionD);

                QuizQuestion quizQuestion = new QuizQuestion(question, options, answer);
                quizQuestions.add(quizQuestion);
            }

        } catch (SQLException e) {
            System.out.println("Failed to read questions from database");
        }


        return quizQuestions;

    }
}
