package cs271.sokoban;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/*
 * Stores items that will change
 */
public class GameState {
	Point playerLocation;
	Set<Point> boxLocations;

	public GameState() {
		playerLocation = null;
		boxLocations = new HashSet<>();
	}

	public Point getPlayerLocation() {
		return this.playerLocation;
	}

	public Set<Point> getBoxLocations() {
		return this.boxLocations;
	}

	public boolean isBox(Point p) {
		return boxLocations.contains(p);
	}

	public boolean isPlayer(Point p) {
		return playerLocation.equals(p);
	}

	// TODO
	// put game object as inptut
//	public void move(Game game, char direction) {
//		Point playerDestination = playerLocation.move(direction);
//
//		// if box is in the way, update box
//		if(boxLocations.contains(playerDestination)) {
//			Point boxDestination = playerDestination.move(direction);
//
//			// if there is no wall, update box location AND player location
//			if(game.getWallLocations().contains(boxDestination)) {
//
//				// update box
//			}
//		} else {
//			// if there is no wall, then update player location
//			playerLocation = playerDestination;
//		}
//	}

	// read config.txt and store values in class variables
	public void loadFromFile(File configFile) {
		try (BufferedReader br = new BufferedReader(new FileReader(configFile))) {
			for (String line; (line = br.readLine()) != null;) {
				String[] parts = line.split(": ");
				String[] numbers = parts[1].split(" "); // why would i call it something so undescriptive???

				switch(parts[0]) {
					case "nBoxes": {
						// remember that the first number is for the number of boxes
						if(numbers.length % 2 == 0) {
							throw new IllegalArgumentException("[ERROR]: input file has incorrect box locations");
						}

						for(int i = 1; i < numbers.length; i+=2) {
							Point box = new Point(Integer.parseInt(numbers[i], 10), Integer.parseInt(numbers[i+1]));
							boxLocations.add(box);
						}
						break;
					}
					case "player": {
						if(numbers.length % 2 != 0) {
							throw new IllegalArgumentException("[ERROR]: input file has incorrect player location");
						}

						playerLocation = new Point(Integer.parseInt(numbers[0], 10), Integer.parseInt(numbers[1], 10));
						break;
					}
					default:
						break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
