//Made by Jason Friedman
package friedman_problem1;

import java.util.Random;
import java.util.Scanner;

public class CAI5 {
	public static int TOTALQUESTIONS = 10;

	public static void main(String[] args) {
		quiz();
	}
	
	private static int SecureRandom(int largest) {
		Random rand = new Random();
		return rand.nextInt(largest);
	}
	
	public static void quiz() {
		int arithmetic = getArithmetic();
		int difficulty = getDifficulty();
		int correctAnswers = 0;
		for( int i = 1 ; i<=TOTALQUESTIONS ; i++ ) {
			int firstNum = SecureRandom((int)Math.pow(10, difficulty));
			int secondNum = SecureRandom((int)Math.pow(10, difficulty));
			int displayedArithmetic = randomizeArithmetic(arithmetic);
			while (arithmetic == 4 && secondNum == 0) {
				secondNum = SecureRandom((int)Math.pow(10, difficulty));
			}
			askQuestion(displayedArithmetic, firstNum, secondNum);
			correctAnswers = correctAnswers + isAnswerCorrect(displayedArithmetic, firstNum, secondNum);
		}
		displayCompletionMessage(correctAnswers);
		quiz();
	}
	
	public static int getArithmetic() {
		int arithmetic;
		do {
			displayArithmetic();
			
			arithmetic = readResponse();
			
			if (arithmetic <= 0 || arithmetic >= 6) {
				System.out.println("Invalid input");
			}
		} while (arithmetic <= 0 || arithmetic >= 6);
		
		return arithmetic;
	}
	
	public static void displayArithmetic() {
		System.out.println("Enter which arithmetic you want to use:\n 1 - addition\n 2 - multiplication\n 3 - subtraction\n 4 - division\n 5 - random arithmetic");
	}
	
	public static int randomizeArithmetic(int arithmetic) {
		if(arithmetic == 5) {
			return 1+SecureRandom(4);
		}
		else {
			return arithmetic;
		}
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
	
	public static void askQuestion(int arithmetic, int firstNum, int secondNum) {
		switch(arithmetic) {
			case 1:	System.out.println("How much is " + firstNum + " plus " + secondNum + "?");
					break;
			case 2:	System.out.println("How much is " + firstNum + " times " + secondNum + "?");
					break;
			case 3:	System.out.println("How much is " + firstNum + " minus " + secondNum + "?");
					break;
			case 4:	System.out.println("How much is " + firstNum + " divided by " + secondNum + "? (Round to the nearest 2 decimal points)");
					break;
		}
	}
	
	public static int readResponse() {
		Scanner scan = new Scanner(System.in);
		return scan.nextInt();
	}
	
	public static double readDoubleResponse() {
		Scanner scan = new Scanner(System.in);
		return scan.nextDouble();
	}
	
	public static int isAnswerCorrect(int arithmetic, int firstNum, int secondNum) {
		int answer = 0;
		switch(arithmetic) {
		case 1:	answer = isAdditionCorrect(firstNum, secondNum);
				break;
		case 2:	answer = isMultiplicationCorrect(firstNum, secondNum);
				break;
		case 3:	answer = isSubtractionCorrect(firstNum, secondNum);
				break;
		case 4:	answer = isDivisionCorrect(firstNum, secondNum);
				break;
		}
		return answer;
	}
	
	public static int isAdditionCorrect(int firstNum, int secondNum) {
		
		if (readResponse() == firstNum + secondNum) {
			displayCorrectResponse();
			return 1;
		}
		else {
			displayIncorrectResponse();
			return 0;
		}
	}
	
	public static int isMultiplicationCorrect(int firstNum, int secondNum) {
		
		if (readResponse() == firstNum * secondNum) {
			displayCorrectResponse();
			return 1;
		}
		else {
			displayIncorrectResponse();
			return 0;
		}
	}
	
	public static int isSubtractionCorrect(int firstNum, int secondNum) {
		
		if (readResponse() == firstNum - secondNum) {
			displayCorrectResponse();
			return 1;
		}
		else {
			displayIncorrectResponse();
			return 0;
		}
	}
	
	public static int isDivisionCorrect(int firstNum, int secondNum) {
		
		if (readDoubleResponse() == Math.round(((double)firstNum / (double)secondNum) * 100d) / 100d) {
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