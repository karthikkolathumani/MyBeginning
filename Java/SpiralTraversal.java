package BinarySearchTree;
import java.util.*;
public class SpiralTraversal {
	class Node {
		Node left;
		Node right;
		int data;
	}

	static Node root;
	static ArrayList<Node> result = new ArrayList<>();
	public boolean insert(int val) {
		Node newNode = new Node();
		newNode.data = val;
		if (root == null) {
			root = newNode;
			return true;
		} else {
			Node curr = root;
			Node prev = root;
			boolean isLeft = false;
			while (curr != null) {
				prev = curr;
				if (val < curr.data) {
					isLeft = true;
					curr = curr.left;
				} else {
					isLeft = false;
					curr = curr.right;
				}
			}

			if (isLeft) {
				prev.left = newNode;
				return true;
			} else {
				prev.right = newNode;
				return true;
			}

		}
	}

	public static void traverse(Node root) {
		if (root != null) {
			traverse(root.left);
			System.out.println(root.data);
			traverse(root.right);
		}
	}
	
	
	public static void spiralTravel() {
		if(root == null) {
			System.out.println("No element");
			return;
		}
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();
		Node curr = root;
		s1.push(curr);
		//Node prev = root;
		while(true) {
			//prev = curr;
			
			while(!s1.isEmpty()) {
				Node poped = s1.pop();
				result.add(poped);
				
				if(poped.left!=null)
				s2.push(poped.left);
				
				if(poped.right!=null)
				s2.push(poped.right);
			}
			
			while(!s2.isEmpty()) {
				Node poped = s2.pop();
				result.add(poped);
				
				if(poped.right!=null)
				s1.push(poped.right);
				
				if(poped.left!=null)
				s1.push(poped.left);
			}
			
			if(s2.isEmpty() && s1.isEmpty()) {
				break;
			}
			
		}
	}
	
	public static void main(String[] args) {
		SpiralTraversal obj = new SpiralTraversal();
		obj.insert(30);
		obj.insert(21);
		obj.insert(12);
		obj.insert(1);
		obj.insert(99);
		//obj.traverse(root);
		spiralTravel();
		
		for(Node n:result) {
			System.out.println(n.data);
		}
	}
}
