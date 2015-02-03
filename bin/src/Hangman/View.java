package Hangman;

import java.util.ArrayList;

public class View {

	public void drowView(int numberOffWrongAnswers,
			ArrayList<Character> availableCharacters, StringBuilder mask,
			boolean isLetterUsed) {
		String maskToWrite = mask.toString();
		this.clear();
		// this.clearConsole();
		if (isLetterUsed) {
			System.out.println("The letter is used, try again!");
			System.out.println("******************************");
		}

		System.out.print("Available letters are: ");
		this.writeLetters(availableCharacters);
		System.out.print("\nThe word to gess is:   ");
		System.out.println(maskToWrite + "\n");
		this.drawGallows(numberOffWrongAnswers);
		System.out.print("Your guess is:");
	}

	public void drowEnd(int numberOffWrongAnswers, String wWord,
			boolean isWordGuessed) {
		this.clear();
		if (isWordGuessed) {
			System.out
					.println("*****************\n    YOU WIN  !\n*****************");
		} else {
			System.out
					.println("*****************\n Sorry you lose !\n*****************");
			System.out.println("The word to guess was: " + wWord);
			this.drawGallows(numberOffWrongAnswers);
		}

		System.out.print("\nPlay again ?\n(for exit the game press \"N\")");
	}

	private void drawGallows(int numberOffWrongAnswers) {
		char[][] gallows = new char[12][11];
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 12; j++) {
				gallows[j][i] = ' ';
				gallows[j][i] = ' ';
			}
		}

		switch (numberOffWrongAnswers) {
		case 10:
			gallows[6][4] = '\\';
		case 9:
			gallows[6][2] = '/';
		case 8:
			gallows[4][4] = '/';
		case 7:
			gallows[4][2] = '\\';
		case 6:
			gallows[4][3] = '|';
			gallows[5][3] = '|';
		case 5:
			gallows[3][3] = 'O';
		case 4:
			gallows[2][3] = '|';
		case 3:
			for (int i = 3; i <= 8; i++) {
				gallows[1][i] = '_';
			}
		case 2:
			for (int i = 2; i <= 9; i++) {
				gallows[i][7] = '|';
				gallows[i][8] = '|';
			}
		case 1:
			for (int i = 4; i <= 9; i++) {
				gallows[10][i] = '=';
			}
		case 0:

			for (int i = 0; i < 11; i++) {
				gallows[0][i] = '*';
				gallows[11][i] = '*';
			}
			for (int i = 0; i < 12; i++) {
				gallows[i][0] = '*';
				gallows[i][10] = '*';
				;
			}
		}
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 11; j++) {
				System.out.print(gallows[i][j]);
			}
			System.out.println();
		}
	}

	private void writeLetters(ArrayList<Character> letters) {
		StringBuilder sb = new StringBuilder();
		for (Character letter : letters) {
			sb.append(letter.toString());
			sb.append(' ');
		}
		System.out.println(sb.toString());

	}

	private void clear() {
		for (int clear = 0; clear < 493; clear++) {
			System.out.println(""); // "\b"
		}
	}

	public final static void clearConsole() {
		try {
			final String os = System.getProperty("os.name");

			if (os.contains("Windows")) {
				Runtime.getRuntime().exec("cls");
			} else {
				Runtime.getRuntime().exec("clear");
			}
		} catch (final Exception e) {
			// Handle any exceptions.
		}
	}
}