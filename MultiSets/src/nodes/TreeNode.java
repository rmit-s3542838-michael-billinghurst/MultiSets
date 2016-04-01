package nodes;

public class TreeNode<T> {

	private T item;
	private int itemCount;
	private TreeNode<T> leftNode;
	private TreeNode<T> rightNode;
	
	public TreeNode(T newItem) {
		setItem(newItem);
		setItemCount(1);
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
