package cs271;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstFrontier<T> implements Frontier<T> {
	Queue<Node<T>> queue;
	
	public BreadthFirstFrontier() {
		queue = new LinkedList<>();
	}
	
	@Override
	public boolean isEmpty() {
		return queue.isEmpty();
	}

	@Override
	public Node<T> next() {
		return queue.poll();
	}

	@Override
	public void add(Node<T> child) {
		queue.add(child);
	}

}
