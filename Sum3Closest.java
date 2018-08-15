package leetcode;
import java.util.*;
public class Sum3Closest {
	
	public static int findClosestThreeSum(int arr[],int target){
		int result = arr[0] + arr[1] + arr[arr.length - 1];
		
		Arrays.sort(arr);
		for(int i = 0 ; i < arr.length -2 ; i++) {
			int low = i+1; // 1
			int high = arr.length -1; // 3
			
			 while(low<high) {
				int sum = arr[i] + arr[low] + arr[high];
				if(sum<target) low++;
				else high--;
				
				if(Math.abs(sum-target) < Math.abs(result-target)) {
					result = sum;
				}
			 } 
		}
			return result;
	}
	public static void main(String[] args) {
		int arr[] = {-1, 2, 1, -4}; // -1 2 1 -4
		int result = findClosestThreeSum(arr,1);
	
		System.out.println(result);
	}
}
