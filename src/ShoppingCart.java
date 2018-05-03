import java.util.ArrayList;

public class ShoppingCart {
	
	public static ArrayList<String> items = new ArrayList<String>();
	public static ArrayList<Double> prices = new ArrayList<Double>();
	public static ArrayList<Integer> quantities = new ArrayList<Integer>();
	
	public static void addToCart(String item, int quantity) {
		
		items.add(item);
		quantities.add(quantity);
		prices.add(Menu.menu().get(item) * quantity);
	}
	
	public static void addToCart(int index, String item, int quantity) {
		quantities.set(index, quantities.get(index) + quantity);
		prices.set(index, prices.get(index) + Menu.menu().get(item) * quantity);
	}
	


}
