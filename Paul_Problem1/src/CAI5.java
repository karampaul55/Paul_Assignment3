// Karam Paul
// Final Product Confirmed
// Attempting problem using object oriented methodology

import java.security.SecureRandom ;
import java.util.*;

//Will attempt with instance variables applications

public class CAI5 {
	//Instance Variables
	private int difficulty;
	private int type;
	private int mixedType;
	private int mixer;
	private double num1 ;
	private double num2 ;
	private double attempt;
	private double correctAnswer;
	private int check;
	private int correct;
	private static int reset = 1;
	
	//Application
	public static void main(String[] args) {
		quiz();
	}
	
	private static void quiz() 
	{
		CAI5 quiz1 = new CAI5();
		
		while(true) 
		{
			if (reset == 2) 
			{
				System.out.println("\nClosing Now...") ;
				System.exit(0);
				break;
			}
			
			//Assigning instance variables to quiz object
			quiz1.readDifficulty();
			quiz1.readProblemType();
			quiz1.correct = 0;
									
			for (int i = 0 ; i < 10; i++)
			{
				quiz1.generateQuestionArguement();
				quiz1.askQuestion();
				quiz1.correctAnswer();
				quiz1.readResponse();
				quiz1.isAnswerCorrect();
				quiz1.displayMessage();
			}
			quiz1.displayCompletionMessage();
			quiz1.restart();	
		}
	}
	
	private void readDifficulty() 
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Please select your desired difficulty:");
		System.out.println("1: Easy");
		System.out.println("2: Medium");
		System.out.println("3: Hard");
		System.out.println("4: Expert");
		int diff = in.nextInt();
		while (diff != 1 && diff != 2 && diff != 3 && diff != 4 ) {
			System.out.println("Please enter an interger between 1 and 4 inlcusive!");
			diff = in.nextInt();
		}
		this.difficulty = diff;
	}
	
	private void readProblemType()
	{
		Scanner in = new Scanner(System.in);
		System.out.println("What type of problems would you like to be asked?");
		System.out.println("1: Addition");
		System.out.println("2: Multiplication");
		System.out.println("3: Subtraction");
		System.out.println("4: Division");
		System.out.println("5: Mixed");
		type = in.nextInt();
		while (type != 1 && type != 2 && type != 3 && type != 4 && type != 5) {
			System.out.println("Please enter an interger between 1 and 5 inclusive");
			type = in.nextInt();
		}
		mixedType = type;
		this.type = type;
		this.mixedType = mixedType;
	}
	
	private void generateQuestionArguement() 
	{
		SecureRandom rdmNumber = new SecureRandom();
		switch (difficulty) 
		{
			case 1:
				num1 = rdmNumber.nextInt(10);
				num2 = rdmNumber.nextInt(10);
				break;

			case 2:
				num1 = rdmNumber.nextInt(100);
				num2 = rdmNumber.nextInt(100);
				break;

			case 3:
				num1 = rdmNumber.nextInt(1000);
				num2 = rdmNumber.nextInt(1000);
				break;

			case 4:
				num1 = rdmNumber.nextInt(10000);
				num2 = rdmNumber.nextInt(10000);
				break;
		}
	}
	
	// Will need a new method to generate the mixed question choice. Then call that method in the askQuestion method.
	private void mixedQuestion() 
	{
		SecureRandom rdm = new SecureRandom();
		mixedType = rdm.nextInt(4) + 1 ; //0-3 so need to add 1
		this.mixedType = mixedType;
		switch (mixedType)
		{
			case 1:
				System.out.println("How much is " + (int) num1 + "+" + (int) num2 + "?");
				break;
			case 2:
				System.out.println("How much is " + (int) num1 + "*" + (int) num2 + "?");
				break;
			case 3:
				System.out.println("How much is " + (int) num1 + "-" + (int) num2 + "?");
				break;
			case 4:
				System.out.println("Please note that if the division is by 0, the answer shall be 000 (implying infinity)\n");
				System.out.println("How much is " + (int) num1 + "/" + (int) num2 + "?");
				System.out.println("Please round to the nearest hundredth");
				break;	
		}
	}
	
	private void askQuestion() 
	{
		switch (type) 
		{
			case 1:
				System.out.println("How much is " + (int) num1 + " + " + (int )num2 + "?");
				break;
			case 2:
				System.out.println("How much is " + (int) num1 + " * " + (int) num2 + "?");
				break;
			case 3:
				System.out.println("How much is " + (int) num1 + " - " + (int) num2 + "?");
				break;
			case 4:
				System.out.println("Please note that if the division is by 0, the answer shall be 000 (implying infinity)\n");
				System.out.println("How much is " + (int) num1 + " / " + (int) num2 + "?");
				System.out.println("Please round to the nearest hundredth");
				break;	
			case 5:
				this.mixedQuestion();
		}
	}
	
	// Create a method to store the correct answer. This could be done in other methods
	// but a method should have a single purpose
	
	private void correctAnswer()
	{
		switch (mixedType) 
		{
			case 1:
				correctAnswer = num1 + num2 ;
				System.out.println("Testing Correct Answer: " + correctAnswer);
				break;
			case 2:
				correctAnswer = num1 * num2 ;
				System.out.println("Testing Correct Answer: " + correctAnswer);
				break;
			case 3:
				correctAnswer = num1 - num2 ;
				System.out.println("Testing Correct Answer: " + correctAnswer);
				break;
			case 4:
				//This can yield a double. Must change type to double
				if (num2 == 0)
				{
					correctAnswer = 000;
					System.out.println("Testing Correct Answer: " + correctAnswer);
					break;
				}
				else 
				{
				correctAnswer = (double) Math.round((num1 / num2) * 100)/100;
				System.out.println("Testing Correct Answer: " + correctAnswer);
				break;
				}
			case 5:
				mixedQuestion();
				break;
		}
	}
	
	
	private void readResponse() 
	{
			Scanner in = new Scanner(System.in);
			attempt = in.nextDouble();
	}
	
	private void isAnswerCorrect() 
	{
		if (attempt == correctAnswer)
		{
			correct ++ ;
			check = 1;
		}
		else 
		{
			check = 0;
		}
	}
	
	private void displayCorrectResponse() 
	{
		SecureRandom in = new SecureRandom();
		int choice = in.nextInt(4);
		switch (choice) 
		{
			case 0: 
				System.out.println("Very Good!\n");
				break;
			case 1: 
				System.out.println("Excellent!\n");
				break;
			case 2: 
				System.out.println("Nice Work!\n");
				break;
			case 3: 
				System.out.println("Keep up the good work!\n");
				break;
		}
	}
	
	private void displayIncorrectResponse() 
	{
		SecureRandom in = new SecureRandom();
		int choice = in.nextInt(4);
		
		switch (choice) 
		{
			case 0: 
				System.out.println("No. Please try again.\n");
				break;
			case 1: 
				System.out.println("Wrong. Try once more.\n");
				break;
			case 2: 
				System.out.println("Don't give up.\n");
				break;
			case 3: 
				System.out.println("No. Keep trying.\n");
				break;
		}	
	}
	
	private void displayMessage() 
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
	
	public void displayCompletionMessage() 
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
	
	private void restart() 
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Would you like to retry?\n1: Yes\n2: No");
		int reset = in.nextInt();
		while (reset != 1 && reset != 2) 
		{
			System.out.println("Please enter either 1 or 2!");
			reset = in.nextInt();
		}
		this.reset = reset;
	}
}
