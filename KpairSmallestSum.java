package Heaps;
import java.util.*;

public class KpairSmallestSum {

	
	class Pair{
		int indx; 
		Integer sum;
		int[] pair;
		
		public Pair(int indx, int nums1, int nums2) {
			this.indx = indx;
			pair = new int[] {nums1,nums2};
			sum = nums1 + nums2;
		}
	}
	
	class comparePairs implements Comparator<Pair>{
		
		public int compare (Pair a, Pair b) {
			return a.sum.compareTo(b.sum);
		}
		
	}

	
	
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<int[]> ret = new ArrayList<>();
		if(nums1.length==0 || nums2.length==0 || nums1==null || nums2==null) return ret;
		
		PriorityQueue<Pair> minHeap  =  new PriorityQueue<>(new comparePairs());
		
		for(int i = 0 ; i < nums1.length ; i++) {
			Pair n = new Pair(0,nums1[i], nums2[0]);
			minHeap.offer(n);
		}
		
		for(int i = 1; i<=k	&& !minHeap.isEmpty();i++) {
			Pair n = minHeap.poll();
			ret.add(n.pair);
			if(n.indx < nums2.length-1) {
				int next = n.indx ++;
				Pair p = new Pair(next,n.pair[0],nums2[next]);
				minHeap.offer(p);
			}
		}
		
		return ret;
    }
	
	
	
	public static void main(String[] args) {
		int arr [] = {1,2};
		int arr2[]  = {3};
		
	}
	
}
