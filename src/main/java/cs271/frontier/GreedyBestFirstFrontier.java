package cs271.frontier;

import java.util.Comparator;
import java.util.PriorityQueue;

import cs271.Node;

public class GreedyBestFirstFrontier<T> implements Frontier<T> {

    PriorityQueue<Node<T>> frontier;

    public GreedyBestFirstFrontier() {
        Comparator<Node<T>> comparator = new Comparator<Node<T>>() {
            @Override
            public int compare(Node<T> x, Node<T> y) {
                if (x.getHValue() > y.getHValue()) return 1;
                else if (x.getHValue() < y.getHValue()) return -1;
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
