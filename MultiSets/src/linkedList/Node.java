package linkedList;

public class Node<T> {
	
	private T item=null;
	private int itemCount=0;
	private Node next=null;
	//Node prev;

	public Node() {
		// Creates an empty node
	}
	
	public Node(T newItem) {
		item=newItem;
		itemCount=1;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

}
