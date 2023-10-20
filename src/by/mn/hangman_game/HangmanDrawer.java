package by.mn.hangman_game;

import java.util.Arrays;

public class HangmanDrawer {

	private final int ROWS = 8;
	private final int COLS = 6;

	private String[][] hangmanDrawingMatrix = new String[ROWS][COLS];

	public HangmanDrawer() {
		clearDrawing();
	}

	public void printHangman() {
		for (String[] matrixRow : this.hangmanDrawingMatrix) {
			for (int i = 0; i < matrixRow.length; i++) {
				System.out.print(matrixRow[i]);
				if (i == matrixRow.length) {
					System.out.print("\n");
				}
			}
		}
	}

	public void updateHangmanDrawingMatrix(int numberOfMistake) {
		switch (numberOfMistake) {
			case 1 -> {
				this.hangmanDrawingMatrix[7][0] = "_";
				this.hangmanDrawingMatrix[7][1] = "_";
				this.hangmanDrawingMatrix[7][2] = "_";
				this.hangmanDrawingMatrix[6][1] = "|";
				this.hangmanDrawingMatrix[5][1] = "|";
				this.hangmanDrawingMatrix[4][1] = "|";
			}
	
			case 2 -> {
				this.hangmanDrawingMatrix[3][1] = "|";
				this.hangmanDrawingMatrix[2][1] = "|";
				this.hangmanDrawingMatrix[1][1] = "|";
				this.hangmanDrawingMatrix[0][1] = "|";
			}
	
			case 3 -> {
				this.hangmanDrawingMatrix[0][2] = "-";
				this.hangmanDrawingMatrix[0][3] = "-";
				this.hangmanDrawingMatrix[0][4] = "-";
			}
	
			case 4 -> {
				this.hangmanDrawingMatrix[1][4] = "|";
				this.hangmanDrawingMatrix[2][4] = "|";
			}
	
			case 5 -> {
				this.hangmanDrawingMatrix[3][4] = "0";
				this.hangmanDrawingMatrix[4][3] = "/";
				this.hangmanDrawingMatrix[4][4] = "()";
				this.hangmanDrawingMatrix[4][5] = "\\";
				this.hangmanDrawingMatrix[5][4] = "/\\";
			}
		}
	}

	private void clearDrawing() {
		for (String[] matrixRow : this.hangmanDrawingMatrix) {
			Arrays.fill(matrixRow, " ");
		}
	}
}
