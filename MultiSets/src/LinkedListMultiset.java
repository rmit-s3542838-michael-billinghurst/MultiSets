
import java.io.PrintStream;
import java.util.*;

import linkedList.Node;

public class LinkedListMultiset<T> extends Multiset<T>
{
	public LinkedListMultiset() {
			
	} // end of LinkedListMultiset()
	
	Node<T> head;
	//nodeCount is the number of nodes, or unique items.
	//itemCount is the total number of items (including duplicate items)
	int nodeCount=0;
	int itemCount=0;
	
	public void add(T item) {
		Node nodeTemp = new Node(item);
		Node nodeCurrent = head;
		//Loop through the list until you reach the last node (ie a node where next==null)
		while (nodeCurrent.getNext() != null)
		{
			nodeCurrent= nodeCurrent.getNext();
		}
		nodeCurrent.setNext(nodeTemp);
		nodeCount++;
		itemCount++;
	} // end of add()
	
	
	public int search(T item) {
		// Implement me!		
		
		// default return, please override when you implement this method
		return 0;
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