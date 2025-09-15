// NO CHANGES YET
import java.util.Scanner;
/*
*  here i removed @author Yogesh
*/
class HDFCBankApplication{

	private static Scanner scanner;
	private int PIN = 7009;

	public static void main(String [] args){
		scanner = new Scanner(System.in);
		HDFCBankApplication application = new HDFCBankApplication();
		
		System.out.println("Enter your salary ");
		double salary = scanner.nextDouble();
		
		System.out.println("Enter minimum balance");
		double minBal = scanner.nextDouble();
		
		boolean isCustomerEligible =  application.isCustomerEligibleForLoan(salary, minBal);
		
		if(isCustomerEligible){
			System.out.println("Customer is eligible for loan");
		}else{
			System.out.println("Customer is not eligible for loan");
		}
		
		application.validateATMPin();
	
	}
	
	/*
	* 	Check whether a customer is eligible for a loan based on: 
	*		 Minimum balance of ₹20,000. 
	*		 Salary greater than ₹30,000. 
	*	Display appropriate messages for eligibility or rejection.
	*/
	public boolean isCustomerEligibleForLoan(double salary, double minBal){
		
		if(salary > 30000 && minBal >= 20000){
			return true;
		}else{
			return false;
		}
	}
	
	/*
	*   Allow the customer a maximum of 3 attempts to enter the correct 
	*	ATM PIN. 
	*	If the PIN is correct, allow access to the banking menu. 
	*   If incorrect after 3 attempts, block the card and display a warning 
	*	message. 
	*/
	public boolean validateATMPin(){
		
		int count = 1;
		
		while(count <= 3){
			System.out.print("Enter pin - ");
			int userPin = scanner.nextInt();
			
			if(userPin == PIN){
				displayMenu();
				return true;
			}else{
				System.out.println("Wrong PIN, try again...");
				count++;
			}
		}
		
		if(count > 3){
			System.out.println("You have exceeded maximum PIN attempts. Account locked!");
		}
		return false;
	}
	/*
	*  	After successful login, display the following menu: 
	*	 1. Check Balance   
	*	 2. Deposit Money   
	*	 3. Withdraw Money   
	*	 4. Exit   
	*	 Perform the respective operations based on the customer’s choice. 
	*	 Ensure sufficient balance checks during withdrawal. 
	*	 Exit the application when the user chooses option 4. 
	*/
	public boolean displayMenu(){
		while (true){
			System.out.println("-----------------------------------");
			System.out.println("Select From menu");
			System.out.println("1. Check Balance");
			System.out.println("2. Deposit Money");
			System.out.println("3. Withdraw Money");
			System.out.println("4. Exit");
			System.out.println("-----------------------------------");
			
			System.out.println("Enter your choice -");
			int choice = scanner.nextInt();
			
			switch(choice){
				case 1 : System.out.println(" You selected - Check Balance");
						 break;
				
				case 2 : System.out.println(" You selected - Deposit Money");
						 break;
				
				case 3 : System.out.println(" You selected - Withdraw Money");
						 break;
				
				case 4 : System.out.println(" You selected - Exit");
						 return false;
						 
				default : System.out.println("You selected - wrong choice");
				
			}
		}
		
	}
}