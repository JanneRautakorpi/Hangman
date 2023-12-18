package dev.m3s.programming2.homework4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class WordList {
    List<String> wordList = new ArrayList<>();
    
    public WordList(String words){
        try {
            FileReader fr = new FileReader(words);
            BufferedReader br = new BufferedReader(fr);
            String word = br.readLine();

            while (word != null){
                wordList.add(word);
                word = br.readLine();
            }
            fr.close();
        } catch (IOException ioe){
            System.out.println("Failed to open a file.");
        } 
    }
    
    public List<String> giveWords(){
        return wordList;
    }
    
    public String getRandomWord(){
        Random rnd = new Random();
        int bounds = wordList.size();
        int rndNum = rnd.nextInt(bounds);
        return wordList.get(rndNum);
    }
}
