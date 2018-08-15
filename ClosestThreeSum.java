package leetcode;

import java.util.Arrays;

public class ClosestThreeSum {
	
	public static int closestThreeSum(int arr[],int target) {
		int minDiff = Integer.MAX_VALUE; // -1 + 2 -4 = -3
		int result = 0;
		Arrays.sort(arr);
		for(int i = 0 ; i < arr.length - 2 ;i++) { 
			int l = i+1;
			int h = arr.length - 1;
			while(l<h) {
				System.out.print((target - (arr[i]+arr[l]+arr[h]))+" ");
				if(minDiff > (target - (arr[i]+arr[l]+arr[h])) && (arr[i]+arr[l]+arr[h]) >0) { 
					minDiff = target - (arr[i]+arr[l]+arr[h]);
				//	System.out.println(arr[i]+" "+arr[l]+" "+arr[h]);
					result = (arr[i]+arr[l]+arr[h]);
					
				}
				System.out.println(arr[i]);
				h--;
				l++;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int arr[] = {-1, 2, 1, -4}; // -4 -1  1  2   
		System.out.println(closestThreeSum(arr,2)); // 
		
	}
}
