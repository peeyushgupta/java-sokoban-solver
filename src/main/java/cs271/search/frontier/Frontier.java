package cs271.search.frontier;

import cs271.search.Node;

public interface Frontier<T> {

    boolean isEmpty();

    Node<T> next();

    void add(Node<T> child);

}
