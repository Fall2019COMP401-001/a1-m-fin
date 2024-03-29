package a1;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class A1Jedi {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// Your code follows here.

		//Initialize map that associates food with the number of customers who bought it and quantity purchased
		TreeMap<String, int[]> treeMap = new TreeMap<>();

		//Get number of unique items
		int numberOfUniqueItems = scan.nextInt();

		//Add each item to map
		for (int i = 0; i < numberOfUniqueItems; i++) {
			String name = scan.next();
			scan.nextDouble();

			int[] array = {0, 0};
			//Name of item, {number of customers who bought item, number of item bought}
			treeMap.put(name, array);
		}

		//Get number of customers
		int numberOfCustomers = scan.nextInt();

		//Iterate for each customer
		for (int i = 0; i < numberOfCustomers; i++) {
			//Skip over customer name, not needed
			scan.next(); scan.next();

			//Get number of items of customer
			int numberOfItems = scan.nextInt();

			//List keeps track of what items each customer has already bought
			List<String> customerList = new ArrayList<String>();

			//Add items stats to map
			for (int j = 0; j < numberOfItems; j++) {
				int quantityOfItem = scan.nextInt();
				String nameOfItem = scan.next();

				//Add to # of customers who bought item, if it's not a duplicate
				if (!customerList.contains(nameOfItem)) {
					treeMap.get(nameOfItem)[0] += 1;
					customerList.add(nameOfItem);
				}

				//Add quantity of item bought to map
				treeMap.get(nameOfItem)[1] += quantityOfItem;
			}
		}

		scan.close();

		//Print items bought
		for (Map.Entry<String, int[]> entry : treeMap.entrySet()) {
			String name = entry.getKey();
			int numCustomers = entry.getValue()[0];
			int quantity = entry.getValue()[1];

			if (numCustomers == 0) {
				System.out.println("No customers bought " + name);
			}
			else {
				System.out.println(numCustomers + " customers bought " + quantity + " " + name);
			}
		}
	}
}