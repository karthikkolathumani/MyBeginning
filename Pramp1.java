	import java.io.*;
import java.util.*;

class Pramp1 {
	
	
  static int linearSearch(int arr[],int key,int skip_index) {
	  
	  for(int i=0;i<arr.length;i++) {
		  if(i==skip_index) continue;
		  
		  if(arr[i]==key) return i;
	  }
	  return -1;
	  
  }
  

  static int[] getIndicesOfItemWeights(int[] arr, int limit) {
    // your code goes here
	  
	 int[] output = new int[2];
	 
	
	 
	 
	 for(int j=0;j<arr.length;j++) {
		 
		 int other_no = limit - arr[j];
		 
		 int i_index = linearSearch(arr,other_no, j);
		 
		 if(i_index>-1) {
			 output[0] = i_index;
			 output[1] = j;
			 return output;
		 }
		 
		 
	 }
	  
	  return new int[0];
	
  }
  
  
  
  static int[] alternateSolution(int arr[],int limit) {
	  int[] output= new int[2];
	  
	 HashMap<Integer,Integer> map  = new HashMap<>();
	 
	 for(int x = 0;x<arr.length;x++) {
		 int complement = limit - arr[x];
		 
		 if(map.containsKey(complement)) {
			 output[1] = map.get(complement);
			 output[0] = x;
			 return output;
		 }
		 
		 else map.put(arr[x], x);
		 
		
		 
	 }
	 return new int[0];
  }

  public static void main(String[] args) {
    int[] arr = {4, 6, 10, 15, 16};
    int[] output = alternateSolution(arr,21);
    
    for(int u:output) System.out.print(u);
    
  }

}