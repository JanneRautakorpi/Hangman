package dev.m3s.programming2.homework4;

import java.util.ArrayList;
import java.util.List;

public class Hangman {
    private WordList wordlist;
    private int guesses;
    private String correctWord;
    private String maskedWord;
    private List<Character> guessedChars = new ArrayList<>();

    public Hangman(WordList wordlist, int guesses){
            if (guesses > 0 && wordlist != null){
                this.guesses = guesses;
                this.wordlist = wordlist;
                correctWord = this.wordlist.getRandomWord();
                maskedWord = correctWord.replaceAll(".", "*");
            }
    }

    public boolean guess(Character c){
        char upper = Character.toUpperCase(c);
        char lower = Character.toLowerCase(c);

        if (!(guessedChars.contains(lower))){
            guessedChars.add(guessedChars.size(), lower);
        }

        if (correctWord.contains(Character.toString(upper))
            || correctWord.contains(Character.toString(lower))){
            StringBuilder str = new StringBuilder(maskedWord);
            for (int i = 0; i < correctWord.length(); i++){
                if (correctWord.charAt(i) == Character.toUpperCase(c)
                    || correctWord.charAt(i) == Character.toLowerCase(c)){
                    str.setCharAt(i, lower);
                }
            }
            maskedWord = str.toString();
            return true;
        }
        guesses -= 1;
        return false;
    }
    
    public List<Character> guesses(){
        return guessedChars;
    }

    public int guessesLeft(){
        return guesses;
    }

    public String word(){
        return correctWord;
    }

    public String getMaskedWord(){
        return maskedWord;
    }

    public boolean theEnd(){
        if (maskedWord.toLowerCase().equals(correctWord.toLowerCase())){
            return true;
        }
        else if (guessesLeft() <= 0){
            return true;
        }
        return false;
    }

    public boolean hasWon(){
        if (maskedWord.equals(correctWord)
            && guesses > 0){
                return true;
            }
        return false;
    }
}
