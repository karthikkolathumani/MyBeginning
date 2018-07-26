package DynamicProgramming;
import java.util.*;

//This Implementation is different from the actual meaning of the Longest consecutive subsequence

public class LongestConsecutiveSubsequence {
	public static int findConsecutiveSequence(int[] arr) {
		int dp[] = new int[arr.length];
		
		for(int i = 0 ; i < dp.length ;i++) dp[i] = 1;
		
		for(int i = 1; i < arr.length ;i++) {
			for(int j = i-1; j>=0 ;j--) {
				if(arr[i]==(arr[j]+1) && dp[i]<dp[j]+1) {
					dp[i] = dp[j] +1;
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		
		for(int i = 0 ; i< dp.length ;i++) {
			max = Math.max(max, dp[i]);
		}
		
		return max;
	}
	
/*
 * The actual implementation of the longest consecutive subsequence	
 */
	
	public static int longestConsecutiveSequence(int arr[]) {
		HashMap<Integer,Boolean> map = new HashMap<>();
		int maxCount = Integer.MIN_VALUE;
		for(Integer c: arr) {
			if(!map.containsKey(c)) map.put(c,false);
		}
		
		for(Map.Entry<Integer, Boolean> entry : map.entrySet()) {
			int element = entry.getKey();
			int count = 0;
			int leftCountIs = leftCount(map,element);
			int rightCountIs = rightCount(map,element);
			count = (rightCountIs!=0 && leftCountIs!=0)? leftCountIs+rightCountIs : Math.max(leftCountIs, rightCountIs);
			maxCount = Math.max(count, maxCount);
		}
		return maxCount;
	}
	

	
	private static int rightCount(HashMap<Integer, Boolean> map, int element) {
			int i = element - 1;
			int count  = 0; 
			while(map.containsKey(i) && map.get(i)!=true) {
				map.put(i, true);
				i--;
				count++;
			}
		return count;
	}

	private static int leftCount(HashMap<Integer, Boolean> map, int element) {
			int i = element + 1;
			int count  = 0; 
			while(map.containsKey(i) && map.get(i)!=true) {
				map.put(i, true);
				i++;
				count++;
			}
		return count+1;
	}

	public static void main(String[] args) {
		int arr[] = {10,4,13,5,6,12};
		//System.out.println(findConsecutiveSequence(arr));
		System.out.println(longestConsecutiveSequence(arr));
	}
}
