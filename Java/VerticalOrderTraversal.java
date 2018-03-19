package BinarySearchTree;
import java.util.*;


public class VerticalOrderTraversal {
	
	
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
	
	
	public static List<List<Integer>> verticalTraversal() {
		List<List<Integer>> result = new ArrayList<>();		
		if(root == null) {
			return result;
		}
		
		HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
		LinkedList<Node> queue = new LinkedList<>();
		LinkedList<Integer> level = new LinkedList<>();
		
		queue.offer(root);
		level.offer(0);
		
		int minLevel = 0; 
		int maxLevel = 0;
		
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			int l = level.poll();
			
			minLevel = Math.min(l, minLevel);
			maxLevel = Math.max(l, maxLevel);
			
			if(map.containsKey(l)) {
				map.get(l).add(n.data);
			}
			
			else {
				ArrayList<Integer> templist = new ArrayList<>();
				templist.add(n.data);
				map.put(l, templist);
			}
			
			if(n.left!=null) {
				queue.offer(n.left);
				level.offer(l-1);
			}
			
			if(n.right!=null) {
				queue.offer(n.right);
				level.offer(l+1);
			}
		}
		
		for(int i=minLevel; i<=maxLevel;i++) {
			if(map.containsKey(i)) {
				result.add(map.get(i));
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		VerticalOrderTraversal obj = new VerticalOrderTraversal();
		obj.insert(10);
		obj.insert(99);
		obj.insert(1);
		obj.insert(29);
		obj.insert(30);
		obj.insert(31);
		obj.insert(43);
		obj.insert(100);
		obj.insert(5);
		
		List<List<Integer>> result = verticalTraversal();
		
		for(List<Integer> li : result) {
			System.out.println(li);
		}
	}
	

}
