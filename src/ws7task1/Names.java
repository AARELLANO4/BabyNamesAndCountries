/* Alexis Arellano Tuesday November 17/2020 */

package ws7task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Names {
	private static List<String> boyNames;
	private static List<String> girlNames;
	private static List<String> commonNames;
	
	static GetFile gf = new GetFile();
	
	public static void getLists() {
		gf.read();
		setGirls();
		setBoys();
	}
	
	public static List<String> getBoys() {
		return boyNames;
	}
	
	public static List<String> getGirls( ) {
		return girlNames;
	}

	public static void setBoys() {
		boyNames = new ArrayList<>(gf.getCol(2));
	}
	
	public static void setGirls() {
		girlNames = new ArrayList<>(gf.getCol(4));
	}
	
	// Create list of common names
	public static List<String> commonNames() {
		commonNames = new ArrayList<String>(getGirls());
		commonNames.retainAll(getBoys());
			
		return commonNames;
	}
	
	// Display all names
	public static void display() {
		System.out.println("There are " + commonNames().size() + " names used for both genders.");
		System.out.println("They are: ");
		formatList(commonNames());
		
		System.out.println("\nAll girl names:");
		formatList(getGirls());
		System.out.println("\nAll boy names:");
		formatList(getBoys());
		
	}
	
	// Display sorted and unique-to-gender names
	public static void displaySorted() {
		System.out.println("\n=== NAMES SORTED ALPHABETICALLY ===\n");
		System.out.println("Names used for both genders:");
		formatList(sort.apply(commonNames()));
		System.out.println("\nNames used only for girls:");
		formatList(sort.apply(delete.apply(getGirls())));
		
		System.out.println("\nNames used only for boys:");
		List<String> boys = delete.apply(getBoys());
		formatList(sort.apply(boys));
	}
	
	// Aesthetics
	public static void formatList(List<String> list) {
		for (int i = 0; i < list.size(); i++) {
			if (i == list.size()-1) {
				System.out.print(list.get(i) + ".\n");
			}
			else {
				System.out.print(list.get(i) + ", ");
			}
		}
	}
	
	public static final ModifyArray sort = (array)->{
		Collections.sort(array);
		return array;
	};
	
	public static final ModifyArray delete = (array)->{
		array.removeAll(commonNames);
		return array;
	};
	
	public static void main(String[] args){
		getLists();
		display();
		displaySorted();
	}
}
