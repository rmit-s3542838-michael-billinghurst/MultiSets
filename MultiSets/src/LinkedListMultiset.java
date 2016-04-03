
import java.io.PrintStream;
import java.util.*;

import nodes.ListNode;

public class LinkedListMultiset<T> extends Multiset<T>
{
	public LinkedListMultiset() {
			
	} // end of LinkedListMultiset()
	
	/* A Linked List is a series of nodes that points to the next node in the list.
	 * The List object knows the location of the first node in the list, and can use it's methods
	 * To loop through the nodes which all point to the next one in the list*/
	private ListNode<T> head = new ListNode<T>() ;

	
	public void add(T item) {
		//Create a node for the item
		ListNode<T> nodeTemp = new ListNode<T>(item);
		//Check if there are any items in the list, and if not, make the new item the head.
		if (head.getItem()==null)
			head=nodeTemp;
		else
		{
			ListNode<T> nodeCurrent = head;
			/*Loop through the list until you reach the last node (ie a node where next==null)
			 * Or find the current a duplicate entry in the list (Note comparison here intentionally checks for the same object, not identical ones
			 * [That is it compares by object reference not value])*/
			while (nodeCurrent.getNext() != null && !(nodeCurrent.getItem().equals(item)))
			{
				nodeCurrent= nodeCurrent.getNext();
			}
			//Stops here, either at the end of the list, or at the node that already contains a number of 'item'
			 if (nodeCurrent.getItem().equals(item))
			{
				 //If a node for item already exists in the list, increment the itemCount of that node and of the linked list
				nodeCurrent.incrementItemCount();
			}
			else  if (nodeCurrent.getNext()==null)
			{
				//add the new Node to the end of the list, if item doesn't occur in the list already
				nodeCurrent.setNext(nodeTemp);
			}
			else
				//Fail safe for debugging, should never occur in runtime.
				System.out.println("DEBUG: ERROR IN ADD, FAILED TO FIND EXISTING NODE");
		}
	} // end of add()
	
	
	public int search(T item) {
		//Start search of the head of the list,
		ListNode<T> nodeCurrent = head;
		//Check if the head is the node containing item
		if (nodeCurrent.getItem().equals(item))
			return nodeCurrent.getItemCount();
		//Loop through the entire list searching for the item
		while (nodeCurrent.getNext() != null)
		{
			nodeCurrent= nodeCurrent.getNext();
			//If the item is found, return the current Index
			if (nodeCurrent.getItem().equals(item))
				return nodeCurrent.getItemCount();
		}
		//If the end of the list is reached, return 0, as there are no items in the list
		return 0;
	} // end of add()
	
	
	public void removeOne(T item) {
		ListNode<T> nodeCurrent = head;
		//Loop through the list until the item is found, or the end is reached
		while (!(nodeCurrent.getItem().equals(item)) && (nodeCurrent.getNext()!=null))
		{
			nodeCurrent=nodeCurrent.getNext();
		}
		//If the current node is the item, remove one. If it isn't, it means you've reached the end of the list.
		if (nodeCurrent.getItem().equals(item))
		{
			nodeCurrent.deincrementItemCount();
		}
	} // end of removeOne()
	
	
	public void removeAll(T item) {
		ListNode<T> nodeCurrent = head;
		ListNode<T> nodePrev=new ListNode<T>();
		//TODO Currently breaks if list is empty, or if item is at the head of the list.
		//Loop through the list until the item is found, or the end is reached
		while (!(nodeCurrent.getItem().equals(item)) && (nodeCurrent.getNext()!=null))
		{
			nodePrev=nodeCurrent;
			nodeCurrent=nodeCurrent.getNext();
		}		//If nodeCurrent contains the item, delete the node
		if (nodeCurrent.getItem().equals(item))
			//Set the previous node to point to the next node (ie skip current in the chain)
			nodePrev.setNext(nodeCurrent.getNext());
			//Set the item count to zero, just in case, and then remove the reference to current node, and leave it to garbage collection
			nodeCurrent.setItemCount(0);
			nodeCurrent=null;
	} // end of removeAll()
	
	
	public void print(PrintStream out) {
		ListNode<T> current = head;
		out.println(current.getItem() + " | " + current.getItemCount());
		while (current.getNext() != null)
		{
			current=current.getNext();
			out.println(current.getItem() + " | " + current.getItemCount());
		};
	} // end of print()
	
} // end of class LinkedListMultiset