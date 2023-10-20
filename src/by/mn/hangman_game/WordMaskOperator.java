package by.mn.hangman_game;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class WordMaskOperator {

	private String word;
	private String[] mask;
	private int numberOfGuessedLetters;
	private final Set<String> usedLetters = new HashSet<>();
	private final Set<String> wordUniqueLetters = new HashSet<>();

	public void setWord(String word) {
		this.word = word;
		this.mask = new String[word.length()];
		Arrays.fill(mask, "*");
		Collections.addAll(this.wordUniqueLetters, word.split(""));
	}

	public void printMask() {
		System.out.println(String.join("", mask));
	}

	public void updateMask(String letter) {
		for (int i = 0; i < word.length(); i++) {
			if (Character.toString(word.charAt(i)).equalsIgnoreCase(letter)) {
				this.mask[i] = letter;
			}
		}
		this.numberOfGuessedLetters++;
	}

	public boolean containsLetter(String letter) {
		return this.wordUniqueLetters.contains(letter);
	}

	public void useUserInputLetter(String letter) {
		this.usedLetters.add(letter);
	}

	public boolean isLetterAlreadyUsed(String letter) {
		return this.usedLetters.contains(letter);
	}

	public boolean isUserWon() {
		return this.numberOfGuessedLetters == this.wordUniqueLetters.size();
	}

	public void clearBuffer() {
		this.usedLetters.clear();
		this.wordUniqueLetters.clear();
		this.numberOfGuessedLetters = 0;
	}

}
