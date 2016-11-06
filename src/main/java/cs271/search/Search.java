package cs271.search;

import java.util.HashSet;
import java.util.Set;

import cs271.search.frontier.*;

public class Search<T> {

    private Node<T> search(Frontier<T> frontier, Graph<T> graph, Node<T> node) {
        Set<Node<T>> visited = new HashSet<>();

        frontier.add(node);

        while (!frontier.isEmpty()) {
            Node<T> current = frontier.next();
            visited.add(current);

            if (graph.isGoal(current)) {
                return current;
            }

            graph.children(current).forEach(child -> {
                if (!visited.contains(child)) {
                    frontier.add(child);
                }
            });
        }

        return null;
    }

    public Node<T> depthFirst(Graph<T> graph, Node<T> node) {
        Frontier<T> frontier = new DepthFirstFrontier<>();
        return search(frontier, graph, node);
    }

    public Node<T> breadthFirst(Graph<T> graph, Node<T> node) {
        Frontier<T> frontier = new BreadthFirstFrontier<>();
        return search(frontier, graph, node);
    }

    public Node<T> uniformCost(Graph<T> graph, Node<T> node) {
        Frontier<T> frontier = new UniformCostFrontier<>();
        return search(frontier, graph, node);
    }

    public Node<T> greedyBestFirst(Graph<T> graph, Node<T> node) {
        Frontier<T> frontier = new GreedyBestFirstFrontier<>();
        return search(frontier, graph, node);
    }

    public Node<T> aStar(Graph<T> graph, Node<T> node) {
        Frontier<T> frontier = new AStarFrontier<>();
        return search(frontier, graph, node);
    }
}
