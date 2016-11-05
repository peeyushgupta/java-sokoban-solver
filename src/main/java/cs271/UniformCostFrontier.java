package cs271;

import java.util.Comparator;
import java.util.PriorityQueue;

public class UniformCostFrontier<T> implements Frontier<T> {

	PriorityQueue<Node<T>> frontier;
	
	public UniformCostFrontier(){
		Comparator<Node<T>> comparator = new Comparator<Node<T>>(){
			@Override
			public int compare(Node<T> x, Node<T> y) {
				if(x.getGValue() > y.getGValue()) return 1;
				else if(x.getGValue() < y.getGValue()) return -1;
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
