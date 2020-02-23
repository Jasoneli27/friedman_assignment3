//Made by Jason Friedman
package friedman_problem1;

import java.util.Random;
import java.util.Scanner;

public class CAI3 {

	public static void main(String[] args) {
		quiz();
	}
	
	private static int SecureRandom(int largest) {
		Random rand = new Random();
		return rand.nextInt(largest);
	}
	
	public static void quiz() {
		int correctAnswers = 0;
		for( int i = 1 ; i<=10 ; i++ ) {
			int firstNum = SecureRandom(10);
			int secondNum = SecureRandom(10);
			askQuestion(firstNum, secondNum);
			correctAnswers = correctAnswers + isAnswerCorrect(firstNum, secondNum);
		}
		displayCompletionMessage(correctAnswers);
		quiz();
	}
	
	public static void displayCompletionMessage(int correctAnswers) {
		System.out.println("You scored a " + correctAnswers + " out of 10.");
		if ( correctAnswers < 8 ) {
			System.out.println("Please ask your teacher for extra help.\n\n");
		}
		else {
			System.out.println("Congratulations, you are ready to go to the next level!\n\n");
		}
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
}
