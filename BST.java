/**
 *  This class implements a BST.
 *  
 *  @param <T> the type of the key.
 *
 *  @author W. Masri and Drew Reynolds
 */
class BST<T extends Comparable<T>> {
	// **************//
	// DO NO CHANGE
	
	/**
	 *  Node class.
	 *  @param <T> the type of the key.
	 */
	class Node<T extends Comparable<T>> 
	{
		/**
		*  key that uniquely identifies the node.
		*/
		T key;
		/**
		*  references to the left and right nodes.
		*/
		Node<T> left, right;
		public Node(T item) {  key = item; left = right = null; }
		public String toString() { return "" + key; }
	}
	
	/**
	 *  The root of the BST.
	 */
	Node<T> root; 
	public BST() { root = null; }
	public String toString() { return inorderToString(); }
	// DO NO CHANGE
	// **************//
	
	
	/**
	 *  This method returns a string in which the elements are listed in an inorder fashion. 
	 *  Your implementation must be recursive.
	 *  Note: you can create private helper methods
	 *  @return string in which the elements are listed in an inorder fashion
	 */
	public String inorderToString() {
		// YOUR CODE GOES HERE

		String string = recursiveToString(root);
		if (string.length() > 0) {
			string = string.substring(1);
		}

		return string;
	}


	/**
	 * Private helper method to recursivly print the tree.
	 * @param currNode The current node that is being looked at
	 * @return The full string of every BST value
	 */
	private String recursiveToString(Node<T> currNode) {

		String string = "";

		if (currNode != null) {
			string += recursiveToString(currNode.left);
			string += " \"" + currNode.key + "\"";
			string += recursiveToString(currNode.right);
		}

		return string;

	}
	
	/**
	 *  This method inserts a node in the BST. You can implement it iteratively or recursively.
	 *  Note: you can create private helper methods
	 *  @param key to insert
	 */
	public void insert(T key) {
		// YOUR CODE GOES HERE

		// Edge case where it is the first element
		if (root == null) {
			root = new Node<T>(key);
		}

		else {
			boolean beenInserted = false;
			Node<T> currNode = root;

			while (!beenInserted) {

				// If the key should be put on currNode's left
				if (key.compareTo(currNode.key) < 0) {
					if (currNode.left == null) {
						currNode.left = new Node<T>(key);
						beenInserted = true;
					}
					else {
						currNode = currNode.left;
					}
				}

				// If the key should be put on currNode's right
				else if (key.compareTo(currNode.key) > 0) {
					if (currNode.right == null) {
						currNode.right = new Node<T>(key);
						beenInserted = true;
					}
					else {
						currNode = currNode.right;
					}
				}

				// If the key already exists in the tree, don't insert
				else if (key.compareTo(currNode.key) == 0) {
					beenInserted = true;
				}
			}
		}
		
	}
	
	/**
	 *  This method finds and returns a node in the BST. You can implement it iteratively or recursively.
	 *  It should return null if not match is found.
	 *  Note: you can create private helper methods
	 *  @param key to find
	 *  @return the node associated with the key.
	 */
	public Node<T> find(T key)	{ 					
		// YOUR CODE GOES HERE

		Node<T> currNode = root;

		while (currNode != null) {

			// If the item is found
			if (key.compareTo(currNode.key) == 0) {
				return currNode;
			}

			// If the key should be found on currNode's left
			if (key.compareTo(currNode.key) < 0) {
				currNode = currNode.left;
			}

			// If the key should be put on currNode's right
			else if (key.compareTo(currNode.key) > 0) {
				currNode = currNode.right;
			}

		}

		return null;
	}	 
	

	/**
	 *  Main Method For Your Testing -- Edit all you want.
	 *  
	 *  @param args not used
	 */
	public static void main(String[] args) {
		/*
							 50
						  /	      \
						30    	  70
	                 /     \    /     \
	                20     40  60     80   
		*/
		
		
		BST<Integer> tree1 = new BST<>();
		tree1.insert(50); tree1.insert(30); tree1.insert(20); tree1.insert(40);
		tree1.insert(70); tree1.insert(60); tree1.insert(80);
		
		if (tree1.find(70) != null) {
			System.out.println("Yay1");
		}
		if (tree1.find(90) == null) {
			System.out.println("Yay2");
		}
		if (tree1.toString().equals("\"20\" \"30\" \"40\" \"50\" \"60\" \"70\" \"80\"") == true) {
			System.out.println("Yay3");
		}
		
		
		BST<String> tree2 = new BST<>();
		tree2.insert("50"); tree2.insert("30"); tree2.insert("20"); tree2.insert("40");
		tree2.insert("70"); tree2.insert("60"); tree2.insert("80");
		
		if (tree2.find("70") != null) {
			System.out.println("Yay4");
		}
		if (tree2.find("90") == null) {
			System.out.println("Yay5");
		}
		if (tree2.toString().equals("\"20\" \"30\" \"40\" \"50\" \"60\" \"70\" \"80\"") == true) {
			System.out.println("Yay6");
		}
	}
	
}
