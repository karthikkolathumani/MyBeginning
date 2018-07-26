package DynamicProgramming;

public class LongestDecreasingSubSequence {
	// This will give you the correct answer but not the correct order in which dp array exists
	// You have to start i index from the end and the j index from the end and traverse j until > i
	// dp[i] < dp[j] + 1 will remain the same
	public static int findDecresingSubSequence(int arr[]) {
		
		int dp[] = new int[arr.length];
		
		for(int i = 0 ; i < arr.length ;i++) dp[i] = 1;
		
		for(int i = 1; i<arr.length ;i++) {
			for(int j=i-1; j>=0 ; j--) {
				if(arr[i] < arr[j] && dp[i]< dp[j]+1) {
					dp[i] = dp[j] + 1;
				}
			}
		}
		int result = Integer.MIN_VALUE;
		for(Integer c : dp) {
			//System.out.println(c);
			result = Math.max(result,c);
		}
		//System.out.println();
		return result;
	}
	
	
	public static void main(String[] args) {
		int arr[] = {10,15,16,9,4,3,11,1};
		System.out.println(findDecresingSubSequence(arr));
	}

}
