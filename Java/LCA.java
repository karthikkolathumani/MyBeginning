import java.util.*;
public class LCA {
	Node root;
	Node focus;
	Node parent;
	//static ArrayList<Node> result = new ArrayList<>();
	static ArrayList<Node> path = new ArrayList<>();
	
class Node{
		Node left;
		Node right;
		int value;
		public Node(int val) {
			left = null;
			right = null;
			value = val;
		}
		
		
	}
	
	public LCA() {
		//parent =null;
		root=null;
		//focus = root;
	}
	
	public boolean insertRec(int val){


		Node newNode = new Node(val);
		if(root==null) {
			root = newNode;
			return true;
		}
		
		else {
			focus = root;
			while(true) {
				parent = focus;
				if(val<focus.value) {
					focus = focus.left;
					if(focus==null) {
						parent.left = newNode;
						return true;
					}
				}
				if(val>focus.value) {
					focus = focus.right;
					if(focus==null) {
						parent.right = newNode;
						return true;
					}
				}
			}
		}
		
	}
	
	public void inOrder() {

		inOrderTraverse(root);
	}
	
	public static void inOrderTraverse(Node root) {


		if(root!=null) {
			inOrderTraverse(root.left);
			System.out.println(root.value);
			inOrderTraverse(root.right);
		}
	}
	
	
	public ArrayList<Node> search(int val) {
		path.clear();
		focus = root;
		if(root.value==val) {
			path.add(focus);
			return path;
		}
		
		if(focus.left!=null || focus.right!=null) {
			path.add(focus);
			parent = focus;
			while(true) {
				parent = focus;
				
				if(val<focus.value) {
					focus = focus.left;
					path.add(focus);
					if(focus.value==val) {
						return path;
					}
				}
				
				if(val>focus.value) {
					focus = focus.right;
					path.add(focus);
					if(focus.value==val) {
						return path;
					}
				}
			}

		}
		
		else {
			System.out.println("Not Found Nigga!");
			return path;
		}
	}
	
	public static int lowestCommonA(int a, int b) {
		LCA tTreeS = new LCA();
		ArrayList<Node> path1 = new ArrayList<>();
		ArrayList<Node> path2 = new ArrayList<>();
		tTreeS.search(a);
		for(Node n:path) {
			path1.add(n);
		}
		
		tTreeS.search(b);
		for(Node n:path) {
			path2.add(n);
		}
		
		path1.retainAll(path2);
		return path1.get(0).value;
		
	}
	
	
	public static void main(String[] args) {
		LCA tTree = new LCA();
		tTree.insertRec(10);
		tTree.insertRec(1);
		tTree.insertRec(0);
		tTree.insertRec(90);
		tTree.insertRec(30);
		lowestCommonA(30,0);
		
		
		
	}
	

}
