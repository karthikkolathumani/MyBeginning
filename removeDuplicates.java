package leetcode;

public class removeDuplicates {

	public static int unique(int arr[]) {
		
		int count = 0; 
		
		for(int i = 0 ; i < arr.length ;i++) {
			//System.out.print(i+" ");
			count++;
			
			while(i<arr.length-1 && arr[i]==arr[i+1]) i++;
			
		}
		
		return count;
		
	}
	
	public static void main(String[] args) {
		int arr[] = {1,1,2};
		System.out.println(unique(arr));
	}
	
}
