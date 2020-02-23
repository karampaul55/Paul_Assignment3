// Karam Paul
// Final Product Confirmed

import java.security.SecureRandom ;
import java.util.* ;

public class CAI4 {
	
	public static void main(String[] args) {
		quiz();
	}
	
	private static void quiz() 
	{

		int reset = 1;
		int correct = 0;
		int correctAnswer = 0;
		int num1 = 0;
		int num2 = 0;
		int check = 0;
		int attempt = 0;
		int difficulty = 0;
	
		while(true) 
		{
			if (reset== 2) 
			{
				System.out.println("\nClosing Now...") ;
				System.exit(0);
				break;
			}
			
			difficulty = readDifficulty();
			correct = 0; 
			
			for (int i = 0 ; i<10 ; i++) 
			{
				num1 = generateQuestionArguement(difficulty);
				num2 = generateQuestionArguement(difficulty);

				correctAnswer = num1 * num2 ;
				askQuestion(num1,num2);
				check = 0;
				attempt = readResponse();
				check = isAnswerCorrect(correctAnswer, attempt);
				if (check == 1) {
					correct++ ;
				}
				displayMessage(check);
			}
			displayCompletionMessage(correct);
			reset = restart();
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
		if (correctAnswer == attempt) 
		{
			return 1;
		}
		else 
		{
			return 0;
		}
	}
	
	private static void displayCorrectResponse() 
	{
		SecureRandom correctChoice = new SecureRandom();
		int choice1 = correctChoice.nextInt(4);
		
		switch (choice1) 
		{
			case 0: 
				System.out.println("Very Good!");
				break;
			case 1: 
				System.out.println("Excellent!");
				break;
			case 2: 
				System.out.println("Nice Work!");
				break;
			case 3: 
				System.out.println("Keep up the good work!");
				break;
		}
	}
	
	private static void displayIncorrectResponse() 
	{
		SecureRandom incorrectChoice = new SecureRandom();
		int choice2 = incorrectChoice.nextInt(4);
		
		switch (choice2) 
		{
			case 0: 
				System.out.println("No. Please try again.");
				break;
			case 1: 
				System.out.println("Wrong. Try once more.");
				break;
			case 2: 
				System.out.println("Don't give up.");
				break;
			case 3: 
				System.out.println("No. Keep trying.");
				break;
		}	
	}
	
	//added method to simply quiz logic
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
	
	public static void displayCompletionMessage(int correct) 
	{
		System.out.printf("\nYour grade is " + correct + "/10 ");
		System.out.println("(" + Integer.toString(correct*10)+"%)");
		if (correct <= 7) 
		{
			System.out.println("Please ask your teacher for help.\n");
		}
		else 
		{
			System.out.println("Congratulations, you are ready to go to the next level!\n");
		}	
	}
	
	private static int restart() 
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Would you like to retry?\n1: Yes\n2: No");
		int reset = in.nextInt();
		while (reset != 1 && reset != 2) {
			System.out.println("Please enter either 1 or 2!");
			reset = in.nextInt();
		}
		return reset;
	}	
	
	private static int readDifficulty() 
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Please select your desired difficulty:");
		System.out.println("1: Easy");
		System.out.println("2: Medium");
		System.out.println("3: Hard");
		System.out.println("4: Expert");
		int difficulty = in.nextInt();
		while (difficulty != 1 && difficulty != 2 && difficulty != 3 && difficulty != 4 ) 
		{
			System.out.println("Please enter an interger between 1 and 4 inlcusive!");
			difficulty = in.nextInt();
		}
		return difficulty;
		
	}
	
	private static int generateQuestionArguement(int difficulty) 
	{
		SecureRandom rdmNumber = new SecureRandom();
		switch (difficulty) 
		{
			case 1:
				return rdmNumber.nextInt(10);
			case 2:
				return rdmNumber.nextInt(100);
			case 3:
				return rdmNumber.nextInt(1000);
			case 4:
				return rdmNumber.nextInt(10000);
			default:
				return 0;
		}
	}	
}


	


