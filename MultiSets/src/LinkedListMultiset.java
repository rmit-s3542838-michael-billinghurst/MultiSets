
import java.io.PrintStream;
import java.util.*;

import linkedList.Node;

public class LinkedListMultiset<T> extends Multiset<T>
{
	public LinkedListMultiset() {
			
	} // end of LinkedListMultiset()
	
	/* A Linked List is a series of nodes that points to the next node in the list.
	 * The List object knows the location of the first node in the list, and can use it's methods
	 * To loop through the nodes which all point to the next one in the list*/
	Node<T> head = new Node<T>() ;
	//nodeCount is the number of nodes, or unique items.
	//itemCount is the total number of items (including duplicate items)
	int nodeCount=0;
	int itemCount=0;
	
	public void add(T item) {
		//Create a node for the item
		Node<T> nodeTemp = new Node<T>(item);
		//Check if there are any items in the list, and if not, make the new item the head.
		if (head.getItem()==null)
			head=nodeTemp;
		else
		{
			Node<T> nodeCurrent = head;
			/*Loop through the list until you reach the last node (ie a node where next==null)
			 * Or find the current a duplicate entry in the list (Note comparison here intentionally checks for the same object, not identical ones
			 * [That is it compares by object reference not value])*/
			while (nodeCurrent.getNext() != null && nodeCurrent.getItem()!=item)
			{
				nodeCurrent= nodeCurrent.getNext();
			}
			//Stops here, either at the end of the list, or at the node that already contains a number of 'item'
			 if (nodeCurrent.getItem()==item)
			{
				 //If a node for item already exists in the list, increment the itemCount of that node and of the linked list
				nodeCurrent.incrementItemCount();
				itemCount++;
			}
			else  if (nodeCurrent.getNext()==null)
			{
				//add the new Node to the end of the list, if item doesn't occur in the list already
				nodeCurrent.setNext(nodeTemp);
				//Increment the counters in the linked list
				nodeCount++;
				itemCount++;
			}
			else
				//Fail safe for debugging, should never occur in runtime.
				System.out.println("DEBUG: ERROR IN ADD, FAILED TO FIND EXISTING NODE");
		}
	} // end of add()
	
	
	public int search(T item) {
		//Start search of the head of the list,
		Node<T> nodeCurrent = head;
		int index=0;
		//Check if the head is the node containing item
		if (nodeCurrent.getItem()==item)
			return index;
		//Loop through the entire list searching for the item
		while (nodeCurrent.getNext() != null)
		{
			nodeCurrent= nodeCurrent.getNext();
			index++;
			//If the item is found, return the current Index
			if (nodeCurrent.getItem()==item)
				return index;
		}
		//If the end of the list is reached, return -1
		return -1;
	} // end of add()
	
	
	public void removeOne(T item) {
		// Implement me!
	} // end of removeOne()
	
	
	public void removeAll(T item) {
		// Implement me!
	} // end of removeAll()
	
	
	public void print(PrintStream out) {
		// Implement me!
	} // end of print()
	
} // end of class LinkedListMultiset