package cs271;

import java.util.LinkedList;
import java.util.List;

public abstract class Graph<T> {

    abstract Node<T> get(T state);

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

    abstract boolean isGoal(Node<T> node);

    abstract List<Node<T>> children(Node<T> current);

}
