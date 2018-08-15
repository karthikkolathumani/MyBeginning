package leetcode;
import java.util.*;
public class Sum_3_windowSum {
	
	public static List<List<Integer>> threeSum(int[] sum,int k){
		int windowSum = 0;
		List<List<Integer>> result = new ArrayList<>();
		
		for(int i = 0 ; i < k ;i++) {
			windowSum += sum[i];
		}
		
		if(windowSum==0) {
			List<Integer> temp = new ArrayList<>();
			for(int i = 0 ; i < k ;i++) {
				temp.add(sum[i]);
			}
			
			result.add(temp);
		}
		
		for(int i = k ; i< sum.length ;i++) {
			windowSum -= sum[i-k];
			windowSum += sum[i];
			if(windowSum==0) {
				List<Integer> temp = new ArrayList<>();
				for(int j = i-k+1; j<=i ;j++) {
					temp.add(sum[j]);
				}
				
				result.add(temp);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int arr[] = {-1,0,1,-2,1,-4};
		List<List<Integer>> result = threeSum(arr,3);
		
		for(List<Integer> r : result) {
			for(Integer c: r) {
				System.out.print(c+" ");
			}
			System.out.println();
		}
	}

}
