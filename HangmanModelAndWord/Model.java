package Hangman;

import java.util.ArrayList;

public class Model {
	
	
	private boolean isGameOver = false;
	private boolean isWordGuessed = false;
	private boolean isLetterGuessed = false;
	private int numberOffWrongAnswers = 0;
	private int numberOffMaximalWrongAnswers = 10;
	private StringBuilder mask = new StringBuilder();
	private StringBuilder word = new StringBuilder();
	private ArrayList<Character> availableCharacters;
	
	public ArrayList<Character> getAvailableCharacters() {
		return availableCharacters;
	}
	public void setAvailableCharacters(ArrayList<Character> availableCharacters) {
		this.availableCharacters = availableCharacters;
	}
	public boolean isGameOver() {
		return isGameOver;
	}
	public boolean isWordGuessed() {
		return isWordGuessed;
	}

	
	public boolean isLetterGuessed() {
		return isLetterGuessed;
	}
	public void setLetterGuessed(boolean isLetterGuessed) {
		this.isLetterGuessed = isLetterGuessed;
	}
	public int getNumberOffWrongAnswers() {
		return this.numberOffWrongAnswers;
	}
	public void setNumberOffWrongAnswers(int numberOffWrongAnswers) {
		this.numberOffWrongAnswers = numberOffWrongAnswers;
	}
	public int getNumberOffMaximalWrongAnswers() {
		return numberOffMaximalWrongAnswers;
	}
	public void setNumberOffMaximalWrongAnswers(int numberOffMaximalWrongAnswers) {
		this.numberOffMaximalWrongAnswers = numberOffMaximalWrongAnswers;
	}
	public StringBuilder getMask() {
		return mask;
	}
	public void setMask(char[] ch) {
		this.mask.append(ch);
	}
	public StringBuilder getWord() {
		return word;
	}
	public void setWord(char[] ch) {
		this.word.append(ch);
	}
	public void setGameOver(boolean isGameOver) {
		this.isGameOver = isGameOver;
	}
	public void setWordGuessed(boolean isWordGuessed) {
		this.isWordGuessed = isWordGuessed;
	}
	
		
	public Model(String _word){
		
		this.setWord(_word.toLowerCase().toCharArray());
		this.setMask(_word.toCharArray());
		for (int i = 0; i < this.word.length(); i++) {
			if (this.mask.charAt(i) != ' ') {
				this.mask.replace(i, i + 1, "*");
			}
		}
		this.availableCharacters = new ArrayList<Character>();
		for (char i = 'a'; i <= 'z'; i++) {
			availableCharacters.add(i);
		}
	}
	
	public void setChoice(char choice) { 
		this.setLetterGuessed(false);
		String letter = String.valueOf(choice);
		int index = this.getWord().indexOf(letter.toLowerCase(), 0);
		while (index >= 0) {
			this.getMask().replace(index, index + 1, letter);
			index = this.getWord().indexOf(letter, index + 1);
			this.setLetterGuessed(true);
		}
		try{
		int indexToRemoveLetterFromAvailableCharacters = this.availableCharacters.indexOf(Character.toLowerCase(choice));
		this.availableCharacters.remove(indexToRemoveLetterFromAvailableCharacters);
		}
		catch (ArrayIndexOutOfBoundsException e){
			System.out.println("This letter is allready used, please enter new letter");
		}
		if (this.isLetterGuessed() == false) {
			this.setNumberOffWrongAnswers(this.getNumberOffWrongAnswers() + 1);
		}
		if (this.getNumberOffWrongAnswers() >= this.getNumberOffMaximalWrongAnswers()) {
			this.isGameOver = true;
		}else if (this.getMask().indexOf("*") < 0) {
			this.isWordGuessed = true;
		}
	}
}
