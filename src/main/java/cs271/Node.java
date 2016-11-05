package cs271;

public class Node<T> {

	private Node<T> parent;
	private String operation;
	private T state;

	public Node(Node<T> parent, String operation, T state) {
		this.parent = parent;
		this.operation = operation;
		this.state = state;
	}

	public T getState() {
		return state;
	}
	
	public Node<T> getParent() {
		return this.parent;
	}
	
}
