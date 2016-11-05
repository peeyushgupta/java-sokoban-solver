package cs271;

public interface Frontier<T> {

	boolean isEmpty();

	Node<T> next();

	void add(Node<T> child);

}
