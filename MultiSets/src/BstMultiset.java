import java.io.PrintStream;
import java.util.*;

import nodes.TreeNode;

public class BstMultiset<T> extends Multiset<T>
{
	private TreeNode<T> root;
	
	public BstMultiset() {
		root=null;
	} // end of BstMultiset()

	public void add(T item) {
		//New node is the node with the new data that needs to be added. If the data already exists in the tree, this node is not used
		TreeNode<T> newNode = new TreeNode<T>(item);
		//if the tree is empty, the new node becomes the root
		if (root==null)
			root=newNode;
		else 
		{
			//Searches through the tree to find the node where item should belong.
			TreeNode<T> parentNode=root;
			TreeNode<T> currentNode = parentNode.checkNode(item);
			//If the node exists, it is currentNode=parentNode, if it doesn't, it will be null (after the loop)
			while (currentNode !=null && currentNode!=parentNode)
			{
				parentNode=currentNode;
				//Check node is a function of the node that returns the next node where item should be searched for
				currentNode=parentNode.checkNode(item);
			}
			if (currentNode==parentNode)
				currentNode.incrementItemCount();
			if (currentNode==null)
				if (((String)item).compareTo((String)parentNode.getItem())>0)
					parentNode.setRightNode(newNode);
				else
					parentNode.setLeftNode(newNode);
		}
	} // end of add()


	public int search(T item) {
		TreeNode<T> current = root;
		do{
			TreeNode<T> next =current.checkNode(item);
			if (current==next)
				return current.getItemCount();
			current=next;
		} while (current!=null);
		//if current == null, then the item isn't in the tree.
		return 0;
	} // end of add()


	public void removeOne(T item) {
		TreeNode<T> current = root;
		do{
			TreeNode<T> next =current.checkNode(item);
			if (current==next)
			{
				current.deincrementItemCount();
				return;
			}
		} while (current!=null);
	} // end of removeOne()
	
	
	public void removeAll(T item) {
		TreeNode<T> current = root;
		TreeNode<T> parent = root;
		do{ //TODO doesn't work if item is in the root?
			TreeNode<T> next =current.checkNode(item);
			if (current==next)
			{
				//Tree needs to be restructured so that it maintains BST structure without the current node
				if (current.getLeftNode()==null)
				{
					if (current.getRightNode()==null)
					{
						//Here the current node has no children
						if (parent.getLeftNode()==current)
							parent.setLeftNode(null);
						else
							parent.setRightNode(null);
					}
					//Here Current has a single node to the right
					if (parent.getLeftNode()==current)
						parent.setLeftNode(current.getRightNode());
					else
						parent.setRightNode(current.getRightNode());
				}
				else
				{
					//Here Current has a node to the left
					if (current.getRightNode()==null)
					{
						//Here Current has a single node to the left
						if (parent.getLeftNode()==current)
							parent.setLeftNode(current.getLeftNode());
						else
							parent.setRightNode(current.getLeftNode());
					}
					else
					{
						/*Here Current has two children. Since we can't directly remove this node without breaking the tree
						 * We need to find the successor, the next item in the tree directly after item in sorting order, to replace it with*/
						TreeNode<T> successor=current.getRightNode();
						while (successor.getLeftNode()!=null)
						{
							successor=successor.getLeftNode();
						}
						/*Having found the successor, we overwrite the values of the node we wish to delete with those of it's successor
						 * Essentially deleting the current node, and then call remove all to delete the original successor node recursively*/
						current.setItem(successor.getItem());
						current.setItemCount(successor.getItemCount());
						removeAll(successor.getItem());
					}
						
				}
				return;
			}
			parent=current;
			current=next;
		} while (current!=null);
	} // end of removeAll()


	public void print(PrintStream out) {
		//Call the printTree recursive print
		printTree(root,out);
	} // end of print()
	
	//Recursive method for printing tree in order
	public void printTree(TreeNode<T> node, PrintStream out){
		if (node!=null)
		{
			printTree(node.getLeftNode(),out);
			out.println(node.getItem() + " | " + node.getItemCount());
			printTree(node.getRightNode(),out);
			
		}
	}

} // end of class BstMultiset
