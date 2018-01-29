/*
Muhammad Zain UL Islam / Zain-Sra
Advance Programming (Section A) 
Assingment Task 1 : Hangman

This is a stub class , which only contains a list of 10 words to play in our Hangman game.
We will use the getWord() method in our main class Hangman134046 to choose a word and start the game. 
 */
package hangman.gui;

public class HangmanWordList {
    
       public int getWordCount() {
        return 10;
    }

    public String getWord(int index) {
        switch (index) {
            case 0:
                return "BUOY";
            case 1:
                return "COMPUTER";
            case 2:
                return "CONNOISSEUR";
            case 3:
                return "DEHYDRATE";
            case 4:
                return "FUZZY";
            case 5:
                return "HUBBUB";
            case 6:
                return "KEYHOLE";
            case 7:
                return "QUAGMIRE";
            case 8:
                return "zain";
            case 9:
                return "ZIRCON";

            default:
                return new String("Illegal index");
        }
    }
}
