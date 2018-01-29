# Hangman

Console and Gui Based Hangman game.

## Source Code
  * Fully Documented
  * Console => coded in Java language
  * GUI => implemented using Java Swing

#### This was an assingment for my undergrad course of Advance Programming (Fall 2017, Fast-Nu Lahore).

## My Algorithm

1. Choose a Random word from a list of already given words from HangmanWordList Class.

2. Create a StringBuffer and append dashes '-' in it equal to the size of the random word choosen.

3. Take valid guess Input from the user and check it with the randomWord and do the following :
   * If Guess was right then update the StringBuffer with correct input/guess.
   * If Guess was incorrect then decremement the number of guesses which user is allowed (total 8).

4. Game ends when :
   * User loses the game if the number of guesses are equal to 0. (i.e he/she used all the allowed 8 guesses)
   * User Wins the game if there are no more dashes '-' left in String Buffer.
 
 ## Files (src)
 
 * Console
    * HangmanConsole.java
    * HangmanWordList.java
  * GUI
    * HangmanGui.java
    * HangmanWordList.java
