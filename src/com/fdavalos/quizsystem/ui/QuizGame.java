package com.fdavalos.quizsystem.ui;

import com.fdavalos.quizsystem.util.QuizQuestion;
import java.util.List;
import java.util.Scanner;

/**
 * Represents the Quiz Game.
 *
 * <p>
 *     This class allows users to play a quiz by answering a series of questions and provides a score at the end.
 *     It interacts with the QuizQuestion class to retrieve and display quiz questions, and calculates the user's score.
 * </p>
 *
 * <p>
 *     Author: Francisco Davalos
 *     Date: May 17, 2023
 * </p>
 */
public class QuizGame {
    private List<QuizQuestion> quizQuestion;
    private Scanner scanner;

    /**
     * Constructs a new instance of the QuizGame class.
     *
     * @param quizQuestion the list of quiz questions to be used in the game
     */
    public QuizGame(List<QuizQuestion> quizQuestion) {
        this.quizQuestion = quizQuestion;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Starts the quiz game.
     * Displays the questions, accepts user input, checks the answers, and calculates the score.
     */
    public void startQuiz() {
        System.out.println("Welcome to the Quiz Game!");

        int score = 0;

        for (QuizQuestion question : quizQuestion) {
            System.out.println("\n" + question.getQuestion());

            List<String> option = question.getOptions();
            for (int i = 0; i < option.size(); i++) {
                System.out.println("\t"+(i + 1) + ". " + option.get(i));
            }

            int choice = getUserChoice();
            String userAnswer = option.get(choice-1);

            if(userAnswer.equalsIgnoreCase(question.getAnswer())){
                System.out.println("\tCorrect Answer!");
                score++;
            }else {
                System.out.println("\tWrong answer!");
            }
        }

        System.out.println("\nGame Over!");
        System.out.println("Your score: " + score + "/" + quizQuestion.size());


    }

    /**
     * Retrieves the user's choice from the console input.
     *
     * @return the user's choice as an integer
     */
    public int getUserChoice() {
        int choice;

        while (true) {
            try {
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                if(choice < 1 || choice > 4){
                    System.out.println("Invalid choice. Please enter a number between 1 and 4");
                    continue;
                }

                break;
            } catch (Exception e){
                System.out.println("Invalid input. Please enter a number");
                scanner.nextLine();
            }
        }

        return choice;
    }


}
