package Heaps;
import java.util.*;

public class SortCharacterByFrequency {
	
	class Charc{
		char value;
		int freq;
		
		public Charc(char value , int freq) {
			this.value = value;
			this.freq = freq;
		}
	}
	
	
	
	
	public String frequencySort(String a) {
		
		PriorityQueue<Charc> maxHeap = new PriorityQueue<>(new Comparator<Charc>(){
			
			
			public int compare (Charc a, Charc b) {
				return -1* (a.freq - b.freq);
			}
			
		}) ;
		
		HashMap<Character, Integer> map = new LinkedHashMap<>();
		
		
		char arr[] = a.toCharArray();
		
		for(int i = 0 ; i<arr.length ; i ++) {
			if(map.containsKey(arr[i])) map.put(arr[i], map.get(arr[i])+1);
			else map.put(arr[i], 1);	
		}
		
		for(Map.Entry<Character, Integer> entry : map.entrySet()) {
			
			Charc n = new Charc(entry.getKey(),entry.getValue());
			maxHeap.add(n);
		}
		
		String result = formString(maxHeap);
		
		return result;
		
	}
	
	public String formString(PriorityQueue<Charc> maxHeap) {
		
		StringBuilder s = new StringBuilder();
		
		while(!maxHeap.isEmpty()) {
			Charc c = maxHeap.poll();
			int freq = c.freq;
			
			for(int i = 0 ; i < freq ; i++) {
				s.append(c.value);
			}
		}
		
		return s.toString();
	}

	public static void main(String[] args) {
		String n = "Aabb";
		SortCharacterByFrequency obj = new SortCharacterByFrequency();
		System.out.println(obj.frequencySort(n));
	}

	
	
}
