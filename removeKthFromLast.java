package leetcode;

import java.util.ArrayList;
import java.util.Collections;

public class removeKthFromLast {
	
	class Node{
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
		}
		
		public Node() {}
	}
	
	Node root =null;
	
	public void insert(int data) {
		if(root==null) root = new Node(data);
		else {
			Node curr = root;
			
			while(curr.next!=null) {
				curr = curr.next;
			}
			
			curr.next = new Node(data);
		}
	}
	
	public void traverse() {
		Node curr = root;
		
		while(curr!=null) {
			System.out.println(curr.data);
			curr = curr.next;
		}
	}
	
	
	Node toDelete = null;
	
	public int kthFromTheLast(Node root,int k) {
		
		if(root==null) return 0;
		
		int index = kthFromTheLast(root.next,k)+1;
		if(index==k+1) {
			System.out.println("executed");
			root.next = root.next.next;
		}
		
		
		return index;
		
	}
	
	
	public Node removeNthFromEnd( int n) {
		Node head= root;
		removeKthFromLast obj = new removeKthFromLast();
        obj.kthFromTheLast(head,n);
        
        
        return root;
    }
	
	public Node removeKth(int n) {
	
		Node start = new Node(0);
		Node curr = start;
		Node runner = start;
		
		curr.next = root;
		
		for(int i = 1 ; i <=n+1;i++) {
			runner = runner.next;
		}
		
		while(runner!=null) {
			curr = curr.next;
			runner = runner.next;
		}
		
		curr.next = curr.next.next;
		return start.next;
	}
	
	
	public Node mergeKLists(Node[] lists) {
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i=0;i<lists.length;i++) {
			Node curr = lists[i];
			
			while(curr!=null) {
				list.add(curr.data);
				curr = curr.next;
			}
		}
		
		Collections.sort(list);
		
		Node listis = new Node(0);
		
		for(int i=0;i<list.size();i++) {
			int data = list.get(i);
			Node newNode = new Node(data);
			Node curr = listis.next;
			if(listis.next==null) listis = newNode;
			else {
				while(curr.next!=null) {
					curr = curr.next;
				}
				
				curr.next = newNode;
			}
		}
		return listis.next;
    }
	
	
	public static void main(String[] args) {
		removeKthFromLast obj = new removeKthFromLast();
		obj.insert(1);
		obj.insert(2);
	

		Node head = obj.removeKth(2);
		
		while(head!=null) {
			System.out.println(head.data);
			head = head.next;
		}
		
	}
	
	
}
