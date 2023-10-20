package by.mn.hangman_game;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class RandomWordSelector {
	
	private String[] words;
	
	public RandomWordSelector() {
		populateWordsArrayFromFile();
	}
	
	public String getRandomlySelectedWord() {
		Random random = new Random();
		int randomIndex = random.nextInt(this.words.length);
		return words[randomIndex];
	}

	private void populateWordsArrayFromFile() {
		
		StringBuilder stringBuilder = new StringBuilder();
		
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader("words.txt"))) {
			bufferedReader.lines().forEach(stringBuilder::append);
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		} catch (IOException e) {
			throw new RuntimeException();
		}
		
		String wordsSeparatedByCommaAndSpace = stringBuilder.toString();
		this.words = wordsSeparatedByCommaAndSpace.split("[, \\.]");
	}
	


}
