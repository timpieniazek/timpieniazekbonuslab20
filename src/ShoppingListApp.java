import java.util.HashMap;
import java.util.Scanner;

// Tim Pieniazek -- Bonus Lab 20
// 05/01/2018 -- timpieniazek@github

public class ShoppingListApp {
	
	public static String specifier = "%-12s %-12s %-12s %s%n";

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		// creates a ShoppingCart object to store this user's current order
		ShoppingCart cart = new ShoppingCart();
		String newItem;
		int newQuantity;
		String cont = "y";

		System.out.println("Welcome to Northern Haserot!\n");

		Menu.display();
		
		// while loop to take user input until they indicate they are done
		while (cont.equalsIgnoreCase("y")) {

			placeOrder(cart);

			System.out.print("\nWould you like to place another order (y/n)? ");
			cont = scan.next();
			System.out.println();
		}
		
		// after done ordering, displays the ShoppingCart elements
		displayCart(cart);
		
//		System.out.println(cart.prices);
//		System.out.println(cart.items);
//		System.out.println(cart.quantities);
		if (!cart.prices.isEmpty()) {
			System.out.printf("%nAverage item price is $%s.%n", meanPrice(cart));
			
			int highIndex = indexOfHighestPrice(cart);
			String highItem = cart.items.get(highIndex);
			System.out.printf("%nHighest total price is %s at $%s.%n", highItem,
					Menu.menu().get(highItem)* cart.quantities.get(highIndex));
			
			int lowIndex = indexOfLowestPrice(cart);
			String lowitem = cart.items.get(lowIndex);
			System.out.printf("%nLowest total price is %s at $%s.%n", lowitem,
					Menu.menu().get(lowitem) * cart.quantities.get(lowIndex));
		}
		
		System.out.println("\nThank you for your order!\nGoodBye!");

	}

	
	public static void placeOrder(ShoppingCart cart) {
		String newItem;
		int newQuantity;
		newItem = User.inputItem("What item would you like to order? ");

		if (Menu.validItem(newItem)) {

			newQuantity = User.inputQuantity("How many would you like to add? ");

			if (cart.items.contains(newItem)) {
				cart.addToCart(cart.items.indexOf(newItem), newItem, newQuantity);

			} else {
				cart.addToCart(newItem, newQuantity);
			}

			double price = Menu.menu().get(newItem);
			System.out.printf("You added %s %s to your order,%nat $%s each for a total of $%s.%n", newQuantity, newItem, price, price * newQuantity);

		}
	}

	public static void displayCart(ShoppingCart cart) {
		System.out.println("::Shopping Cart::");
		System.out.printf(specifier, "Items:", "Total price:", "Quantity:", "Price per item:");

		for (int i = 0; i < cart.items.size(); i++) {
			System.out.printf(specifier, " " + cart.items.get(i),
					" " + cart.prices.get(i),
					" " + cart.quantities.get(i),
					" " + Menu.menu().get(cart.items.get(i)));
		}
		
		System.out.println(":::::::::::::::::");
				
//		for (String item : cart.items) {
//			
//		}
	}
	
	public static double meanPrice(ShoppingCart cart) {
		double totalPrice = 0.0;
		for (double price: cart.prices) {
			totalPrice += price;
		}
		return totalPrice / cart.prices.size();
	}
	
	public static int indexOfHighestPrice(ShoppingCart cart) {
		int index = 0;
		for (int i = 0; i < cart.prices.size(); i++) {
			if (cart.prices.get(index) * cart.quantities.get(index)
					< cart.prices.get(i) * cart.quantities.get(i)) {
				index = i;
			}
		}
		return index;
	}
	
	public static int indexOfLowestPrice(ShoppingCart cart) {
		int index = 0;
		for (int i = 0; i < cart.prices.size(); i++) {
			if (cart.prices.get(index) * cart.quantities.get(index)
					> cart.prices.get(i) * cart.quantities.get(i)) {
				index = i;
			}
		}
		return index;
	}
}
