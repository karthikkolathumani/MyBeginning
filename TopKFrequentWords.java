package Heaps;
import java.util.*;

public class TopKFrequentWords {
	
	public List<String> topKFrequent(String[] words, int k) {
		PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>((a,b) -> a.getValue()==b.getValue()? b.getKey().compareTo(a.getKey()): a.getValue()-b.getValue());
		HashMap<String,Integer> map = new HashMap<>();
		List<String> output = new ArrayList<>();
		for(String c: words) {
			if(map.containsKey(c)) map.put(c, map.get(c)+1);
			else map.put(c, 1);
		}
		
		for(Map.Entry<String, Integer> entry: map.entrySet()) {
			maxHeap.offer(entry);
		}
		
		for(int i = 0 ; i < k ; i++) {
			output.add(maxHeap.poll().getKey());
		}
		
		for(int i = output.size()-1,j=0; i >= output.size()/2; i--,j++) {
			String temp = output.get(i);
			output.add(i, output.get(j));
			output.add(j,temp);
			
		}
		
		return output;
	}
	
	public static void main(String[] args) {
		String[] arr = {"i", "love", "leetcode", "i", "love", "coding"};
		TopKFrequentWords obj = new TopKFrequentWords();
		System.out.println(obj.topKFrequent(arr, 2));
		
	}

}
