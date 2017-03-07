
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class ShoppingManagementSystem {
	static TreeMap<String, Integer> treemap = new TreeMap<String, Integer>();

	static String input;

	public static void main(String[] args) {
		boolean flag = true;
		treemap.put("milk", 50);
		treemap.put("eggs", 175);
		treemap.put("oil", 100);
		treemap.put("shampoo", 452);
		treemap.put("lays", 75);
		treemap.put("cakes", 175);
		treemap.put("choclates", 175);

		Scanner scan = new Scanner(System.in);
		UsersChoice choice = new UsersChoice();

		while (flag) {
			choice.display();
			System.out.println("enter your choice");

			choice.setChoice(scan.nextLine());
			input = choice.getChoice();

			switch (input) {
			case "1":
				System.out.println(treemap);

				break;
			case "2":
				choice.requestForProducts();
				LinkedHashMap<String, Set<Map.Entry<String, Integer>>> map = choice.userDetails();
				choice.check();
				System.out.println(map);
				System.out.println("Thanks for shopping..Visit again!");

				break;
			case "3":
				LinkedHashMap<String, String> customersList = choice.customersList();
				System.out.println(customersList);
				System.out.println("do you want to exit(yes/no)");
				if (scan.next().equalsIgnoreCase("yes"))
					flag = false;

				break;
			case "4":

				System.exit(0);

				break;
			default:
				System.out.println("enter the valid input");

			}
		}

		scan.close();
	}

}


				break;
			case "4":

				System.exit(0);

				break;
			default:
				System.out.println("enter the valid input");

			}
		}

		scan.close();
	}

}
