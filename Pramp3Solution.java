
public class Pramp3Solution {

	
	public class Node{
		public int cost;
		public Node[] children;
		public Node parent;
		
		public Node(int cost){
			this.cost = cost;
			children = null;
			parent = null;
					
		}
	}
	
	public void insert() {
		Node root = new Node(10);
		Node t[] = {new Node(5),new Node(3),new Node(6)};
		
	}
	
	
	
	static int getCheapestCost(Node rootNode) {
		if(rootNode.children==null) return rootNode.cost;
		
		else {
			
			int min = Integer.MAX_VALUE;
			
			for(int i =0;i<rootNode.children.length;i++) {
				int sum = getCheapestCost(rootNode.children[i]);
				
				min = Math.min(min, sum);
			}
			return min+rootNode.cost;
		}
		
		
		
	}
	
	public static void main(String[] args) {
		
		
	}
	
	
}
