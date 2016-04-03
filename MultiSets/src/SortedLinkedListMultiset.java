import java.io.PrintStream;
import java.util.*;

import nodes.ListNode;
/*This reuses a great deal of code from LinkedListMultiset, and would make more sense to extend there, 
 * but I didn't want to code skeleton that was supplied*/
public class SortedLinkedListMultiset<T> extends Multiset<T>
{
	public SortedLinkedListMultiset() {
		head = new ListNode<T>();
	}
		/* A Linked List is a series of nodes that points to the next node in the list.
		 * The List object knows the location of the first node in the list, and can use it's methods
		 * To loop through the nodes which all point to the next one in the list
		 * This list needs to be maintained in a sorted order*/
		private ListNode<T> head;
		// end of SortedLinkedListMultiset()
	
	
	public void add(T item) {
		ListNode<T> nodeTemp = new ListNode<T>(item);
		//Check if there are any items in the list, and if not, make the new item the head then exit function.
		String target=(String)item;
		if (head.getItem()==null)
			head=nodeTemp;
		else
		{
			ListNode<T> nodeCurrent = head;
			/*Loop through the list until you reach the last node (ie a node where next==null) or
			 * You reach either an existing element of item in the list, or you find that it is not in the list,
			 * and reach where it should be by comparison, since the list is sorted*/
			while ((nodeCurrent.getNext() != null) &&(target.compareTo((String)nodeCurrent.getItem()) >0 ) )
			{
				{
					nodeCurrent=nodeCurrent.getNext();
				}
			}
			//if the current node is item, increment the item count
			if (item.equals(nodeCurrent.getItem()))
			{
				nodeCurrent.incrementItemCount();
			}
			//otherwise, if the target after String comes after the node, insert the target node into the linked list
			else if (target.compareTo( (String)nodeCurrent.getItem() ) >0 )
			{
				nodeTemp.setNext(nodeCurrent.getNext());
				nodeCurrent.setNext(nodeTemp);
			}
		}
		
	} // end of add()
	
	
	public int search(T item) {
		//Start search of the head of the list
		ListNode<T> nodeCurrent = head;
		/*Loop through the list, while the current node is lexigraphically before item.
		 * When this loop terminates, nodeCurrent should be either item, or the first 
		 * item after the searched for itemLexigraphically*/
		while ( ((String)item).compareTo(((String)nodeCurrent.getItem()))<0 )
		{
			nodeCurrent= nodeCurrent.getNext();
		}
		if (nodeCurrent.getItem().equals(item))
			return nodeCurrent.getItemCount();
		//If the end of the list is reached, return 0, as there are no items in the list
		return 0;
	}
	
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
	
} // end of class SortedLinkedListMultiset