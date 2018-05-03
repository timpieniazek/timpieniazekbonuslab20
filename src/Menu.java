import java.util.ArrayList;
import java.util.HashMap;

public class Menu {

	public static HashMap<String, Double> menu = new HashMap<String, Double>();

//	public static ArrayList<String> keys = new ArrayList<String> ((String[]) menu().keySet().toArray()).to;
	
	public static String specifier = "%-12s %s%n";

	public static HashMap<String, Double> menu() {
		menu.put("Ribs", 54.99);	
		menu.put("Pork", 48.99);
		menu.put("Brisket", 47.99) ;
		menu.put("Chicken", 33.99);
		menu.put("Turkey", 35.99);
		menu.put("Halibut", 44.99);
		menu.put("Pork", 68.99);
		menu.put("Turkey", 58.99);
//		menu.put("Beef Brisket", 71.99);
		return menu;
	}
	
	public static void display() {
		System.out.printf(specifier, "Product:", "Price per Item:");
		
		HashMap<String,Double> products = menu();
		for (String product : products.keySet()) {
			System.out.printf(specifier, " " + product, " " + products.get(product));
		}
		System.out.println();
	}
	
	public static boolean validItem(String item) {
		if (menu().containsKey(item)) {
			return true;
		}
		return false;
	}
}
