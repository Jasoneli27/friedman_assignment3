//Made by Jason Friedman
package friedman_problem1;

import java.util.Random;
import java.util.Scanner;

public class CAI1 {

	public static void main(String[] args) {
		quiz();
	}
	
	private static int SecureRandom() {
		Random rand = new Random();
		return rand.nextInt(10);
	}
	
	public static void quiz() {
		int firstNum = SecureRandom();
		int secondNum = SecureRandom();
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
		System.out.println("Very good!");
	}
	
	public static void displayIncorrectResponse() {
		System.out.println("No. Please try again.");
	}
}
