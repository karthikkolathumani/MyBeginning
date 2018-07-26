package Heaps;
import java.util.*;

public class KfrequentElements {

	public  class element{
		 Integer number;
		  Integer freq;
		
	public element(int a, int b) {
		this.number = a;
		this.freq = b;
	}
		
	}
	
	public  ArrayList<Integer> topKFrequent(int nums[], int k) {
		
		
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		ArrayList<element> list = new ArrayList<>();
		ArrayList<Integer> output = new ArrayList<>();
		for(int i=0 ; i < nums.length ; i++) {
			if(map.containsKey(nums[i])) map.put(nums[i], map.get(nums[i])+1 );
			else map.put(nums[i], 1);
		}
		
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			Integer a = entry.getKey();
			Integer b = entry.getValue();
			element newNode = new element(a,b);
			list.add(newNode);	
			
		}
		
		PriorityQueue<element> maxHeap = new PriorityQueue<>(new Comparator<element>() {
			public int compare(element a, element b) {
				return -1* (a.freq - b.freq);
			}
		});
		
		
		for(int i = 0; i<list.size(); i++) {
			maxHeap.add(list.get(i));
		}
		
		for(int i=0; i<k ;i++) {
			element out = maxHeap.poll();
			output.add(out.number);
		}
		
		
		
		return output;
	}
	
	
	public static void main(String[] args) {
		int arr[] = {1,1,1,2,2,3,3,3,3};
		KfrequentElements obj = new KfrequentElements();
		ArrayList<Integer> out = obj.topKFrequent(arr,2);
		for(Integer c: out) System.out.println(c);
	}
	

}
