package leetcode;

import java.util.Arrays;

public class NextPermutation {

	public static void nextPrem(int arr[]) {
		boolean flag = true;
		int index = -1;
		int swapNumber = -1;
		for(int i = arr.length-1 ;i >=1; i--) {
			if(arr[i]>arr[i-1]) {
				index = i-1;
				swapNumber = arr[i-1];
				flag = false;
				break;
			} 
		}
		
		if(flag) {
			Arrays.sort(arr);
			for(Integer c:  arr) System.out.print(c+" ");
		}
		//12354
		else {
			int swapIndex_2 = -1;
			int minDiff = Integer.MAX_VALUE;
			for(int i = index+1 ;i < arr.length ;i++) {
				int diff = Math.abs(swapNumber - arr[i]);
				if(diff < minDiff && swapNumber<arr[i]) {
					minDiff = diff;
					swapIndex_2 = i;
				}
			}
			int temp = arr[index];
			arr[index] = arr[swapIndex_2];
			arr[swapIndex_2] = temp;
			
			Arrays.sort(arr, index+1,arr.length);
			
			for(Integer c :  arr) System.out.print(c+" ");
		}
		
		
		
		
	}
	
	public static void main(String[] args) {
		int arr[] = {2,3,0,2,4,1}; // 1,2,4,3,5,6,4
		nextPrem(arr);
	}
}
