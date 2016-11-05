package cs271;

import java.util.List;

public interface Graph<T> {

	Node<T> get(T state);

	List<T> path(Node<T> goal);

	boolean isGoal(Node<T> node);

	List<Node<T>> children(Node<T> current);
	

}
