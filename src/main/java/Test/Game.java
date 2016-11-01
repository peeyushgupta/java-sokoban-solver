package Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/*
 * Stores items that will not change
 */
public class Game {
	int[] dimensions; // dimensions[0] = height, dimensions[1] = width;
	// two sets
	Set<Point> wallLocations;
	Set<Point> storageLocations;

	public Game() {
		dimensions = new int[2];
		wallLocations = new HashSet<>();
		storageLocations = new HashSet<>();
	}

	public int[] getDimensions() {
		return this.dimensions;
	}

	public Set<Point> getWallLocations() {
		return this.wallLocations;
	}

	public Set<Point> getStorageLocations() {
		return this.storageLocations;
	}

	public boolean isWall(Point p) {
		return wallLocations.contains(p);
	}

	public boolean isStorage(Point p) {
		return storageLocations.contains(p);
	}

	public boolean canMove(GameState gs, char direction) {
		Point destination = gs.getPlayerLocation().move(direction);

		if(wallLocations.contains(destination)) {
			return false;
		}

		if(gs.getBoxLocations().contains(destination)) {
			Point boxDestination = destination.move(direction);
			if(wallLocations.contains(boxDestination) || gs.getBoxLocations().contains(boxDestination)) {
				return false;
			}
		}

		return true;
	}

	public List<Character> getAllowedMoves(GameState gs) {
		List<Character> allowedMovesList = new ArrayList<>();
		char[] moves = new char[]{'L', 'R', 'U', 'D'};

		for(char m : moves) {
			if(canMove(gs, m)) {
				allowedMovesList.add(m);
			}
		}

		return allowedMovesList;
	}

	// read config.txt and store values in class variables
	public void loadFromFile(File configFile) {
		try (BufferedReader br = new BufferedReader(new FileReader(configFile))) {
			for (String line; (line = br.readLine()) != null;) {
				String[] parts = line.split(": ");
				String[] numbers = parts[1].split(" "); // why would i call it something so undescriptive???

				switch(parts[0]) {
					case "size": {
						if(numbers.length % 2 != 0) {
							throw new IllegalArgumentException("[ERROR]: input file has incorrect board dimensions");
						}

						this.dimensions[0] = Integer.parseInt(numbers[0], 10);
						this.dimensions[1] = Integer.parseInt(numbers[1], 10);
						break;
					}
					case "nWallSquares": {
						// remember that the first number is for the number of walls
						if(numbers.length % 2 == 0) {
							throw new IllegalArgumentException("[ERROR]: input file has incorrect wall locations");
						}

						for(int i = 1; i < numbers.length; i+=2) {
							Point wall = new Point(Integer.parseInt(numbers[i]), Integer.parseInt(numbers[i + 1]));
							wallLocations.add(wall);
						}
						break;
					}
					case "nStorageLocations": {
						// remember that the first number is for the number of storage locations
						if(numbers.length % 2 == 0) {
							throw new IllegalArgumentException("[ERROR]: input file has incorrect storage locations");
						}

						for(int i = 1; i < numbers.length; i+=2) {
							Point storage = new Point(Integer.parseInt(numbers[i]), Integer.parseInt(numbers[i + 1]));
							storageLocations.add(storage);
						}
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
