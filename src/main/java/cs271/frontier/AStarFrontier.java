package cs271.frontier;

import java.util.Comparator;
import java.util.PriorityQueue;

import cs271.Node;

public class AStarFrontier<T> implements Frontier<T> {

    PriorityQueue<Node<T>> frontier;

    public AStarFrontier() {
        Comparator<Node<T>> comparator = new Comparator<Node<T>>() {
            @Override
            public int compare(Node<T> x, Node<T> y) {
                double xFCost = x.getGValue() + x.getHValue();
                double yFCost = y.getGValue() + y.getHValue();

                if (xFCost > yFCost) return 1;
                else if (xFCost < yFCost) return -1;
                return 0;
            }
        };

        frontier = new PriorityQueue<>(100, comparator);
    }

    @Override
    public boolean isEmpty() {
        return frontier.isEmpty();
    }

    @Override
    public Node<T> next() {
        return frontier.poll();
    }

    @Override
    public void add(Node<T> child) {
        frontier.add(child);
    }
}
