package application;

/**
 * The external Tree Node for Linked Trees
 * @author Paul Abili
 * @param <T>
 */

public class TreeNode<T> {
	private T dataNode;
	TreeNode<T> leftNode;
	TreeNode<T> rightNode;

	/**
	 * Create a new TreeNode with left and right child set to null and data set to the dataNode
	 * @param dataNode The data to be stored in the TreeNode
	 */

	public TreeNode(T dataNode) {
		this.dataNode = dataNode;
		leftNode = null;
		rightNode = null;
	}

	/**
	 * Creates a Deep Copy of a Node
	 * @param node node to make copy of
	 */

	public TreeNode(TreeNode<T> node) {
		this.dataNode = node.getData();
		leftNode = node.leftNode;
		rightNode = node.rightNode;
	}

	/**
	 * Return the data within this TreeNode
	 * @return dataNode the data within the TreeNode
	 */

	public T getData() {
		return dataNode;
	}

}
