import java.util.*;
import java.util.Map.Entry;
public class FrequencyArray {


	public static void main(String[] args) {
		int a[] = {1,2,2,3,1,4,2,1,3,3,3,3};
		
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i = 0 ;i<a.length; i++) {
			map.put(a[i], 0);
			
		}
		
		
		
		 for(int i = 0; i<a.length;i++) {
//			
				
				map.put(a[i], map.get(a[i])+1);
				
			 
	
		 }
		 
		
		 for(Map.Entry entry : map.entrySet()) {
			 System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
		 }
		 
		 Entry<Integer,Integer> maxEntry = null;

		 for(Entry<Integer, Integer> entry : map.entrySet()) {
		     if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
		         maxEntry = entry;
		     }
		 }
		 
		 
		 Collection<Integer> sameF = new ArrayList<>();
		 int highFreq = 0;
		 for(Entry<Integer,Integer> entry : map.entrySet()) {
			 if(entry.getValue().equals(maxEntry.getValue())) {
				 highFreq = entry.getKey();
			 }
		 }
		
		 for(Integer b : sameF) {
			 
			 System.out.println(b);
		 }
		 
		/*Collection<Integer> KeyWithF = new ArrayList<>();
		for(Entry<Integer,Integer> entry : map.entrySet()) {
			if(entry.getKey().equals())
		}*/
		 
		int start = 0;
		int end = 0 ;
		 for(int i =0 ; i<a.length; i++) {
			 if(a[i] == highFreq && start == 0) {
				 start = i;
				 
			 }
			 if(a[i] == highFreq && start != 0) {
				 end = i;
				 
			 }
			 
			 
		 }
		 
		 System.out.println("Start is "+start + " end is "+end);
		
		
	}
}
