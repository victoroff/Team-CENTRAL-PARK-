package Hangman;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Word {

	public String getWord() {
		Random rnd = new Random();
		ArrayList<String> wds = new ArrayList<String>();
		String word = new String();

		try (Scanner input = new Scanner(new FileReader("capitals.txt"))) {
			while (input.hasNextLine()) {
				wds.add(input.nextLine());
			}
		} catch (IOException ex) {
			System.err.println("Missing countries.txt");
		}
		int index = rnd.nextInt(wds.size() - 1);
		word = wds.get(index);
		wds.remove(index);
		return word;
	}

}
