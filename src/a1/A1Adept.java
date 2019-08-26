package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		
		int numberOfCustomers = scan.nextInt();
		
		String customers[] = new String[numberOfCustomers];
		
		for (int i = 0; i < numberOfCustomers; i++) {
			String firstInitial = scan.next().substring(0,1);
			String lastName = scan.next();
			int numberOfItems = scan.nextInt();
			
			double totalCustomerCost = 0;
			for (int j = 0; j < numberOfItems; j++) {
				int quantityOfItem = scan.nextInt();
				String item = scan.next();
				double costOfItem = scan.nextDouble();
				
				double totalItemCost = quantityOfItem * costOfItem;
				
				totalCustomerCost += totalItemCost;
			}
			
			customers[i] = firstInitial + ". " + lastName + ": " + String.format( "%.2f", totalCustomerCost);
		}
		
		for (String i : customers) {
			System.out.println(i);
		}
	}
}
