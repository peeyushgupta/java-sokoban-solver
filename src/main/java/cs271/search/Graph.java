package cs271.search;

import java.util.LinkedList;
import java.util.List;

public abstract class Graph<T> {

    abstract public Node<T> get(T state);

    abstract public boolean isGoal(Node<T> node);

    abstract public List<Node<T>> children(Node<T> current);

    public List<String> statePath(Node<String> goal) {
        LinkedList<String> path = new LinkedList<>();

        Node<String> temp = goal;
        while (temp != null) {
            path.push(temp.getState());
            temp = temp.getParent();
        }

        return path;
    }

    public List<String> operationPath(Node<String> goal) {
        LinkedList<String> path = new LinkedList<>();

        Node<String> temp = goal;
        while (temp != null) {
            path.push(temp.getOperation());
            temp = temp.getParent();
        }

        return path;
    }

}
