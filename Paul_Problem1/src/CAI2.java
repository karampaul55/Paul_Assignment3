import java.security.SecureRandom ;
import java.util.* ;

public class CAI2 {
	
	public static void main(String[] args) {
		quiz();
	}
	
	/* The quiz should generate two random numbers. It should also store the correct answer. 
	 *Then read in the users answer. Compare the two and display message. 
	 *The user should repeat until the correct answer is found. */
	private static void quiz() {
		SecureRandom rdmNumber = new SecureRandom();
		int num1 = rdmNumber.nextInt(9);
		int num2 = rdmNumber.nextInt(9);
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
	private static void askQuestion(int num1 , int num2) {
		System.out.println("How much is " + num1 + " times " + num2 + "?"  );
	}
	
	// Read in the users attempt
	private static int readResponse() {
		Scanner response = new Scanner(System.in);
		return response.nextInt();
	}
	
	// compare with the known correct answer. Should take in the correct answer and the users attempt
	private static int isAnswerCorrect(int correctAnswer , int attempt) {
		if (correctAnswer == attempt) {
			
			return 1;
		}
		else
		{
			return 0;
		}
	}
	
	private static void displayCorrectResponse() {
		SecureRandom correctChoice = new SecureRandom();
		int choice1 = correctChoice.nextInt(4);
		
		switch (choice1) {
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
	
	private static void displayIncorrectResponse() {
		SecureRandom incorrectChoice = new SecureRandom();
		int choice2 = incorrectChoice.nextInt(4);
		
		switch (choice2) {
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
	private static void displayMessage(int check) {
		if (check == 1) {
			displayCorrectResponse();
		}
		else {
			displayIncorrectResponse();
		}
	}
}


