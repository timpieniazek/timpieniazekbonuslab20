import java.util.ArrayList;
import java.util.Scanner;

public class User {
	
	public static Scanner scan = new Scanner(System.in);
	
	public static String inputItem(String prompt) {
		System.out.println(prompt);
		String input = scan.nextLine();
		
		if (Menu.validItem(input)) {
			return input;
		}
		
		return inputItem("Sorry, we don't have that item. Please try again.. ");
		
	}
	
	public static int inputQuantity(String prompt) {
		int i = 0;
		boolean isValid = false;
		while (isValid == false) {
			System.out.println(prompt);
			if (scan.hasNextInt()) {
				i = scan.nextInt();
				isValid = true;
			} else {
				System.out.print("\nError! Invalid integer value. Try again. ");
			}
			scan.nextLine(); // discard any other data entered on the line
		}
		return i;
		
	}
	
	
	

}
