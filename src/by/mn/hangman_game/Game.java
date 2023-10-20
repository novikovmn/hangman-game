package by.mn.hangman_game;

import java.util.Scanner;

public class Game {

	private final int TOTAL_MISTAKES;
	private final HangmanDrawer hangmanDrawer;
	private final RandomWordSelector wordSelector;
	private final WordMaskOperator maskOperator;

	{
		this.hangmanDrawer = new HangmanDrawer();
		this.wordSelector = new RandomWordSelector();
		this.maskOperator = new WordMaskOperator();
		this.TOTAL_MISTAKES = 5;
	}

	public void start() {

		Scanner scanner = new Scanner(System.in);
		String option;
		int mistakesCount;

		while (true) {
			System.out.println("Menu: [N]ew game / [E]xit");
			option = scanner.nextLine();

			if (option.equalsIgnoreCase("N")) {
				mistakesCount = 0;
				this.maskOperator.clearBuffer();
				this.hangmanDrawer.clearDrawing();
				String letter = "";
				String guessedWord = this.wordSelector.getRandomlySelectedWord();
				this.maskOperator.setWord(guessedWord);
				System.out.println("A random word guessed!");
				maskOperator.printMask();

				while (!maskOperator.isUserWon()) {
					System.out.println("Guess a letter:");

					while (scanner.hasNextLine()) {
						letter = scanner.nextLine();
						if (letter.matches("[a-zA-Z]")) {
							break;
						} 
						System.out.println("Your input is not a letter! Try again.");
					}

					if (this.maskOperator.isLetterAlreadyUsed(letter)) {
						System.out.printf("You have already used the letter '%s'\n", letter);
					} else {
						this.maskOperator.useUserInputLetter(letter);
						if (this.maskOperator.containsLetter(letter)) {
							System.out.println("You guessed!");
							System.out.print("Word: ");
							this.maskOperator.updateMask(letter);
							this.maskOperator.printMask();
						} else {
							System.out.println("You didn't guess!");
							mistakesCount++;
							System.out.printf("Number of mistakes: %d/%d\n", mistakesCount, this.TOTAL_MISTAKES);
							this.hangmanDrawer.updateHangmanDrawingMatrix(mistakesCount);
							this.hangmanDrawer.printHangman();
						}
					}

					if (mistakesCount == this.TOTAL_MISTAKES) {
						System.out.println("YOU LOOSE!");
						System.out.printf("The word you had to guess: '%s'\n", guessedWord);
						break;
					} else if (this.maskOperator.isUserWon()) {
						System.out.println("YOU WON! CONGRATUATIONS)");
					}

				}

			} else if (option.equalsIgnoreCase("E")) {
				System.out.println("Exiting from the game ...");
				scanner.close();
				System.exit(0);
			} else {
				System.out.println("Incorrect input! Try Again.");
			}

		}

	}

}
