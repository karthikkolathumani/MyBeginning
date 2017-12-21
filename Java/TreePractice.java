
public class TreePractice {
	
	public static void main(String[] args) {
		TreePractice theTree = new TreePractice();
		theTree.insertRec(10, "k");
		theTree.insertRec(30, "k");
		theTree.insertRec(50, "k");
		theTree.insertRec(70, "k");
		theTree.insertRec(0, "k");
		theTree.insertRec(12, "k");
		theTree.insertRec(14, "k");
		theTree.insertRec(12, "k");
		
		theTree.inOrder();
		
		
		System.out.println(theTree.search(11110));
	}
	
	Node root;
	
	class Node{
		int value;
		String name;
		Node left;
		Node right;
		
		public Node(int val, String nam) {
			value = val;
			name = nam;
		}
		
	}
	
	TreePractice(){
		root = null;
		
	}
	
	public boolean insertRec(int val, String nam) {
		Node n = new Node(val,nam);
		
		if(root==null) {
			root = n;
			return true;
		}
		
		else {
			Node focusNode = root;
			Node parent ;
			
			while(true) {
				 parent = focusNode;
				if(val<focusNode.value) {
					focusNode = focusNode.left;
					if(focusNode==null) {
						parent.left = n;
						return true;
					}
				}
				else {
					focusNode = focusNode.right;
					if(focusNode==null) {
						parent.right = n;
						return true;
					}
				}
			}
			
			
		}
		
		
		
		
		}
	
	public void inOrder() {
		inOrderTraversal(root);
	}
	
	
	public void inOrderTraversal(Node root) {
		if(!(root==null)) {
			inOrderTraversal(root.left);
			System.out.println(root.value);
			inOrderTraversal(root.right);
			
		}
	}
	
	
	public boolean search(int val) {
		Node focusNode = root;
		
		while(!(focusNode.value==val)) {
			if(val<focusNode.value) {
				focusNode = focusNode.left;
			}
			else {
				focusNode = focusNode.right;
			}
			
			if(focusNode==null) {
				return false;
			}
		}
		return true;
	}
	
	
	}
	
	


