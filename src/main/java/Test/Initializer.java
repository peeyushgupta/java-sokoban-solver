package Test;

import java.io.File;

public class Initializer {
	public static void printBoard(Game game, GameState gameState) {
		int width = game.getDimensions()[0];
		int height = game.getDimensions()[1];
		char[][] board = new char[height][width];

		// initially fill board with empty spaces
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				board[i][j] = ' ';
			}
		}

		// populate board with walls
		for(Point wall : game.getWallLocations()) {
			board[wall.getX() - 1][wall.getY() - 1] = 'w';
		}

		// populate boards with storage locations
		for(Point storageLocation : game.getStorageLocations()) {
			board[storageLocation.getX() - 1][storageLocation.getY() - 1] = 's';
		}

		// populate board with boxes
		for(Point p : gameState.getBoxLocations()) {
			board[p.getX() - 1][p.getY() - 1] = 'b';
		}

		// populate board with player
		board[gameState.getPlayerLocation().getX() - 1][gameState.getPlayerLocation().getY() - 1] = 'p';

		// print out board and legend
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				System.out.print("[" + board[i][j] + "]");
			}
			System.out.println();
		}

		System.out.println("\nPlayer = [p]");
		System.out.println("Box = [b]");
		System.out.println("Storage = [s]");
		System.out.println("Wall = [w]");
	}

	public static void main(String[] args) {
		// REMEMBER THE TILES START AT 1, 1 ACCORDING TO THE INPUT FILE
		File configFile = new File("resources/config.txt");

		Game game = new Game();
		game.loadFromFile(configFile);

		GameState gameState = new GameState();
		gameState.loadFromFile(configFile);

		// print out all tiles
		game.getWallLocations().forEach((wall) -> System.out.println(wall.getX() + " " + wall.getY() + " " + "Wall"));
		game.getStorageLocations().forEach((storageLocation) -> System.out.println(storageLocation.getX() + " " + storageLocation.getY() + " " + "Storage Location"));
		gameState.getBoxLocations().forEach((point) -> System.out.println(point.getX() + " " + point.getY() + " " + "Box"));
		System.out.println(gameState.getPlayerLocation().getX() + " " + gameState.getPlayerLocation().getY() + " " + "Player");

		printBoard(game, gameState);
	}
}
