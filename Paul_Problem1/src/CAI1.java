//Karam Paul
//Final Product Confirmed

import java.security.SecureRandom ;
import java.util.* ;

public class CAI1 {
	
	public static void main(String[] args) 
	{
		quiz();
	}
	
	/* The quiz should generate two random numbers. It should also store the correct answer. 
	 *Then read in the users answer. Compare the two and display message. 
	 *The user should repeat until the correct answer is found. */
	private static void quiz() 
	{
		SecureRandom rdmNumber = new SecureRandom();
		int num1 = rdmNumber.nextInt(10);
		int num2 = rdmNumber.nextInt(10);
		int correctAnswer = num1 * num2;
		int check = 0;
		
		askQuestion(num1,num2);
		while (check == 0)
		{
			int attempt = readResponse();
			check = isAnswerCorrect(correctAnswer , attempt);
			displayMessage(check);
		}
	}
	
	// This function should take in the two randomly generated integers
	private static void askQuestion(int num1 , int num2) 
	{
		System.out.println("How much is " + num1 + " times " + num2 + "?"  );
	}
	
	// Read in the users attempt
	private static int readResponse() 
	{
		Scanner in = new Scanner(System.in);
		return in.nextInt();
	}
	
	// compare with the known correct answer. Should take in the correct answer and the users attempt
	private static int isAnswerCorrect(int correctAnswer , int attempt) 
	{
		if (correctAnswer == attempt) {
			
			return 1;
		}
		else
		{
			return 0;
		}
	}
	
	// Exit after this is completed
	private static void displayCorrectResponse() 
	{
			System.out.println("Very Good!");
			System.out.println("System exitting...");
			System.exit(0);
	}
	
	private static void displayIncorrectResponse() 
	{
			System.out.println("No. Please try again.");	
	}
	
	//added method to simplify quiz logic
	private static void displayMessage(int check) 
	{
		if (check == 1) 
		{
			displayCorrectResponse();
		}
		else 
		{
			displayIncorrectResponse();
		}
	}
	
	
	
}


