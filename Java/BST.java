
public class BST {
	
	class Node{
		public int iData;
		public double dData;
		public Node leftChild;
		public Node rightChild;
		
		public void displayNode() {
			System.out.print(" {");
			System.out.print(iData);
			System.out.print(",");
			System.out.print("} ");
		}
	}
	
	private Node root;
	
	public BST() {
		root = null;
	}
	////////////////////////////////////////////////////////////
	
	public Node find(int data) {
		Node current = root;
		
		while(true) {
			if(current == null) 
				return null;
			
			if(current.iData == root.iData) {
				return root;
			}
			
			if(current.iData > data) {
				current = current.leftChild;
				if(current.iData == data) {
					return current;
				}
			}
			
			if (current.iData <= data) {
				current = current.rightChild;
				if(current.iData == data)
					return current;
			}

		}

	}
	
	//////////////////////////////////////////////////////////////
	
	public void insert(int data, double dData) {
		 Node current = root;
		 Node parent  = root;
		 Node newNode  = new Node();
		 newNode.iData = data;
		 newNode.dData = dData;
		 
		 if(current == null) {
			 root = newNode;
		 }
		 
		 else {
			 while(true) {
				 
				 parent = current;
				 if(current.iData > data) {
					 current = current.leftChild;
					 if(current == null) {
						 parent.leftChild = newNode;
						 return;
					 }
				 }
				 
				 else {
					 current = current.rightChild;
					 if(current == null) {
						 parent.rightChild = newNode;
					 	return;
					 }
				 }
			 }
		 }
	}
	
	
/*	public void insert1(int iData, double data) {
		Node current = root;
		Node parent = root;
		Node newNode = new Node();
		newNode.iData = iData;
		newNode.dData = data;
		
		if(current == null) {
			root = newNode;
		}
		
		else {
			while(current != null) {
				
				parent = current;
				
				if(current.iData > iData) {
					current = current.leftChild;
				}
				
				else
					current = current.rightChild;
				
			}
			parent = newNode;
		}
	}*/
	
	///////////////////////////////////////////////////////
	
	public void inorderTraversal() {
		inorder(root);
	}
	
	public void inorder(Node n) {
		if(n != null) {
			inorder(n.leftChild);
			System.out.println(n.iData + " - "+ n.dData);
			inorder(n.rightChild);
		}
	}
	
	//////////////////////////////////////////////////////////////
	
	public boolean delete(int key) {
		Node current = root;
		Node parent = root;
		boolean isLeftChild = true;
		
		// Search for Node
		while(current.iData != key) {
			parent = current;
			
			if(key < current.iData) {
				isLeftChild = true;
				current = current.leftChild;
				
			}
			else {
				isLeftChild = false;
				current = current.rightChild;
			}
			
			if(current == null)
				return false;
		}
		
		// IF THERE ARE NO CHILDREN, SIMPLY DELETE IT
		
		if(current.leftChild == null && current.rightChild == null) {
			if(current == root) root = null;
			if(isLeftChild) parent.leftChild =null;
			else parent.rightChild = null;
		}
		
		
		// IF THERE IS NO RIGHT SUB TREE, REPLACE WITH LEFT SUBTREE
		else if(current.rightChild == null) {
			if(current == root) root = null;
			if(isLeftChild) parent.leftChild = current.leftChild;
			else parent.rightChild = current.leftChild;
			
		}
		
		// IF THERE IS NO LEFT SUB TREE, REPLACE WITH 
		else if(current.leftChild == null) {
			if(current == root) root = null;
			if(isLeftChild) parent.leftChild = current.rightChild;
			else parent.rightChild = current.rightChild;
		}
		
		
		// IF THERE ARE TWO CHILDREN FOR THE NODE BE DELETED. HECK!! COMPLICATED!!!
		// FIND THE SUCCESSOR of the node to be deleted
		
		else {
			Node successor = getSuccessor(current);
			
			if(current == root) {
				root = successor;
			}
			
			else if(isLeftChild)
				parent.leftChild = successor;
			else
				parent.rightChild = successor;
			
			successor.leftChild = current.leftChild;
		}
		return true;
	}
	
	public Node getSuccessor(Node delNode) {
		Node successor = delNode;
		Node parent = delNode;
		Node current = delNode.rightChild;
		
		while(current != null) {
			parent = successor;
			successor = current;
			current = current.leftChild;
		}
		
		if(successor != delNode.rightChild) {
			parent.leftChild = 	successor.rightChild;
			successor.rightChild = delNode.rightChild;
		}
		
		return successor;
		
	}
	
	
	///////////////////////////////////////////////////////////
	
	public static void main(String[] args) {
		BST theTree = new BST();
		
		theTree.insert(50, 1.5);
		theTree.insert(21, 4.3);
		theTree.insert(70,8.9);
		theTree.insert(120,3.2);
		theTree.insert(32,4.5);
		theTree.insert(90,5.9);
		theTree.delete(50);
		theTree.inorderTraversal();
	}
	
	
	
	

}
