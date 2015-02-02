package Hangman;

import java.util.Random;

public class Word {

	public String getWord() {
		Random rnd = new Random();
		String[] listOfWord = {"Sofia","Plovdiv","Varna","Veliko Tarnovo","Haskovo","Montana","Burgas","Gorna Orqhovica","Petric"};
		int index = rnd.nextInt(listOfWord.length - 1);
		String word = listOfWord[index];
		return word;	
	}
		
}
	
