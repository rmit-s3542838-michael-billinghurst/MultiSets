package linkedList;

public class Node<T> {
	
	private T item=null;
	private int itemCount=0;
	private Node<T> next=null;

	public Node() {
		// Creates an empty node
	}
	
	public Node(T newItem) {
		item=newItem;
		itemCount=1;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	public T getItem() {
		return item;
	}

	/* setItem should not be needed for linked list implementation. Node constructors should be used.
	public void setItem(T item) {
		this.item = item;
	} */

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}
	
	public void incrementItemCount() {
		itemCount++;
	}
	public void deincrementItemCount() {
		itemCount--;
	}
}
