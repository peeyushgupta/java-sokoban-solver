package cs271.sokoban;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Initializer {
    private Game game;
    private GameState gameState;

    public Game getGame() {
        return game;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void printBoard() {
        int width = game.getDimensions()[0];
        int height = game.getDimensions()[1];

        // print out board and legend
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                Point loc = new Point(i, j);
                if (gameState.isPlayer(loc))
                    System.out.print("[p]");
                else if (gameState.isBox(loc))
                    System.out.print("[b]");
                else if (game.isStorage(loc))
                    System.out.print("[s]");
                else if (game.isWall(loc))
                    System.out.print("[w]");
                else
                    System.out.print("[ ]");
            }
            System.out.println();
        }

        System.out.println("\nPlayer = [p]");
        System.out.println("Box = [b]");
        System.out.println("Storage = [s]");
        System.out.println("Wall = [w]");
    }

    public Initializer(Game game, GameState gameState) {
        this.game = game;
        this.gameState = gameState;
    }

    public Initializer(File configFile) {
        int[] dimensions = new int[2];
        Set<Point> wallLocations = new HashSet<>();
        Set<Point> boxLocations = new HashSet<>();
        Set<Point> storageLocations = new HashSet<>();
        Point playerLocation = null;

        try (BufferedReader br = new BufferedReader(new FileReader(configFile))) {
            for (String line; (line = br.readLine()) != null;) {
                String[] parts = line.split(": ");
                String[] numbers = parts[1].split(" "); // why would i call it something so undescriptive???

                switch (parts[0]) {
                case "size": {
                    if (numbers.length % 2 != 0) {
                        throw new IllegalArgumentException("[ERROR]: input file has incorrect board dimensions");
                    }

                    dimensions[0] = Integer.parseInt(numbers[0], 10);
                    dimensions[1] = Integer.parseInt(numbers[1], 10);
                    break;
                }
                case "nWallSquares": {
                    // remember that the first number is for the number of walls
                    if (numbers.length % 2 == 0) {
                        throw new IllegalArgumentException("[ERROR]: input file has incorrect wall locations");
                    }

                    for (int i = 1; i < numbers.length; i += 2) {
                        Point wall = new Point(Integer.parseInt(numbers[i]), Integer.parseInt(numbers[i + 1]));
                        wallLocations.add(wall);
                    }
                    break;
                }
                case "nStorageLocations": {
                    // remember that the first number is for the number of
                    // storage locations
                    if (numbers.length % 2 == 0) {
                        throw new IllegalArgumentException("[ERROR]: input file has incorrect storage locations");
                    }

                    for (int i = 1; i < numbers.length; i += 2) {
                        Point storage = new Point(Integer.parseInt(numbers[i]), Integer.parseInt(numbers[i + 1]));
                        storageLocations.add(storage);
                    }
                    break;
                }
                case "nBoxes": {
                    // remember that the first number is for the number of boxes
                    if (numbers.length % 2 == 0) {
                        throw new IllegalArgumentException("[ERROR]: input file has incorrect box locations");
                    }

                    for (int i = 1; i < numbers.length; i += 2) {
                        Point box = new Point(Integer.parseInt(numbers[i], 10), Integer.parseInt(numbers[i + 1]));
                        boxLocations.add(box);
                    }
                    break;
                }
                case "player": {
                    if (numbers.length % 2 != 0) {
                        throw new IllegalArgumentException("[ERROR]: input file has incorrect player location");
                    }

                    playerLocation = new Point(Integer.parseInt(numbers[0], 10), Integer.parseInt(numbers[1], 10));
                    break;
                }
                default:
                    break;
                }
            }

            game = new Game(dimensions, wallLocations, storageLocations);
            gameState = new GameState(playerLocation, boxLocations);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // REMEMBER THE TILES START AT 1, 1 ACCORDING TO THE INPUT FILE
        File configFile = new File("resources/config.txt");
        Initializer initializer = new Initializer(configFile);

        // print out all tiles
        System.out.println(initializer.getGame());
        System.out.println(initializer.getGameState());

        initializer.printBoard();
    }
}
