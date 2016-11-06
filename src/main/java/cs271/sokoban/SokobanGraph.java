package cs271.sokoban;

import cs271.search.Graph;
import cs271.search.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SokobanGraph extends Graph<GameState> {

    private Game game;

    public SokobanGraph(Game game) {
        this.game = game;
    }

    @Override
    public Node<GameState> get(GameState state) {
        return new Node<GameState>(null, "Move", state, 0, 0);
    }

    public List<GameState> path(Node<GameState> goal) {
        List<GameState> path = new ArrayList<>();

        Node<GameState> temp = goal;
        while (temp != null) {
            path.add(temp.getState());
            temp = temp.getParent();
        }

        // TODO: Find a better way to build list in reverse
        Collections.reverse(path);
        return path;
    }

    public List<Character> getMovesFromPath(List<GameState> path) {
        List<Character> moves = new ArrayList<>();
        char[] possibleMoves = new char[]{'L', 'R', 'U', 'D'};

        for (int i = 0; i < path.size() - 1; i++) {
            GameState currentState = path.get(i);
            GameState nextState = path.get(i + 1);

            for (Character move : possibleMoves) {
                if (nextState.getPlayerLocation().equals(currentState.getPlayerLocation().move(move))) {
                    moves.add(move);
                }
            }
        }
        return moves;
    }

    @Override
    public boolean isGoal(Node<GameState> node) {
        for (Point point : node.getState().getBoxLocations()) {
            if (!game.getStorageLocations().contains(point))
                return false;
        }
        return true;
    }

    @Override
    public List<Node<GameState>> children(Node<GameState> current) {
        List<Node<GameState>> list = new ArrayList<>();

        List<Character> allowedMovesList = game.getAllowedMoves(current.getState());
        for (Character move : allowedMovesList) {
            GameState nextState = current.getState().move(game, move);
            list.add(new Node<GameState>(current, "Move", nextState, 0, 0));
        }

        return list;
    }
}