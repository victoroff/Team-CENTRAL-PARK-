package Hangman;

import java.util.Scanner;
import java.util.InputMismatchException; //added now

public class HangmanGame {

	public static void main(String[] args) {
		System.out.println("Welcome to Central Park Team's game The Hangman\n");

		while (true) {
			Scanner input = new Scanner(System.in);
			Word w = new Word();
			String wWord = w.getWord();
			Model m = new Model(wWord);
			View v = new View();

			while (m.isGameOver() == false && m.isWordGuessed() == false) {
				v.drowView(m.getNumberOffWrongAnswers(),
						m.getAvailableCharacters(), m.getMask(),
						m.isLetterUsed());

				char curentLetter;
				char[] l;

				while (true) {
					l = input.nextLine().toCharArray();
					if (l.length > 0 && Character.isLetter(l[0]) == true) {
						break;
					}
					System.out.println("The entered symbol is not letter, tray again: ");
				}
				curentLetter = l[0];
				m.setChoice(curentLetter);
			}

			v.drowEnd(m.getNumberOffWrongAnswers(), wWord, m.isWordGuessed());
			String choise = input.nextLine();
			try {
				String ch = choise.toUpperCase().substring(0, 1);
				if (ch.equalsIgnoreCase("N")) {
					break;
				}
			} catch (Exception e) {
				System.out.println("Please enter first from new game Letter!");
			}
		}

		System.out
				.println("Thank you for beeng with Central Park Team's game The Hangman");
	}
}
