package leetcode;
import java.util.*;
public class MergeTwoLists {
	class ListNode{
		int val;
		ListNode next;
		
		public ListNode(int val) {
			this.val = val;
		}
	}
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>(){
            public int compare(ListNode l1, ListNode l2){
                return l1.val - l2.val;
            }
        });
        
        ListNode curr  = l1;
        ListNode curr2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode newNode = dummy;
        while(curr!=null){
            queue.add(curr);
            curr = curr.next;
        }
        
        while(curr2!=null){
            queue.add(curr2);
            curr2 = curr2.next;
        }
        
        while(!queue.isEmpty()){
            newNode.next = queue.poll();
            newNode = newNode.next;
        }
            
        return dummy.next;
    }

}
