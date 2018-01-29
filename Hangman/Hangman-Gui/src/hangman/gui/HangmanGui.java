/*
Muhammad Zain UL Islam / Zain-Sra
Advance Programming (Section A) 
Assingment

Question 1 : GUI Based Hangman Game

My Algorithm: 
1. A Random word choosen from a list of already given words from HangmanLexicon Class.
2.Create a StringBuffer and append dashes '-' in it equal to the size of the random word choosen.
3.Take valid guess Input from the user and check it with the randomWord and do the following :
>If Guess was right then update the StringBuffer with correct input/guess.
>If Guess was incorrect then decremement the number of guesses which user is allowed (by default total 8).
4.Game ends when :
>User loses the game if the number of guesses are equal to 0. (i.e he/she used all the allowed 8 guesses)
>User Wins the game if there are no more dashes '-' left in String Buffer

 */
package hangman.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.*;

public class HangmanGui {

    //Initiliazing GUI Elements
    private void setUP_Gui() {

        mainFrame = new JFrame();
        informationBoard = new JTextArea("Welcome To Zain-Sra Hangman !\n");

        JScrollPane scrollPane = new JScrollPane(informationBoard);
        scrollPane.setBounds(3, 3, 370, 300);

        writeGuess = new JTextField(1);
        writeGuess.setBounds(10, 350, 300, 50);

        submitGuessBtn = new JButton("Check");
        submitGuessBtn.setBounds(300, 350, 70, 50);

        mainFrame.add(writeGuess);
        mainFrame.add(submitGuessBtn);
        mainFrame.add(scrollPane);

        mainFrame.setSize(400, 500);
        mainFrame.setLayout(null);

    }

    //Initiliazing Game Variables
    private void setUP_Game() {

        //HangmanWordList class contains the list of words (total 10) which we can use in our game
        //By using the getWord(index) method of this  class we can get a word with the given index 
        HangmanWordList list = new HangmanWordList();

        Random rand = new Random(); //Random number generator
        int randIndex = rand.nextInt(list.getWordCount() - 1); //Random Number generated between 0 - 9 , getWordCount returns 10 i.e # of words in HangmanWorldList class
        
        mainWord = list.getWord(randIndex);

        dashes = new StringBuffer();

        for (int i = 0; i < mainWord.length(); i++) {
            dashes.append("-");
        }

    }

    public void Start_Game() {

        setUP_Gui(); //Intializing GUI
        setUP_Game(); //Initializing Game

        mainFrame.setVisible(true);

        //*******************************************Starting Game**********************************************//
        //Game Ends in either Win or Lose
        //Win Situation: Number of correct Guesses becomes equal to the length of the main word
        //Lose Situation: Number of guesses allowed becomes equal to 0
        informationBoard.append("\nThe word now looks like this : " + dashes + "\nYou have " + numOfGuess + " guesses left.\n");

        submitGuessBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                //Checking Loss / Win 
                if (numOfGuess == 0) {
                    informationBoard.append("\nYou're Completely hung.");
                    informationBoard.append("\nThe word was : " + mainWord);
                    informationBoard.append("\nYou Lose.");

                    submitGuessBtn.setEnabled(false);

                } else if (dashes.indexOf("-") == -1) {
                    informationBoard.append("\nYou guessed the word : " + mainWord);
                    informationBoard.append("\nYou Win.");

                    submitGuessBtn.setEnabled(false);
                } else {

                    guess = writeGuess.getText().toUpperCase();

                    if (!guess.equals("") && guess.matches("[A-Za-z]{1}")) {

                        //Checking the occurence of the guess in the mainWord , will return -1 if not found else a positive number
                        guessIndex = mainWord.indexOf(guess);

                        if (guessIndex < 0) {
                            informationBoard.append("\nThere are no " + guess + "'s in the word.");
                            numOfGuess--;

                        } else {

                            //Replacing the dash with the correct guess character in the StringBuffer
                            //While loop is used if there are more than one occurence of a specific character in the main Word/String Buffer
                            while (guessIndex >= 0) {

                                dashes.replace(guessIndex, guessIndex + 1, guess);

                                guessIndex = mainWord.indexOf(guess, guessIndex + 1);

                            }

                            informationBoard.append("\nThe guess is correct.");

                        }

                        if (numOfGuess == 0) {
                            informationBoard.append("\nYou're Completely hung.");
                            informationBoard.append("\nThe word was : " + mainWord);
                            informationBoard.append("\nYou Lose.");

                            submitGuessBtn.setEnabled(false);
                        } else {
                            informationBoard.append("\n\nThe word now looks like this : " + dashes + "\nYou have " + numOfGuess + " guesses left.\n");
                        }

                    } else {
                        JOptionPane.showMessageDialog(mainFrame, "Please Enter an Alphabet [a-z , A-Z]!");
                    }
                }

            }
        });

    }

    HangmanGui() {

        numOfGuess = 8; //By Default Number of Guesses / Lives are 8

    }

    //Main Driver
    public static void main(String[] args) {

        HangmanGui hangman = new HangmanGui();

        hangman.Start_Game();

    }

    // Gui Elements
    private JFrame mainFrame; //main Window
    private JTextArea informationBoard; //To display Game information
    private JButton submitGuessBtn;
    private JTextField writeGuess;

    // Variables for Game
    private int numOfGuess; //Total number of guesses allowed are 8
    private String guess; //To store User's guess

    private int guessIndex; //To store the index of the guess character in the main Word which will either be greater than 0 or -1(in case there was no occurence of such character)

    private String mainWord; //To store the Word to guess from HangmanLexicon method getWord()

    private StringBuffer dashes; //To store dashes equal to size of mainWord

    //Getter & Setter for # of Guesses / # of Lives
    public int getNumOfGuess() {
        return numOfGuess;
    }

    public void setNumOfGuess(int numOfGuess) {
        this.numOfGuess = numOfGuess;
    }

}
