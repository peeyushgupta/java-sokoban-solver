package cs271.frontier;

import cs271.Node;

public interface Frontier<T> {

    boolean isEmpty();

    Node<T> next();

    void add(Node<T> child);

}
