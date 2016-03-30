import java.io.PrintStream;
import java.util.*;

import linkedList.Node;
/*This reuses a great deal of code from LinkedListMultiset, and would make more sense to extend there, 
 * but I didn't want to code skeleton that was supplied*/
public class SortedLinkedListMultiset<T> extends Multiset<T>
{
	public SortedLinkedListMultiset() {
		head = new Node<T>();
	}
		/* A Linked List is a series of nodes that points to the next node in the list.
		 * The List object knows the location of the first node in the list, and can use it's methods
		 * To loop through the nodes which all point to the next one in the list
		 * This list needs to be maintained in a sorted order*/
		Node<T> head;
		// end of SortedLinkedListMultiset()
	
	
	public void add(T item) {
		Node<T> nodeTemp = new Node<T>(item);
		//Check if there are any items in the list, and if not, make the new item the head then exit function.
		String target=(String)item;
		if (head.getItem()==null)
			head=nodeTemp;
		else
		{
			Node<T> nodePrev = head;
			Node<T> nodeCurrent = head;
			/*Loop through the list until you reach the last node (ie a node where next==null) or
			 * You reach either an existing element of item in the list, or you find that it is not in the list,
			 * and reach where it should be by comparison, since the list is sorted*/
			while ((nodeCurrent.getNext() != null) &&(target.compareTo( (String)nodeCurrent.getItem() ) >0 ) )
			{
				{
					nodePrev=nodeCurrent;
					nodeCurrent=nodeCurrent.getNext();
				}
			}
			//if the current node is item, increment the item count
			if (target.equals(nodeCurrent.getItem()))
			{
				nodeCurrent.incrementItemCount();
			}
			//otherwise, if the after the target string, insert the target node into the linked list
			else if (target.compareTo( (String)nodeCurrent.getItem() ) <0 )
			{
				nodePrev.setNext(nodeTemp);
				nodeTemp.setNext(nodeCurrent);
			}
		}
		
	} // end of add()
	
	
	public int search(T item) {
		//Copied from LinkedList implementation
		//Start search of the head of the list,
		Node<T> nodeCurrent = head;
		//Check if the head is the node containing item
		if (nodeCurrent.getItem()==item)
			return nodeCurrent.getItemCount();
		//Loop through the entire list searching for the item
		while (nodeCurrent.getNext() != null)
		{
			nodeCurrent= nodeCurrent.getNext();
			//If the item is found, return the current Index
			if (nodeCurrent.getItem()==item)
				return nodeCurrent.getItemCount();
		}
		//If the end of the list is reached, return 0, as there are no items in the list
		return 0;
	}
	
	public void removeOne(T item) {
		//Copied from LinkedList implementation
		Node<T> nodeCurrent = head;
		//Loop through the list until the item is found, or the end is reached
		while ((nodeCurrent.getItem()!=item) && (nodeCurrent.getNext()!=null))
		{
			nodeCurrent=nodeCurrent.getNext();
		}
		//If the current node is the item, remove one. If it isn't, it means you've reached the end of the list.
		if (nodeCurrent.getItem()==item)
		{
			nodeCurrent.deincrementItemCount();
		}
	} // end of removeOne()
	
	
	public void removeAll(T item) {
		//Copied from LinkedList implementation
		Node<T> nodeCurrent = head;
		Node<T> nodePrev=new Node<T>();
		//TODO Currently breaks if list is empty, or if item is at the head of the list.
		//Loop through the list until the item is found, or the end is reached
		while ((nodeCurrent.getItem()!=item) && (nodeCurrent.getNext()!=null))
		{
			nodePrev=nodeCurrent;
			nodeCurrent=nodeCurrent.getNext();
		}		//If nodeCurrent contains the item, delete the node
		if (nodeCurrent.getItem()==item)
			//Set the previous node to point to the next node (ie skip current in the chain)
			nodePrev.setNext(nodeCurrent.getNext());
			//Set the item count to zero, just in case, and then remove the reference to current node, and leave it to garbage collection
			nodeCurrent.setItemCount(0);
			nodeCurrent=null;
	} // end of removeAll()
	
	
	public void print(PrintStream out) {
		Node<T> current = head;
		do
		{
			out.print("Item: " +current.getItem());
			out.print("Item count: " +current.getItemCount());
		}while (current.getNext() != null);
	} // end of print()
	
} // end of class SortedLinkedListMultiset