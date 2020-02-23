//Made by Jason Friedman
package friedman_problem1;

import java.util.Random;
import java.util.Scanner;

public class CAI2 {

	public static void main(String[] args) {
		quiz();
	}
	
	private static int SecureRandom(int largest) {
		Random rand = new Random();
		return rand.nextInt(largest);
	}
	
	public static void quiz() {
		int firstNum = SecureRandom(10);
		int secondNum = SecureRandom(10);
		askQuestion(firstNum, secondNum);
		isAnswerCorrect(firstNum, secondNum);
	}
	
	public static void askQuestion(int firstNum, int secondNum) {
		System.out.println("How much is " + firstNum + " times " + secondNum + "?");
	}
	
	public static int readResponse() {
		Scanner scan = new Scanner(System.in);
		return scan.nextInt();
	}
	
	public static void isAnswerCorrect(int firstNum, int secondNum) {
		
		if (readResponse() == firstNum * secondNum) {
			displayCorrectResponse();
		}
		else {
			displayIncorrectResponse();
			quiz();
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
