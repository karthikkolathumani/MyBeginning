package leetcode;
import java.util.*;
public class sum3 {
	
	public static List<List<Integer>> findThreeSum(int arr[]){
		
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(arr);
		
		for(int i = 0 ; i < arr.length-2 ; i++) {
			
			if (i == 0 || (i > 0 && arr[i] != arr[i-1])) {
				int sum = 0 - arr[i];
				int low = i+1;
				int high = arr.length -1 ;
			while(low<high) {
				if(arr[low]+arr[high]==sum) {
					List<Integer> temp = new ArrayList<>();
					temp.add(arr[i]); temp.add(arr[low]); temp.add(arr[high]);
					result.add(temp);
					
					while(low<high && arr[low]==arr[low+1]) low++;
					while(low<high && arr[high]==arr[high-1]) high--;
					
					low++;high--;
				}else if(arr[low]+arr[high]<sum) low++;
				else high--;
			}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int arr[] = {0,0,0};
		List<List<Integer>> result = findThreeSum(arr);
		
		for(List<Integer> c: result) {
			for(Integer d: c) {
				System.out.print(d+" ");
			}
			System.out.println();
		}
	}
	
}
