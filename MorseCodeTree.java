package application;

import java.util.ArrayList;

/**
 * @author Paul Abili 
 * This is a MorseCodeTree which is specifically used for the conversion of morse code to english
 */

public class MorseCodeTree implements LinkedConverterTreeInterface<String>{

	TreeNode<String> root;
	
	/**
	 *  Calls the buildTree method
	 */
	
	public MorseCodeTree() {
		root = null;
		buildTree();
	}
	
	/**
	 * Returns a reference to the root
	 * @return reference to root
	 */
	
	public TreeNode<String> getRoot(){
		return root;
	}

	/**
	 * sets the root of the Tree
	 * @param newNode a TreeNode<String> that will be the new root
	 */
	
	public void setRoot(TreeNode<String> newNode) {
		root = new TreeNode<String>(newNode);
	}



	/**
	 * Adds result to the correct position in the tree based on the code
	 * This method will call the recursive method addNode
	 * 
	 * @param code the code for the new node to be added
	 * 
	 */

	public void insert(String code, String result) {
		if(root == null){
			root = new TreeNode<String>(result);
		} else {
			addNode(root,code,result);
		}
	}

	/**
	 * This is a recursive method that adds element to the correct position 
	 * in the tree based on the code.
	 * 
	 * @param root the root of the tree for this particular recursive instance of addNode
	 * @param code the code for this particular recursive instance of addNode
	 * @param letter the data of the new TreeNode to be added
	 */
	
	public void addNode(TreeNode<String> root, String code, String letter) {
		if(code.length() > 1) {
			if(code.charAt(0) == '-') {
				addNode(root.rightNode, code.substring(1),letter);
			} else {
				addNode(root.leftNode,code.substring(1),letter);
			}
		} else {
			if(code.equals(".")) {
				root.leftNode = new TreeNode<String>(letter);
			} else {
				root.rightNode = new TreeNode<String>(letter);

			}
		}

	}
	
	/**
	 * Fetch the data in the tree based on the code
	 * This method will call the recursive method fetchNode
	 * 
	 * @param code the code that describes the traversals within the tree
	 * @return the result that corresponds to the code
	 */
	
	public String fetch(String code) {
		String letter = fetchNode(root,code);
		return letter;
	}

	/**
	 * This is the recursive method that fetches the data of the TreeNode
	 * that corresponds with the code
	 * 
	 * @param root the root of the tree for this particular recursive instance of addNode
	 * @param code the code for this particular recursive instance of fetchNode
	 * @return the data corresponding to the code
	 */
	
	public String fetchNode(TreeNode<String> root, String code) {
		String letter = "";
		if(code.length() > 1) {
			if(code.charAt(0) == '.') {
				letter += fetchNode(root.leftNode, code.substring(1));
			}
			else {
				letter += fetchNode(root.rightNode, code.substring(1));
			}

		} else {
			if(code.equals(".")) {
				letter += root.leftNode.getData();
				return letter;
			}
			else {
				letter += root.rightNode.getData();
				return letter;
			}
		}
		return letter;
	}

	/**
	 * This operation is not supported for a LinkedConverterTree
	 * @param data data of node to be deleted
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException
	 */
	
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}



	/**
	 * This operation is not supported for a LinkedConverterTree
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException
	 */
	
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}


	/**
	 * This method builds the LinkedConverterTree by inserting TreeNodes<T>
	 * into their proper locations
	 * 
	 */
	
	public void buildTree() {
		String[] codeArray = {"",".","-","..",".-",
				"-.","--","...","..-",".-.",".--","-..","-.-",
				"--.","---","....", "...-","..-.",".-..",".--.",
				".---","-...","-..-","-.-.","-.--","--..","--.-"};

		String[] letterArray = {"","e","t","i","a","n","m",
				"s","u","r","w","d","k","g","o","h","v","f","l","p",
				"j","b","x","c","y","z","q"};
		for(int i = 0; i < codeArray.length; i++) {
			insert(codeArray[i],letterArray[i]);
		}
	}

	/**
	 * Returns an ArrayList of the items in the linked converter Tree in LNR (Inorder) Traversal order
	 * Used for testing to make sure tree is built correctly
	 * @return an ArrayList of the items in the linked Tree
	 */
	
	public ArrayList<String> toArrayList(){
		ArrayList<String> myList = new ArrayList<String>();
		LNRoutputTraversal(root,myList);
		return myList;
	}


	/**
	 * The recursive method to put the contents of the linked converter tree in an ArrayList<T> 
	 * LNR (Inorder)
	 * @param root the root of the tree for this particular recursive instance
	 * @param list the ArrayList that will hold the contents of the tree in LNR order
	 */
	
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list){
		if(root.leftNode == null && root.rightNode == null) {
			list.add(root.getData() + " ");
		} else {
			if(root.leftNode != null) {
				LNRoutputTraversal(root.leftNode,list);
				list.add(root.getData() + " ");
			}
			if(root.rightNode != null) {
				LNRoutputTraversal(root.rightNode,list);
			}
		}
	}



}
