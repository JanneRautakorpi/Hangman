package dev.m3s.programming2.homework4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        
        WordList wl = new WordList("words.txt");
        Hangman hm = new Hangman(wl, 10);
        Scanner scan = new Scanner(System.in);
        String userGuess;

        while (!hm.theEnd()){
            System.out.println("The hidden word...\n");
            for (int i = 0; i < hm.getMaskedWord().length() - 1; i++){
                System.out.print(hm.getMaskedWord().toCharArray()[i] + " ");
            }
            System.out.print(hm.getMaskedWord().toCharArray()[hm.getMaskedWord().length()-1]);
            System.out.print("\n\nGuesses left: " + hm.guessesLeft());
            System.out.print("\nGuessed letters: " + hm.guesses());
            System.out.print("\n\nGuess a letter: ");
            userGuess = scan.nextLine();
            char guessInChar = userGuess.charAt(0);
            hm.guess(guessInChar);
            System.out.print("\n");
        }
        scan.close();
        if (hm.hasWon()){
            System.out.println("Congratulations! You won!!!");
        }else{
            System.out.println("Sorry, you lost!");
        }
        System.out.println("The hidden word was: \"" + hm.word() + "\"");
    }
}
