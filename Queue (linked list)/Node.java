public class Node<T> {

	// globals
	private T data;
	private Node<T> next;
	
	public Node (T data, Node<T> next) {
		this.data = data;
		this.next = next;
	}
	
	// setters
	public void setData (T data) {
		this.data = data;
	}
	public void setNext (Node<T> next) {
		this.next = next;
	}
	
	// getters
	public T getData () {
		return data;
	}
	public Node<T> getNext () {
		return this.next;
	}
	
}
