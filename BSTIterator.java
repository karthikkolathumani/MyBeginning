package BinarySearchTrees;

import java.util.*;

public class BSTIterator {

	
	/*
	 * This class uses O(n) space.
	 * It can be done in O(h), every time you pop a node, go to its right child and push all its left child into the stack
	 */
	Stack<Node> stack = new Stack<>();
   
	
	class Node{
		Node left;
		Node right;
		int val;
		public Node(int val) {
			this.val = val;
		}
	}
	
	Node root = null;
	
	public boolean insert(int val) {
		if(root == null) {
			root = new Node(val);
			return true;
		}
		else {
			Node curr = root;
			
			while(curr!=null) {
				if(val <= curr.val) {
					if(curr.left==null) {
						curr.left = new Node(val);
						return true;
					}
					curr = curr.left;
				}else {
					if(curr.right==null) {
						curr.right = new Node(val);
						return true;
					}
					curr = curr.right;
				}
			}
		}
		return false;
	}
	
	

    
    public void fillStack(Node root){
        if(root.right!=null) fillStack(root.right);
        stack.push(root);
        if(root.left!=null) fillStack(root.left);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        return stack.pop().val;
    }
    
    public void fillit() {
    	
    	fillStack(root);
    }
	
    public static void main(String[] args) {
    	BSTIterator obj = new BSTIterator();
    	obj.insert(13);
		obj.insert(3);
		obj.insert(14);
		obj.insert(1);
		obj.insert(4);
		obj.insert(2);
		obj.insert(12);
		obj.insert(10);
		obj.insert(5);
		obj.insert(11);
		obj.insert(8);
		obj.insert(9);
		obj.insert(7);
		obj.insert(6);
		obj.fillit();
		System.out.println(obj.hasNext());
		System.out.println(obj.next());
		System.out.println(obj.next());System.out.println(obj.next());System.out.println(obj.next());System.out.println(obj.next());System.out.println(obj.next());System.out.println(obj.next());
		System.out.println(obj.next());
		System.out.println(obj.next());
		System.out.println(obj.next());
		System.out.println(obj.next());
		System.out.println(obj.next());
		System.out.println(obj.next());
		System.out.println(obj.next());
		System.out.println(obj.next());
	}
    
    
}
