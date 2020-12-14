package hangman;

import java.util.Scanner;
import java.util.Random;

public class Hangman {

    static String[] words = {"error", "array", "variable", "string", "integer", "boolean", "short", "long", "float", "scanner"};
    static String wordToGuess = "";
    static int wrongGuesses = 0;
    static int totalGuesses = 0;
    static boolean wordFound = false;
    static int lettersNotFound = 0;
    static String guessedLetter = "";
    static boolean guessCorrect = false;
    static String[] wordtoguess = {};

    public static void main(String[] args) {
        System.out.println("welcome to hangman the word guessing game");
        System.out.println("all words are themed around coding");
        getWordToGuess();
        wordToBlankSpaces();
        System.out.println("you will have 10 guesses");
        Scanner scan = new Scanner(System.in);
        while (wordFound = false || totalGuesses < 10) {
            guessCorrect = false;
            System.out.println("enter a letter");
            guessedLetter = scan.next();
            guessInWord();
            addLetter();
            changeScore();
            printScore();
            gameToContinue();
        }
        if (wordFound == false){
            System.out.println("you lose");
            System.out.println("the word was " + wordToGuess);
                    
        }
    }

    public static String getWordToGuess() {
        Random rand = new Random();
        int randnum = rand.nextInt(words.length);
        for (int i = 0; i < words.length; i++) {
            if (i == randnum) {
                wordToGuess = words[i];
            }
        }
        return wordToGuess;
    }

    public static String[] wordToBlankSpaces() {
        int length = wordToGuess.length();
        System.out.println("the word is " + length + " letters");
        wordtoguess = new String[length];
        for (int j = 0; j < length; j++) {
            wordtoguess[j] = "_ ";
            System.out.print(wordtoguess[j]);
        }
        return wordtoguess;
    }

    public static void guessInWord() {
        if (wordToGuess.contains(guessedLetter)) {
            System.out.println("you guesed a letter correctly");
            guessCorrect = true;
        } else {
            System.out.println("you guessed the letter incorrectly");
        }
    }

    public static String[] addLetter() {
        if (guessCorrect == true) {
            for (int j = 0; j < wordToGuess.length(); j++) {
                char space = wordToGuess.charAt(j);
                if (guessedLetter.equals(space)) {
                    wordtoguess[j] = guessedLetter;
                }
            }
        }
        return wordtoguess;
    }

    public static void changeScore() {
        totalGuesses = totalGuesses + 1;
        if (guessCorrect == false) {
            wrongGuesses = wrongGuesses + 1;
        }
    }

    public static void printScore() {
        for (String wordtogues : wordtoguess) {
            System.out.print(wordtogues);
        }
        System.out.println("\ntotal guesses = " + totalGuesses);
        System.out.println("wrong guesses = " + wrongGuesses);
    }

    public static void gameToContinue() {
        for (int I = 0; I < wordToGuess.length(); I++) {
            if (wordtoguess[I].equals("_ ")) {
                lettersNotFound = lettersNotFound + 1;
            }
            if(lettersNotFound == 0){
                wordFound = true;
                System.out.println("you win");
            }
        }
    }
}
