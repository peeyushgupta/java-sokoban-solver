package cs271;

public class Node<T> {

	private Node<T> parent;
	private String operation;
	private T state;
	private double gValue;
	private double hValue;


	public Node(Node<T> parent, String operation, T state, double gValue, double hValue) {
		this.parent = parent;
		this.operation = operation;
		this.state = state;
		this.gValue = gValue;
		this.hValue = hValue;
	}

	public double getGValue() {
		return this.gValue;
	}

	public T getState() {
		return state;
	}
	
	public Node<T> getParent() {
		return this.parent;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Node)) return false;
		
		Node<T> convertedObject = (Node<T>) obj;
		
		return this.state.equals(convertedObject.getState());
	}
	
	@Override 
	public int hashCode() {
		String s = state.toString();
		
		int sum = 37 * s.charAt(0);
		
		for(char c : s.toCharArray()) {
			sum += c;
		}
		
		return sum;
	}

	public double getHValue() {
		return this.hValue;
	}

}
