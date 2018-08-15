package leetcode;
import java.util.*;
public class ThreeSum {
	
	public static List<List<Integer>> sum3(int arr[],int target){
		List<List<Integer>> result = new  LinkedList<>();
		Arrays.sort(arr);
		for(int i = 0 ; i < arr.length -2 ;i++) {
			int l = i+1;
			int h = arr.length -1;
			
			while(l<h) {
				if(arr[i]+arr[l]+arr[h]==target) {
					List<Integer> temp = new LinkedList<>();
					temp.add(arr[i]); temp.add(arr[l]); temp.add(arr[h]);
					result.add(temp);
					while(l<h && arr[l]==arr[l+1]) l++;
					while(l<h && arr[h]==arr[h-1]) h--;
					l++;h--;
				}else if(arr[i]+arr[l]+arr[h]<target) l++;
				else h--;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int arr[ ] = {-1, 2, 1, -4};
		List<List<Integer>> result = sum3(arr,2);
		
		for(List<Integer> r : result) {
			for(Integer x : r) {
				System.out.print(x+" ");
			}
			System.out.println();
		}
	}
}
