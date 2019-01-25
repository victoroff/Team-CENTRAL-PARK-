package Hangman;

import java.util.Scanner;

public class HangmanGame {

	public static void main(String[] args) {
		System.out.println("Welcome to Central Park Team's game The Hangman\n");
		
		while (true) {
			Scanner input = new Scanner( System.in);
			Word w = new Word();
			String wWord = w.getWord();
			Model m = new Model(wWord);
			View v = new View();
			
			while (m.isGameOver() == false && m.isWordGuessed() == false)  {
			v.drowView(m.getNumberOffWrongAnswers(), m.getAvailableCharacters(), m.getMask());
			char[] l = input.nextLine().toCharArray();
			char curentLetter = l[0];
			m.setChoice(curentLetter);
			//System.out.println(m.getMask());
			}
			v.drowEnd(m.getNumberOffWrongAnswers(), wWord, m.isWordGuessed());
			String choise = input.nextLine();
			String ch = choise.toUpperCase().substring(0, 1) ;
			
			if ( ch.equalsIgnoreCase("N")) {
				break;
			}
		} 
		
    	System.out.println("Thank you for beeng with Central Park Team's game The Hangman.");		
	}
}
