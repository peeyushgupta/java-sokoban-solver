package cs271;

import java.util.Stack;

public class DepthFirst<T> {

	public Node<T> search(Graph<T> graph, Node<T> node) {
		Stack<Node<T>> frontier = new Stack<>();
		
		frontier.push(node);
		
		while (!frontier.isEmpty()) {
			Node<T> current = frontier.pop();
		
			if (graph.isGoal(current)) {
				return current;
			}
			
			graph.children(current).forEach(child -> {
				frontier.push(child);
			});
		}

		return null;
	}

}
