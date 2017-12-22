
public class TreePractice {
	Node root;
	class Node{
		int val;
		Node left;
		Node right;
		
		public Node(int val) {
			this.val = val;
			left = null;
			right = null;
		}
	}
	
	
	public TreePractice() {
		root = null;
	}
	
	public boolean insertRec(int val) {
		Node newNode = new Node(val);
		if(root==null) {
			root = newNode;	
			return true;
		}
		
		else {
			Node focusNode;
			Node parent;
			focusNode = root;
			
			while(true) {
				parent = focusNode;
							
				if(val<=focusNode.val) {
					focusNode = focusNode.left;
					if(focusNode==null) {
						parent.left = newNode;
						return true;
					}
					
					
				}
				
				else {
					focusNode = focusNode.right;
					if(focusNode==null) {
						parent.right = newNode;
						return true;
					}
				}
				
			}
		}
		
		
	}
	
	
	public Node[] search(int val) {
		Node focusNode;
		Node parent = null;
		Node [] parentChild = new Node[2];
		focusNode = root;
		while(focusNode.val!=val) {
			parent = focusNode;
			if(val<focusNode.val) {
				focusNode = focusNode.left;
			}
			else {
				focusNode = focusNode.right;
			}
			
			if(focusNode==null) {
				return null;
			}
			
		}
		if(parent!=null) {
		parentChild[0] = focusNode;
		parentChild[1] = parent;
		}
		else {
			parentChild[0] = focusNode;
			parentChild[1] = null;
		}
		if(parent!=null) {
		System.out.println("Found Node : " + focusNode.val + " with Parent value: "+ parent.val);
		}
		else {
			System.out.println("Single Found Node : " + focusNode.val);
		}
		return parentChild;
	}
	
	
	public boolean deleteNode(int val) {
	
		Node delete[] = search(val);
		Node nodeToDelete = delete[0];
		Node nodeToDelParent = delete[1];
		
		if(nodeToDelParent==null) {
			System.out.println("Loop 1");
			Node focus;
			
			if(nodeToDelete.left==null && nodeToDelete.right==null) {
				root=null;
				System.out.println("Tree is now empty");
				return true;
			}
			
			if(nodeToDelete.left!=null && nodeToDelete.right==null) {
				root = root.left;
				return true;
			}
			if(nodeToDelete.right!=null && nodeToDelete.left==null) {
				root = root.right;
				return true;
			}
			if(nodeToDelete.left!=null && nodeToDelete.right!=null) {
				focus = nodeToDelete.right;
				Node Parent = null;
				while(focus!=null) {
					Parent =focus;
					focus = focus.left;
				}
				//System.out.println(Parent.val);
				root.val = Parent.val;
				root.right =null;
				
				return true;
			}
			

			
		}
		//Node has no children 
		if(nodeToDelete.left==null && nodeToDelete.right==null) {
			System.out.println("Loop 2");
						
			if(val<nodeToDelParent.val) {
				nodeToDelParent.left = null;
			}
			else {
				nodeToDelParent.right = null;
			}
			return true;
		}
		
		//Node has a single Child
		
		if(nodeToDelete.left!=null && nodeToDelete.right==null) {
			System.out.println("Loop 3");
			Node focus;
			focus = nodeToDelete.left;
			if(val<nodeToDelParent.val) {
				nodeToDelParent.left = focus;
			}
			if(val>nodeToDelParent.val) {
				nodeToDelParent.right = focus;
			}
			return true;
		}
		if(nodeToDelete.right!=null && nodeToDelete.left==null) {
			Node focus;
			focus = nodeToDelete.right;
			if(val<nodeToDelParent.val) {
				nodeToDelParent.left = focus;
			}
			if(val>nodeToDelParent.val) {
				nodeToDelParent.right = focus;
			}
			return true;
		}
		
		
		
		if(nodeToDelete.left!=null && nodeToDelete.right!=null) {
			System.out.println("Loop 4");
			Node focus;
			Node Parent = null;
			focus = nodeToDelete.right;
			while(focus!=null) {
				Parent =focus;
				focus = focus.left;
			}
			//System.out.println(Parent.val);
			nodeToDelete.val = Parent.val;
			Parent =null;
			//System.out.println(Parent.val);
			return true;

		}

		
		return false;
	}
	
	
	public void inOrder() {
		inOrderTraversal(root);
	}
	
	public void inOrderTraversal(Node root) {
		if(root!=null) {
			inOrderTraversal(root.left);
			System.out.println(root.val);
			inOrderTraversal(root.right);
		}
	}
	
	
	
	
	public static void main(String[] args) {
		TreePractice tTree = new TreePractice();
		tTree.insertRec(10);
		tTree.insertRec(9);
		tTree.insertRec(1);
		tTree.insertRec(80);
		tTree.insertRec(8);
		tTree.inOrder();
		
		//tTree.search(11);
		
		tTree.deleteNode(80);
		tTree.inOrder();
		
	}
	

}
