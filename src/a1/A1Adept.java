package a1;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		
		//Declare maps that store food&price and customer&total cost
		HashMap<String, Double> foodMap = new HashMap<>();
		HashMap<String, Double> customerMap = new HashMap<>();
		
		//Declare highest and lowest total cost for later
		double highestTotalCost = Integer.MIN_VALUE; double lowestTotalCost = Integer.MAX_VALUE;
		String biggestCustomer = ""; String smallestCustomer = "";
		
		//Declare totalTotalCost
		double totalTotalCost = 0;
		
		//Get number of unique items
		int numberOfUniqueItems = scan.nextInt();
		
		//Get price of each item
		for (int i = 0; i < numberOfUniqueItems; i++) {
			String name = scan.next();
			double price = scan.nextDouble();
			
			foodMap.put(name, price);
		}
		
		//Get number of customers
		int numberOfCustomers = scan.nextInt();
		
		//Iterate for each customer
		for (int i = 0; i < numberOfCustomers; i++) {
			//Get name of customer
			String firstName = scan.next();
			String lastName = scan.next();
			
			//Get number of items of customer
			int numberOfItems = scan.nextInt();
			
			double totalCustomerCost = 0;
			
			//Add total cost of each item to customer's total cost
			for (int j = 0; j < numberOfItems; j++) {
				int quantityOfItem = scan.nextInt();
				String nameOfItem = scan.next();
				
				double priceOfItem = foodMap.get(nameOfItem);
				
				totalCustomerCost += priceOfItem * quantityOfItem;
			}
			
			//Add customer to map
			customerMap.put(firstName + lastName, totalCustomerCost);
			
			//Find if customer has higher or lower total cost than previous customers
			if (totalCustomerCost > highestTotalCost) {
				highestTotalCost = totalCustomerCost;
				biggestCustomer = firstName + " " + lastName;
			}
			else if (totalCustomerCost < lowestTotalCost) {
				lowestTotalCost = totalCustomerCost;
				smallestCustomer = firstName + " " + lastName;
			}
			
			//Add customer's total cost to totalTotalCost
			totalTotalCost += totalCustomerCost;
		}
		
		//Print results
		System.out.println("Biggest: " + biggestCustomer + " (" + String.format( "%.2f", highestTotalCost) + ")");
		System.out.println("Smallest: " + smallestCustomer + " (" + String.format( "%.2f", lowestTotalCost) + ")");
		System.out.println("Average: " + String.format( "%.2f", (totalTotalCost / numberOfCustomers)));
	}
	
}