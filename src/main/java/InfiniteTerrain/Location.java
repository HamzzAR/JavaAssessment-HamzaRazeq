package InfiniteTerrain;

public class Location {
	private double distanceInMile;
	private String location;
	
	public Location(String direction) {
		switch (direction) {
		case "north": // waterPark
			location = "Water Park";
			distanceInMile = 4;
			break;
		case "south": // LionJungle
			location = "Lion Jungle";
			distanceInMile = 6;
			break;
		case "east":  // SkyCity
			location = "Sky City";
			distanceInMile = 8;
			break;
		case "west":  // Treasure
			location = "Treasure2";
			distanceInMile = 10;
			break;

		}
	}
	
	public double walkForward(int steps) {
		distanceInMile = distanceInMile - (steps * (distanceInMile/2000));
		return distanceInMile;
	}
	
	public double runForward(int steps) {
		distanceInMile = distanceInMile - (steps * (distanceInMile/1500));
		return distanceInMile;
	}
	
	public double getDistance() {
		return distanceInMile;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	
}
