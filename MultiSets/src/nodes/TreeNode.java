package nodes;

public class TreeNode<T> {

	private T item;
	private int itemCount;
	private TreeNode<T> leftNode;
	private TreeNode<T> rightNode;
	
	public TreeNode(T newItem) {
		setItem(newItem);
		setItemCount(1);
		setLeftNode(null);
		setRightNode(null);
	}
/*	public TreeNode() {
		setItem(null);
		setItemCount(0);
		setLeftNode(null);
		setRightNode(null);
	}*/
	//Checks item against the contents of the node and returns the next node in the tree corresponding to the node.
	
	public TreeNode<T> checkNode(T item){
		if (((String)item).compareTo((String)this.item)>0)
			return rightNode;
		else if (((String)item).compareTo((String)this.item)<0)
			return leftNode;
		else return this;
	}
	
	public void incrementItemCount() {
		itemCount++;
	}
	public void deincrementItemCount() {
		itemCount--;
	}

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}

	public TreeNode<T> getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(TreeNode<T> leftNode) {
		this.leftNode = leftNode;
	}

	public TreeNode<T> getRightNode() {
		return rightNode;
	}

	public void setRightNode(TreeNode<T> rightNode) {
		this.rightNode = rightNode;
	}

}
