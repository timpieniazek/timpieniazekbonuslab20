import java.util.HashMap;

public class Menu {

	public static HashMap<String, Double> menu = new HashMap<String, Double>();
	
	public static String specifier = "%-25s %s%n";

	public static HashMap<String, Double> menu() {
		menu.put("Babyback Ribs", 54.99);	
		menu.put("St. Louis Style Ribs", 48.99);
		menu.put("Assorted Chicken Wings", 47.99) ;
		menu.put("Chicken Breast, tenders", 33.99);
		menu.put("Turkey Legs, frozen", 35.99);
		menu.put("Halibut, frozen", 44.99);
		menu.put("Pork Butt", 68.99);
		menu.put("Whole Turkey, frozes", 58.99);
		menu.put("Beef Brisket", 71.99);
		return menu;
	}
	
	public static void display() {
		System.out.printf(specifier, "Products:", "Price:");
		
		HashMap<String,Double> products = Menu.menu();
		for (String product : products.keySet()) {
			System.out.printf(specifier, " " + product, " " + products.get(product));
		}
	}
}
