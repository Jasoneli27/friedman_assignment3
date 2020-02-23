//Made by Jason Friedman
package friedman_problem2;

public class SavingsAccountTest {

	public static void main(String[] args) {
		saver1 firstSaver = new saver1();
		System.out.println(firstSaver.calculateMonthlyInterest());
		
		saver2 secondSaver = new saver2();
		System.out.println(secondSaver.calculateMonthlyInterest());
	}
	
}

class saver1 extends SavingsAccount {
	public saver1() {
		savingsBalance = 2000;
	}
}

class saver2 extends SavingsAccount {
	public saver2() {
		savingsBalance = 3000;
	}
}
