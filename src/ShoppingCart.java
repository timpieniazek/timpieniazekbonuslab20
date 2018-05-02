import java.util.ArrayList;

public class ShoppingCart {
	
	public static ArrayList<Integer> shoppingCart = new ArrayList<Integer>(Menu.menu().size());
	
	public static void addItem(int index, int quantity) {
		shoppingCart.set(index, shoppingCart.get(index) + quantity);
	}

}
