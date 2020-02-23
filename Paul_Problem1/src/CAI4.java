import java.security.SecureRandom ;
import java.util.* ;

public class CAI4 {
	
	public static void main(String[] args) {
		quiz();
	}
	
	private static void quiz() {

		int reset = 1;
		int correct = 0;
		int correctAnswer = 0;
		int num1 = 0;
		int num2 = 0;
		int check = 0;
		int attempt = 0;
		int difficulty = 0;
	
		while(reset == 1) {
			if (reset == 2) {
				System.out.println("\nClosing Now...") ;
				break;
			}
			
			difficulty = readDifficulty();
			correct = 0; 
			
			for (int i = 0 ; i<10 ; i++) {
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
		else {
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
	
	public static void displayCompletionMessage(int correct) {
		System.out.printf("\nYour grade is " + correct + "/10 \n");
		if (correct <= 7) {
			System.out.println("Please ask your teacher for help.\n");
		}
		else {
			System.out.println("Congratulations, you are ready to go to the next level!\n");
		}	
	}
	
	private static int resetOrNah() {
		Scanner user = new Scanner(System.in);
		System.out.println("Would you like to retry?\n1: Yes\n2: No");
		int reset = user.nextInt();
		while (reset != 1 && reset != 2) {
			System.out.println("Please enter either 1 or 2!");
			reset = user.nextInt();
		}
		return reset;
	}	
	
	private static int readDifficulty() {
		Scanner diff = new Scanner(System.in);
		System.out.println("Please select your desired difficulty:");
		System.out.println("1: Easy");
		System.out.println("2: Medium");
		System.out.println("3: Hard");
		System.out.println("4: Expert");
		int difficulty = diff.nextInt();
		while (difficulty != 1 && difficulty != 2 && difficulty != 3 && difficulty != 4 ) {
			System.out.println("Please enter an interger between 1 and 4 inlcusive!");
			difficulty = diff.nextInt();
		}
		return difficulty;
		
	}
	
	private static int generateQuestionArguement(int difficulty) {
		SecureRandom rdmNumber = new SecureRandom();
		switch (difficulty) {
			case 1:
				return rdmNumber.nextInt(9);
			case 2:
				return rdmNumber.nextInt(99);
			case 3:
				return rdmNumber.nextInt(999);
			case 4:
				return rdmNumber.nextInt(9999);
			default:
				return 0;
		}
	}

	
		
}


	


