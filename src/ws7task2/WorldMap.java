/* Alexis Arellano Tuesday November 17/2020 */
package ws7task2;

import java.util.HashMap;
import java.util.Scanner;
public class WorldMap {
	private HashMap<String, String> countries = new HashMap<>();
	
	public WorldMap() {
		setCountries();
	}
	
	public void setCountries() {
		countries.put("Canada","Ottawa");
		countries.put("Egypt", "Cairo");
		countries.put("Nepal","Kathmandu");
		countries.put("Ireland", "Dublin");
		countries.put("Japan","Tokyo");
		countries.put("Vietnam", "Hanoi");
		countries.put("USA","Washington, D.C.");
		countries.put("Netherlands", "Amsterdam");
		countries.put("Mexico","Mexico City");
		countries.put("South Korea", "Seoul");
		countries.put("Kenya","Nairobi");
		countries.put("Germany", "Berlin");
		countries.put("Colombia","Begota");
		countries.put("Brazil", "Brasilia");
		countries.put("Pakistan","Islamabad");
		countries.put("Philippines", "Manila");
		countries.put("Poland","Warsaw");
		countries.put("Romania", "Bucharest");
		countries.put("Russia","Moscow");
		countries.put("Sweden", "Stockholm");
		countries.put("India","New Delhi");
		countries.put("France", "Paris");
		countries.put("United Kingdom","London");
		countries.put("South Africa", "Cape Town");
		countries.put("Morocco", "Rabat");
	}
	
	public String getCity(String country) {
		return countries.get(country);
	}
	
}
