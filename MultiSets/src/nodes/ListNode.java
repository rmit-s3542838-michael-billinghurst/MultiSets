package nodes;

public class ListNode<T> {
	
	private T item=null;
	private int itemCount=0;
	private ListNode<T> next=null;

	public ListNode() {
		// Creates an empty node
	}
	
	public ListNode(T newItem) {
		item=newItem;
		itemCount=1;
	}

	public ListNode<T> getNext() {
		return next;
	}

	public void setNext(ListNode<T> next) {
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
