package leetcode;
import java.util.*;
public class PlusOne {
	
	public static int[] plusOne(int arr[]) {
		
		int n = arr.length;
		
		for(int i = n-1; i>=0 ;i--) {
			if(arr[i]<9) {
				arr[i]++;
				return arr;
			}
			
			arr[i] = 0;
		}
		
		int num[] = new int[n+1];
		num[0] = 1;
		
		return num;
		
	}
	
	public static void main(String[] args) {
		int arr[] = {9,8,2,1,3,3,1,8,1,4,4,7,2,7,2,0,5,6,8,9,7,7,4,3};
		
		plusOne(arr);
	}
}
