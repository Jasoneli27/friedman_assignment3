//Made by Jason Friedman
package friedman_problem1;

import java.util.Random;
import java.util.Scanner;

public class CAI4 {
	public static int TOTALQUESTIONS = 10;

	public static void main(String[] args) {
		quiz();
	}
	
	private static int SecureRandom(int largest) {
		Random rand = new Random();
		return rand.nextInt(largest);
	}
	
	public static void quiz() {
		int difficulty = getDifficulty();
		int correctAnswers = 0;
		for( int i = 1 ; i<=TOTALQUESTIONS ; i++ ) {
			int firstNum = SecureRandom((int)Math.pow(10, difficulty));
			int secondNum = SecureRandom((int)Math.pow(10, difficulty));
			askQuestion(firstNum, secondNum);
			correctAnswers = correctAnswers + isAnswerCorrect(firstNum, secondNum);
		}
		displayCompletionMessage(correctAnswers);
		quiz();
	}
	
	public static int getDifficulty() {
		int difficulty;
		do {
			displayDifficulty();
			
			difficulty = readResponse();
			
			if (difficulty <= 0 || difficulty >= 5) {
				System.out.println("Invalid input");
			}
		} while (difficulty <= 0 || difficulty >= 5);
		
		return difficulty;
	}
	
	public static void displayDifficulty() {
		System.out.println("Enter a difficulty:\n 1 - single digit numbers\n 2 - double digit numbers\n 3 - triple digit numbers\n 4 - quadruple digit numbers");
	}
	
	public static void askQuestion(int firstNum, int secondNum) {
		System.out.println("How much is " + firstNum + " times " + secondNum + "?");
	}
	
	public static int readResponse() {
		Scanner scan = new Scanner(System.in);
		return scan.nextInt();
	}
	
	public static int isAnswerCorrect(int firstNum, int secondNum) {
		
		if (readResponse() == firstNum * secondNum) {
			displayCorrectResponse();
			return 1;
		}
		else {
			displayIncorrectResponse();
			return 0;
		}
	}

	public static void displayCorrectResponse() {
		switch (1 + SecureRandom(4)) {
			case 1:	System.out.println("Very good!");
					break;
			case 2:	System.out.println("Excellent!");
					break;
			case 3:	System.out.println("Nice work!");
					break;
			case 4:	System.out.println("Keep up the good work!");
					break;
			default:System.out.println("error, error, Jason messed everything up");
					break;
		}
	}
	
	public static void displayIncorrectResponse() {
		switch (1 + SecureRandom(4)) {
		case 1:	System.out.println("No. Please try again.");
				break;
		case 2:	System.out.println("Wrong. Try once more.");
				break;
		case 3:	System.out.println("Don’t give up!");
				break;
		case 4:	System.out.println("No. Keep trying.");
				break;
		default:System.out.println("error! error! Jason messed everything up!");
				break;
		}
	}
	
	public static void displayCompletionMessage(int correctAnswers) {
		System.out.println("You scored a " + correctAnswers + " out of 10.");
		if ( correctAnswers < TOTALQUESTIONS * 0.75 ) {
			System.out.println("Please ask your teacher for extra help.\n\n");
		}
		else {
			System.out.println("Congratulations, you are ready to go to the next level!\n\n");
		}
	}
}
