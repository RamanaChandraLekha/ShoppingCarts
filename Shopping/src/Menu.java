
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Set;

public class Menu {
	BufferedReader read=new BufferedReader(new InputStreamReader(System.in));
	boolean flag=false;
	String choice;
	public int availableItems(int available, int required) throws RuntimeException {
		if (required <= available) {
			available = available - required;
			return available;

		} else {
			throw new RuntimeException();
		}

	}

	public String requiredItem(Set<String> items, String requiredItem) throws RuntimeException {
		
		
		String item=requiredItem.trim();
		Iterator<String> iter=items.iterator();
		while(iter.hasNext())
		{
			String i=iter.next();
		if (i.equalsIgnoreCase(item))
			flag=true;;
		}
		if(flag)
				return( requiredItem.trim()).toLowerCase();
		
		
				
			
		else
			throw new RuntimeException();
			
		
		}	
	/*
	 * public String requiredItem(String requiredItem) { if(String
	 * item=String.parseInt(requiredItem)) return requiredItem; else th }
	 */

	public String validate(String input) throws RuntimeException {
		if ((input.equalsIgnoreCase("yes")) || (input.equalsIgnoreCase("no")))
			return input;

		else
			throw new RuntimeException();
	}
	public String inputCheck() throws IOException {

		String choice1 = read.readLine();
		do{
		switch (choice1) {
		case "yes":
		choice = choice1;
		break;
		case "no":choice=choice1;
		break;
		default:
		System.out.println("enter valid input(yes/no)");
		choice = read.readLine();
		break;
		}}while(!(choice.equalsIgnoreCase("yes"))&&!(choice.equalsIgnoreCase("no")));

		return choice;
		}
	
}
