import java.security.SecureRandom ;
import java.util.* ;

public class CAI3 {
	
	public static void main(String[] args) {
		quiz();
	}
	
	private static void quiz() {

		int reset = 1;
		
		while(true) {
			int correct = 0;
			if (reset == 2) {
				System.out.println("\nClosing Now...") ;
				break;
			}
			
			for (int i = 0 ; i<10 ; i++) {
				SecureRandom rdmNumber = new SecureRandom();
				int num1 = rdmNumber.nextInt(9);
				int num2 = rdmNumber.nextInt(9);
				int correctAnswer = num1 * num2 ;
				askQuestion(num1,num2);
				int check = 0;
				int attempt = readResponse();
				check = isAnswerCorrect(correctAnswer, attempt);
				if (check == 1) {
					correct++ ;
				}
	
				displayMessage(check);
			}
			grade(correct);
			reset = resetOrNah();
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
			System.out.println("Very Good!");
	}
	
	private static void displayIncorrectResponse() {
			System.out.println("No. Please try again.");	
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
	
	public static void grade(int correct)
	{
		System.out.printf("\nYour grade is " + correct + "/10 \n");
		if (correct <= 7) {
			System.out.println("Please ask your teacher for help.\n");
		}
		else {
			System.out.println("Congratulations, you are ready to go to the next level!\n");
		}	
	}
	
	private static int resetOrNah() {
		System.out.println("Would you like to retry?\n1: Yes\n2: No");
		Scanner reset = new Scanner(System.in);
		return reset.nextInt();
	}	
}
	


