import java.util.*;
 interface Bank_Work_interface {
	
	public double Balanse();
	public double WithDraw();
	public double Deposit();
	public boolean exitProgram();
}

 public class Bank_Work implements  Bank_Work_interface {
	public static void main(String[] args) {
		boolean h=true; 
		Scanner  Input=new Scanner(System.in);
		Bank_Work obj=new Bank_Work();
		
		while(h){
			System.out.println("\n========= Simple Banking Application ===========");
			System.out.println("Choies Offtion Below -->");
			System.out.println("1.Check Balance");
			System.out.println("2.WithDraw Amount");
			System.out.println("3.Deposit Amount");
			System.out.println("4.Exit OR Back");
			System.out.println("\nEnter Your Choies Number :");
			int Choice =Input.nextInt();
			
			switch(Choice){
			case 1:
				obj.Balanse();
			   break;
			
			case 2:
				obj.WithDraw();
			   break;
			
			case 3:
				obj.Deposit();
			   break;
			
			case 4:
				obj.exitProgram();
			   break;
			}	
		}
	}
	
	double Balance=1000;
	double Whitdraw;
	double Deposite;
	double Current_Balance;
	Scanner  Input=new Scanner(System.in);
	double Pin;
	//int digit = (int)(Math.log10(Pin))+1;
	@Override
	public double Balanse() {
		
	        System.out.println("1) Enter Account number :");
	        int AccNum=Input.nextInt();
	        System.out.println("2) Enter Pin number :");
	        double Pin=Input.nextInt();
	   
	        int digit = (int)(Math.log10(Pin))+1;
	      
	        	if ( Pin!=0&&4>=digit) {
	        	System.out.println("Verified you'r Pin Number");
              System.out.println("Account number : "+AccNum);
	        	System.out.printf("You are Current Balanse:$%.2f \n",Balance);
	        }
	        else if( 4>=digit){
	        	System.out.println("Wrong PassWord Or Pin Number\n");
	        }
	        else if( Pin==00000){
	        	System.out.println("Your PIN NUMBER is NULL Please Try Again\n");
	        }
	        else {
	        	System.out.println(" Enter Verified  Pin Number Or Try Again\n");
	        }
		return 0;
	}

	@Override
	public double WithDraw() {
		
		System.out.println("\n1) Enter Account number :");
		  double AccNum=Input.nextInt();
        System.out.println("2) Enter Pin number :");
        double Pin=Input.nextInt();
        int digit = (int)(Math.log10(Pin))+1;
        			if ( Pin!=0&&4>=digit) 
        			{
        	        System.out.println("\nHow Many WithDrawal Amount");
        	        	 double WithDraw = Input.nextDouble();
        	        	 // Cheak Extra Amount
        	        	 if(Balance>= WithDraw){
									System.out.printf("\nWithdrawal of $%.2f successful.%n", WithDraw);
        	        		 				 Current_Balance=Balance - WithDraw;
									System.out.printf("Your current balance is: $%.2f%n \n",Current_Balance);
        	        		 					System.out.println("<--------Thank You Next Time Visit Again--------->");
        	        	 }else{
        	        	  System.out.println("Insufficient funds. Withdrawal cancelled.\n");
        	        	 }
        			}else if( Pin==00000||4>=digit){
        							System.out.println("Your PIN NUMBER is NULL Please Try Again \n");
        			}else{
        							System.out.println(" Enter Verified  Pin Number Or Try Again \n");
        			}
		return 0;
	}

	@Override
	public double Deposit() {
		System.out.println("\n1) Enter Account number :");
        double AccNum=Input.nextInt();
        System.out.println("2) Enter Pin number :");
        double Pin=Input.nextInt();
        
        int digit = (int)(Math.log10(Pin))+1;
        
        	if ( Pin!=0&&4>=digit) {
        		System.out.println("\nHow Many Deposit Amount:");
	        	 double Deposite = Input.nextDouble();
	        	  				Current_Balance= Balance +Deposite;
					System.out.printf("******Yor are Amount Deposit of $%.2f successful.%n ****** \n",Current_Balance);
	        	 // System.out.println("Current Balance Is:"+ Current_Balance);
					System.out.println("<-------- Thank You , Next Time Visit Again -------->");
        }
        else if( 4>=digit){
        	System.out.println("Wrong PassWord Or Pin Number");
        }
        else if( Pin==00000){
        	System.out.println("Your PIN NUMBER is NULL Please Try Again");
        }
        else {
        	System.out.println(" Enter Verified  Pin Number. Or Try Again & Invalid deposit amount. Please enter a positive number.");
        }
		return 0;
	}
	@Override
	public boolean exitProgram() {
		System.out.println("Thank you for using Simple Banking Application. Goodbye!");
		return true;
  }
}