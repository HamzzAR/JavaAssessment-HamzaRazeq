package InfiniteTerrain;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class MainGame {
	Map<String, Location> locations = new HashMap<String, Location>();

	public static void main(String[] args) {
		new MainGame();

	}
	
	public MainGame() {
		System.out.println("            Welcome to planet Ergotron.        \n");
		System.out.println("You have just landed your spaceship. It is time to explose this amazing"
				+ "new planet");
		System.out.println("Your mission is to navigate your way around using the compasss tool provided to you.");
		System.out.println("It is crucial that you make the most of your time and find areas of interest"
				+ "and then report back to us.");
		System.out.println("If in any case you encounter any problems, use the emergency handset provided to"
				+ "you in order to reach us and we shall do our best. \n");
		System.out.println("	    Best of Luck.						\n");
		
		String currentDirection = "north";
		while(true) {
			System.out.println("Current heading: "+currentDirection);
			System.out.println("Try 'north','south','east', 'west' or 'quit'");
			Scanner userInput = new Scanner(System.in);
			String navigation = userInput.nextLine();
			
			if(navigation.equals("quit")) {
				break;
			}
			
			System.out.println("Try 'run' or 'walk'");
			Scanner userInput2 = new Scanner(System.in);
			String optionType = userInput2.nextLine();
			Location loc = null;
			Location location; 
			switch (navigation) {
			case "north": // waterPark
				Location isFound = findLocationInHashMap("north");
				if(isFound != null) {
					location = isFound;
				}else {
					location = new Location("north");
				}
				
				switch (optionType) {
				case "walk":
					loc = moveOption(location,"w");
					printMessages(loc);
					break;

				case "run":
					loc = moveOption(location,"r");
					printMessages(loc);
					break;
				}
				locations.put("north", loc);
				currentDirection = "north";
				break;
			case "south": // LionJungle
				Location isFound1 = findLocationInHashMap("south");
				
				if(isFound1 != null) {
					location = isFound1;
				}else {
					location = new Location("south");
				}
				
				switch (optionType) {
				case "walk":
					loc = moveOption(location,"w");
					printMessages(loc);
					break;

				case "run":
					loc = moveOption(location,"r");
					printMessages(loc);
					break;
				}
				locations.put("south", loc);
				currentDirection = "south";
				break;
			case "east":  // SkyCity
				Location isFound2 = findLocationInHashMap("east");
				
				if(isFound2 != null) {
					location = isFound2;
				}else {
					location = new Location("east");
				}
				
				switch (optionType) {
				case "walk":
					loc = moveOption(location,"w");
					printMessages(loc);
					break;

				case "run":
					loc = moveOption(location,"r");
					printMessages(loc);
					break;
				}
				locations.put("east", loc);
				currentDirection = "east";
				break;
			case "west":  // Treasure
				Location isFound3 = findLocationInHashMap("west");
				
				if(isFound3 != null) {
					location = isFound3;
				}else {
					location = new Location("west");
				}
				
				switch (optionType) {
				case "walk":
					loc = moveOption(location,"w");
					printMessages(loc);
					break;

				case "run":
					loc = moveOption(location,"r");
					printMessages(loc);
					break;
				}
				locations.put("west", loc);
				currentDirection = "west";
				break;

			}
		
			if(loc.getDistance() <= 0) {
				System.out.println("You have reached "+loc.getLocation() + " Congratulations!!!!");
				System.out.println("      Game Over       ");
				break;
			}
		}
		
	}

	public Location findLocationInHashMap(String string) {
		Location loc = null;
		for (Entry<String, Location> el: locations.entrySet()) {
			if(el.getKey().equals(string)) {
				loc = el.getValue();
				break;
			}
		}
		
		return loc;
		
	}

	public Location moveOption(Location location,String option) {
		System.out.println("Take steps forwards (e.g. 20)");
		Scanner userInput = new Scanner(System.in);
		int steps = userInput.nextInt();
		
		if(option.equals("w")) {
			location.walkForward(steps);
		}else {
			location.runForward(steps);
		}

		return location;
		
		
		
	}
	
	public void printMessages(Location loc) {
		System.out.println("You are headed towards: "+loc.getLocation());
		System.out.println("Distance to distination: "+String.format("%.2f", loc.getDistance())+" miles");
	}
	

}
