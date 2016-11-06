package cs271.sokoban;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * Stores items that will change
 */
public class GameState {
    Point playerLocation;
    Set<Point> boxLocations;

    public GameState(Point playerLocation, Set<Point> boxLocations) {
        this.playerLocation = playerLocation;
        this.boxLocations = boxLocations;
    }

    public Point getPlayerLocation() {
        return this.playerLocation;
    }

    public Set<Point> getBoxLocations() {
        return boxLocations;
    }

    public boolean isBox(Point p) {
        return boxLocations.contains(p);
    }

    public boolean isPlayer(Point p) {
        return playerLocation.equals(p);
    }

    public GameState move(Game game, char direction) {
        Point playerDestination = playerLocation.move(direction);
        Set<Point> boxesDestination = new HashSet<>(boxLocations);

        // if box is in the way, move the box too
        if (isBox(playerDestination)) {
            boxesDestination.remove(playerDestination);
            boxesDestination.add(playerDestination.move(direction));
        }

        return new GameState(playerDestination, boxesDestination);
    }

    @Override
    public boolean equals(Object obj) {
        GameState state = (GameState) obj;
        if (playerLocation.equals(state.getPlayerLocation()) &&
                state.getBoxLocations().size() == boxLocations.size()) {
            for (Point point : state.getBoxLocations()) {
                if (!boxLocations.contains(point))
                    return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hashX = 0;
        int hashY = 0;
        for (Point point : boxLocations) {
            hashX += point.getX();
            hashY += point.getY();
        }
        hashX += playerLocation.getX();
        hashY += playerLocation.getY();

        return 31 * hashX + 37 * hashY;
    }

    @Override
    public String toString() {
        String boxes = boxLocations.stream()
                .map((point) -> point.getX() + " " + point.getY() + " " + "Box")
                .collect(Collectors.joining("\n"));
        return boxes + "\n" + playerLocation.getX() + " " + playerLocation.getY() + " " + "Player";

    }

}
