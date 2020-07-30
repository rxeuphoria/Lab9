import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.HashMap;

public class GCLab9 {
	
	private static Scanner scnr;
	private static Map<String,Double> menu = new TreeMap<String, Double>();
	private static ArrayList<Double> cart = new ArrayList<Double>();
	public static ArrayList<String> keyList = new ArrayList<String>(menu.keySet());
    public static ArrayList<Double> valueList = new ArrayList<Double>(menu.values());
    
	
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int cartSize = 0;
		char orderPrompt = 'y';
		fillMenuMap();
		System.out.println("Welcome to Fruit n Scoot!");
		printMenu();
		
		while (orderPrompt != 'n') {
			
				System.out.println("Type your selection to add to cart.");
				String selection = scnr.nextLine();
				if (menu.containsKey(selection)) {
				System.out.println(menu.get(selection));
				cart.add(menu.get(selection));
				System.out.println(cart);
				System.out.println("Would you like anything else? (y/n)");
				String orderPromptIn = scnr.nextLine();
				orderPrompt = orderPromptIn.charAt(0);
				} else {
					System.out.println("Invalid selection.");
				}
		}
		
		System.out.println("Your total is " + findSum(cart));
		
		System.out.println("Average price in the order was " + findAverage(cart));
		
		System.out.println("Most expensive item is item #" + findIndexMax(cart));
		
		System.out.println("Least expensive item is item #" + findIndexMin(cart));

	}
	
	
	
	
	private static void fillMenuMap() {
		menu.put("apple", 0.70);
		menu.put("banana", 0.50);
		menu.put("orange", 0.57);
		menu.put("kiwi", 1.29);
		menu.put("berries", 2.32);
		menu.put("tomato", 1.69);
		menu.put("lemon", 0.64);
		menu.put("lime", 0.43);
	}
	
	private static void printMenu() {
		System.out.println("Item \t|\tPrice");
		System.out.println("----------------------");
		Set<Map.Entry<String, Double>> entries = menu.entrySet();
			for (Map.Entry<String, Double> entry : entries) {
				System.out.print(entry.getKey()+"\t\t");
				System.out.println(entry.getValue());
		}
	}
		
	private static double findAverage(ArrayList<Double> cart) {
			double total = 0;
			double average = 0;
			for (double item : cart) {
				total = total + item;
			}
			average = (total / cart.size());
			return average;
	}
	 private static double findSum(ArrayList<Double> cart) {
		 	double sum = 0;
		 for (double item : cart) {
			 sum = sum + item;
		 }
		 return sum;
	 }
	 
	 private static int findIndexMax(ArrayList<Double> cart) {
		 double max = cart.get(0);
		 for (double item : cart) {
			 if (item > max) {
				 max = item;
			 }
		 }
		 return (cart.indexOf(max) + 1);
		 
	 }
	 
	 private static int findIndexMin(ArrayList<Double> cart) {
		 double min = cart.get(0);
		 for (double item : cart) {
			 if (item < min) {
				 min = item;
			 }
		 }
		 return (cart.indexOf(min));
	 }
}
