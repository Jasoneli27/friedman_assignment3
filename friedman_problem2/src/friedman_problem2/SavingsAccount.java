//Made by Jason Friedman
package friedman_problem2;

public class SavingsAccount {

	private static double annualInterestRate = 0.04;
	double savingsBalance;
	
	public SavingsAccount() {
		this.savingsBalance = savingsBalance;
	}
	
	public double getSavingsBalance() {
		return savingsBalance;
	}
	
	public double calculateMonthlyInterest() {
		return (this.getSavingsBalance() * annualInterestRate)/12;
	}
}
