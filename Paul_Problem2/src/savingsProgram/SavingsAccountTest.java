//Karam Paul
// Final Product Confirmed

package savingsProgram;


public class SavingsAccountTest {
	
	public static void main(String[] args) 
	{
		
	SavingsAccount saver1, saver2  ; //Instantiating two objects 
	saver1 = new SavingsAccount();
	saver2 = new SavingsAccount();
	
	// set balances
	saver1.setSavingsBalance(2000.0);
	saver2.setSavingsBalance(3000.0);

	
	// Set interest rate
	SavingsAccount.modifyInterestRate(0.04);
	System.out.println("For an interest rate of 4% ...\n");
	System.out.println("Month\tSaver1\t\tSaver2");
	
	for (int i=1 ; i <13 ; i++)
		{
			saver1.calculateMonthlyInterest();
			saver2.calculateMonthlyInterest();
			System.out.print(i);
			System.out.print("\t");
			System.out.printf("%.2f", saver1.getSavingsBalance());
			System.out.print("\t\t");
			System.out.printf("%.2f", saver2.getSavingsBalance());
			System.out.println();
		}
	System.out.print("\n\n");
	
	SavingsAccount.modifyInterestRate(0.05);
	System.out.println("For an interest rate of 5% ...\n");
	System.out.println("Month\tSaver1\t\tSaver2");
	
	for (int i=1 ; i <13 ; i++)
		{
			saver1.calculateMonthlyInterest();
			saver2.calculateMonthlyInterest();
			System.out.print(i);
			System.out.print("\t");
			System.out.printf("%.2f", saver1.getSavingsBalance());
			System.out.print("\t\t");
			System.out.printf("%.2f", saver2.getSavingsBalance());
			System.out.println();
		}




	}
}
