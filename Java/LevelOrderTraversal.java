package BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;


public class LevelOrderTraversal {

	class Node {
		Node left;
		Node right;
		int data;
	}
	
	static Node root;
	
	
	
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
	
	
	public static void levelOrderTraversal() {
		Queue<Node> q = new LinkedList<>();
		Node curr = root;
		q.add(curr);
		while(!q.isEmpty()) {
			Node poped = q.remove();
			System.out.println(poped.data);
			
			if(poped.left!=null)
			q.add(poped.left);
			
			if(poped.right!=null)
			q.add(poped.right);
		}
		
	}
	
	public static void main(String[] args) {
		LevelOrderTraversal obj = new LevelOrderTraversal();
		obj.insert(30);
		obj.insert(21);
		obj.insert(12);
		obj.insert(1);
		obj.insert(99);
		
		levelOrderTraversal();
	
	}
	
	
	
}
