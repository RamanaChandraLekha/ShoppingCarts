


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class UsersChoice {
	Scanner scan = new Scanner(System.in);
	Integer quantity;
	String userInput;
	String id;
	boolean flag;
	boolean flag1;
	String item1;
	// int available;
	LinkedHashMap<String, Set<Map.Entry<String, Integer>>> map;
	static Set<String> itemsSet = ShoppingManagementSystem.treemap.keySet();
	LinkedHashMap<String, Integer> items;
	Set<Map.Entry<String, Integer>> set;
	static LinkedHashMap<String, String> customersList = new LinkedHashMap<String, String>();// stores
																								// the
																								// customers
																								// and
																								// items
	static LinkedHashMap<String, String> customersCheckMap = new LinkedHashMap<String, String>();
	int remained;
	BufferedReader read=new BufferedReader(new InputStreamReader(System.in));
	String userChoice;
	String item;

	public void display() {

		System.out.println("1.Available Products\n 2.products to buy \n 3.customers\n 4.exit");

	}

	public void setChoice(String choice) {
		this.userChoice = choice;
	}

	public String getChoice() {
		return userChoice;
	}

	public void requestForProducts() throws IOException {

		items = new LinkedHashMap<String, Integer>();// stores the items and
														// quantity
		LinkedHashMap<String, Integer> checkMap = new LinkedHashMap<String, Integer>();

		Menu customer = new Menu();
		do {
			do {
				System.out.println("enter the product do you want");
				//BufferedReader read=new BufferedReader(new InputStreamReader(System.in));
				try {
					item = read.readLine();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				flag = false;
				try {

					item1 = customer.requiredItem(itemsSet, item);
				} catch (Exception e) {

					System.out.println("Enter valid data");
					System.out.println(ShoppingManagementSystem.treemap);
					System.out.println("do you want to enter(yes/no)");
					
					String choice=customer.inputCheck();
					if (choice.equalsIgnoreCase("yes"))

						flag = true;
/*
					else
						System.out.println(item1);
*/
				}
			} while (flag);

			do {
				if(item1==null)
					break;
				
				int available = ShoppingManagementSystem.treemap.get(item1);
				do{
					flag1=false;
				System.out.println("enter the quantity");
				
				
			try{
				quantity = Integer.parseInt(read.readLine());
			}
			catch(Exception e)
			{
				System.out.println("enter numeric value");
				/*System.out.println("do you want to enter yes/no");
				userInput=customer.inputCheck();
				if(userInput.equalsIgnoreCase("yes"))*/
				flag1 = true;
				//else break;
				
			}}while(flag1);

				flag = false;

				try {
					
					remained = customer.availableItems(available, quantity);

				} catch (Exception e) {
					//if (quantity > available){
						quantity = 0;
						remained=available;
						System.out.println("out of stock");
						userInput = "no";
					//	break;

					//}
					System.out.println("enter the valid data");
					System.out.println(ShoppingManagementSystem.treemap);
					System.out.println("do you want to enter(yes/no)");
					//try {
						 userInput= customer.inputCheck();
					//} catch (IOException e1) {
						// TODO Auto-generated catch block
					//	e1.printStackTrace();
					//}
					if (userInput.equalsIgnoreCase("yes"))

						flag = true;
					else
						break;
				}
			} while (flag);
			if (checkMap.containsKey(item1)) {
				int value = checkMap.get(item1);
				quantity = quantity + value;
				checkMap.put(item1, quantity);
				items.put(item1, quantity);
			} else {
				items.put(item1, quantity);
				checkMap.put(item1, quantity);
			}
			if(item1==null)
				{userInput="no";
				break;}
			ShoppingManagementSystem.treemap.put(item1, remained);
			System.out.println(ShoppingManagementSystem.treemap);
			System.out.println("do you want any other item(yes/no)");
			try {
				userInput = customer.validate(scan.next());
			} catch (Exception e) {
				System.out.println("enter either yes/no");
				userInput = customer.inputCheck();

			}

		} while (userInput.equalsIgnoreCase("yes"));

	}

	public LinkedHashMap<String, Set<Map.Entry<String, Integer>>> userDetails() {

		if (!(userInput.equalsIgnoreCase("yes"))) {
			set = items.entrySet();
			map = new LinkedHashMap<String, Set<Map.Entry<String, Integer>>>();
			//if(!map==null)
			System.out.println("enter your name");
			String name = scan.next();
			map.put(name, set);
			System.out.println("enter the id");
			id = scan.next();

		}
		return map;
	}

	public LinkedHashMap<String, String> customersList() {
		return customersList;
	}

	public void check() {
		if (customersCheckMap.containsKey(id)) {
			String values = customersCheckMap.get(id);
			String totalItems = values.concat(map.toString());
			customersCheckMap.put(id, totalItems);
			customersList.put(id, totalItems);
		} else {
			customersList.put(id, map.toString());
			customersCheckMap.put(id, map.toString());
		}
	}

}
