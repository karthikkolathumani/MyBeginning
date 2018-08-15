package leetcode;
import java.util.*;
public class FourSum {
	
	public static List<List<Integer>> findFourSum(int[] arr,int target){
		Arrays.sort(arr);
		List<List<Integer>> result = new LinkedList<>();
		
		for(int i=0 ;i < arr.length -3 ;i++) {
			if (i == 0 || (i > 0 && arr[i] != arr[i-1])) {
			for(int j = i+1 ; j<arr.length-2;j++) {
				int low = j+1;
				int high = arr.length -1;
				int sum = target - arr[i];
				if (j == 1 || (j > 0 && arr[j] != arr[j-1])) {
				while(low<high) {
					if(arr[j]+arr[low]+arr[high]==sum) {
						List<Integer> temp = new LinkedList<>();
						temp.add(arr[i]); temp.add(arr[j]); temp.add(arr[low]); temp.add(arr[high]);
						result.add(temp);
						while(low<high && arr[low]==arr[low+1]) low++;
						while(low<high && arr[high]==arr[high-1]) high--;
						low++;
						high--;
					}else if(arr[j]+arr[low]+arr[high] < sum) low++;
					else high--;
				}
			}
			}
		}
			}
		return result;
	}
	
	public static void main(String[] args) {
		int arr[] = {0,0,0,0}; // {-4,-1,-1,0,1,2}
				
		List<List<Integer>> result = findFourSum(arr,0);
		for(List<Integer> c: result) {
			for(Integer k: c) {
				System.out.print(k+" ");
			}
			System.out.println();
		}
		
		
	}
}
