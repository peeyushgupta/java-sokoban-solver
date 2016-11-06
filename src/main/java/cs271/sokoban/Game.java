package cs271.sokoban;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * Stores items that will not change
 */
public class Game {
    int[] dimensions; // dimensions[0] = height, dimensions[1] = width;
    Set<Point> wallLocations;
    Set<Point> storageLocations;

    public Game(int[] dimensions, Set<Point> wallLocations, Set<Point> storageLocations) {
        this.dimensions = dimensions;
        this.wallLocations = wallLocations;
        this.storageLocations = storageLocations;
    }

    public Set<Point> getStorageLocations() {
        return storageLocations;
    }

    public int[] getDimensions() {
        return this.dimensions;
    }

    public boolean isWall(Point p) {
        return wallLocations.contains(p);
    }

    public boolean isStorage(Point p) {
        return storageLocations.contains(p);
    }

    public boolean canMove(GameState gs, char direction) {
        Point destination = gs.getPlayerLocation().move(direction);

        if (isWall(destination)) {
            return false;
        }

        if (gs.isBox(destination)) {
            Point boxDestination = destination.move(direction);
            if (isWall(boxDestination) || gs.isBox(boxDestination)) {
                return false;
            }
        }

        return true;
    }

    public List<Character> getAllowedMoves(GameState gs) {
        List<Character> allowedMovesList = new ArrayList<>();
        char[] moves = new char[] { 'L', 'R', 'U', 'D' };

        for (char m : moves) {
            if (canMove(gs, m)) {
                allowedMovesList.add(m);
            }
        }

        return allowedMovesList;
    }

    @Override
    public String toString() {
        String walls = wallLocations.stream()
                .map((wall) -> wall.getX() + " " + wall.getY() + " " + "Wall")
                .collect(Collectors.joining("\n"));
        String storage = storageLocations.stream()
                .map((storageLocation) -> storageLocation.getX() + " " + storageLocation.getY() + " " + "Storage Location")
                .collect(Collectors.joining("\n"));

        return walls + "\n" + storage;
    }
}
