//Karam Paul
// Final Product Confirmed
package savingsProgram;

public class SavingsAccount {
	
	//Instance Variables
	private static double annualInterestRate = 0;
	private double savingsBalance;
	
	// Will do for 12 months
	public void calculateMonthlyInterest() 
	{
		this.savingsBalance += (getSavingsBalance() * annualInterestRate) / 12 ;

	}
	
	public static void modifyInterestRate(double interestRate)
	{
		annualInterestRate = interestRate ;
	}
	
	// getters and setters
	public double getSavingsBalance()
	{
		return savingsBalance;
	}
	
	public void setSavingsBalance(double savingsBalance)
	{
		this.savingsBalance = savingsBalance;
	}
	
	public static double getAnnualInterestRate()
	{
		return annualInterestRate;
	}
}
