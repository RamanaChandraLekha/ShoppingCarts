
import java.util.Iterator;
import java.util.Set;

public class Menu {
	boolean flag=false;
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
	
}
