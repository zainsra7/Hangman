/*
Muhammad Zain UL Islam / Zain-Sra
Advance Programming (Section A) 
Assingment

Question 1 : Console Based Hangman Game

My Algorithm: 
1.Choose a Random word from a list of already given words from HangmanLexicon Class.
2.Create a StringBuffer and append dashes '-' in it equal to the size of the random word choosen.
3.Take valid guess Input from the user and check it with the randomWord and do the following :
>If Guess was right then update the StringBuffer with correct input/guess.
>If Guess was incorrect then decremement the number of guesses which user is allowed (total 8).
4.Game ends when :
>User loses the game if the number of guesses are equal to 0. (i.e he/she used all the allowed 8 guesses)
>User Wins the game if there are no more dashes '-' left in String Buffer

 */
package hangmanconsole;

import java.util.Random;
import java.util.Scanner;


public class HangmanConsole {

    
    
    HangmanConsole(){
    
        numOfGuess = 8; //By Default Number of Guesses / Lives are 8

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
    
    void Start_Game(){
      
        setUP_Game(); //Initializing Game
        
           System.out.println("----Welcome to Zain-Sra Hangman !----");


      //*******************************************Starting Game**********************************************//
        //Game Ends in either Win or Lose
        //Win Situation: Number of correct Guesses becomes equal to the length of the main word
        //Lose Situation: Number of guesses allowed becomes equal to 0
        
         do {

            System.out.println("The word now looks like this : " + dashes + "\nYou have " + numOfGuess + " guesses left.");

            System.out.print("\nYour Guess : ");

            Scanner scanner = new Scanner(System.in); //To take User Input
            
            guess = scanner.nextLine().toUpperCase();

            //Checking valid guess from User
            //Character and A-Z , a-z 
            if (!guess.matches("[A-Za-z]{1}")) {

                do {
                    System.out.println("Wrong Input !");
                    System.out.println("Please Enter a Single valid Alphabet : ");
                    guess = scanner.nextLine().toUpperCase();
                } while (!guess.matches("[A-Za-z]{1}"));

            }

            //Checking the occurence of the guess in the mainWord , will return -1 if not found else a positive number
            guessIndex = mainWord.indexOf(guess);

            if (guessIndex < 0) {
                System.out.println("There are no " + guess + "'s in the word.");
                numOfGuess--;
            } else {

                //Replacing the dash with the correct guess character in the StringBuffer
                //While loop is used if there are more than one occurence of a specific character in the main Word/String Buffer
                while (guessIndex >= 0) {

                    dashes.replace(guessIndex, guessIndex + 1, guess);

                    guessIndex = mainWord.indexOf(guess, guessIndex + 1);

                }

                System.out.println("The guess is correct.");

            }

        } while (numOfGuess != 0 && dashes.indexOf("-") != -1);

        //Printing following messages in case of Lose or Win
        if (numOfGuess == 0) {
            System.out.println("You're Completely hung.");
            System.out.println("The word was : " + mainWord);
            System.out.println("You Lose.");

        } else if (dashes.indexOf("-") == -1) {
            System.out.println("You guessed the word : " + mainWord);
            System.out.println("You Win.");
        }
        
  
    }
    
    
    public static void main(String[] args) {
        
        HangmanConsole hangman = new HangmanConsole();

        hangman.Start_Game();
    }
    
    
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
