package cs271.frontier;

import java.util.Stack;

import cs271.Node;

public class DepthFirstFrontier<T> implements Frontier<T> {

    private Stack<Node<T>> frontier;

    public DepthFirstFrontier() {
        this.frontier = new Stack<>();
    }

    @Override
    public boolean isEmpty() {
        return frontier.isEmpty();
    }

    @Override
    public Node<T> next() {
        return frontier.pop();
    }

    @Override
    public void add(Node<T> child) {
        frontier.push(child);
    }

}
