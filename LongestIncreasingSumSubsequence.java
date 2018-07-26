package DynamicProgramming;


public class LongestIncreasingSumSubsequence {
	
	public static int findMaximumSum(int[] arr) {
		int dp[] = new int[arr.length];
		
		for(int i = 0 ; i < arr.length ;i ++) {
			dp[i] = arr[i];
		}
		
		for(int i = 0 ; i< arr.length ;i++) {
			for(int j = i-1; j>=0 ;j--) {
				if(arr[i]>arr[j] && dp[i]<dp[j]+arr[i]) {
					dp[i] = dp[j] + arr[i];
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		
		for(int i=0;i< dp.length ;i++) {
			max = Math.max(max, dp[i]);
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		int[] arr = {0,98,23,21,34,12,100};
		System.out.println(findMaximumSum(arr));
	}
}
