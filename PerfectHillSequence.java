package DynamicProgramming;

public class PerfectHillSequence {
	
	public static int[] findIncreasingSequence(int arr[]) {
		int dp[] = new int[arr.length];
		
		for(int i = 0 ; i < arr.length ;i++) dp[i] = 1;
		
		
		for(int i = 0 ; i < arr.length ;i++) {
			for(int j = i-1; j>=0;j--) {
				if(arr[i]>arr[j] && dp[i] < dp[j]+1 ) dp[i] = dp[j] +1;
			}
		}
		
		return dp;
	}	
	
	public static int[] findDecreasingSequence(int arr[]) {
		int dp[] = new int[arr.length];
		
		for(int i = 0 ; i < arr.length ;i++) dp[i] = 1;
		
		for(int i = arr.length -1 ;i>=0;i--) {
			for(int j = arr.length-1 ;j>i;j--) {
				if(arr[i]>arr[j] && dp[i]<dp[j]+1) dp[i] = dp[j] +1;
			}
		}
		
		

		return dp;
	}
	
	public static void main(String[] args) {
		int arr[] = {10,15,16,9,4,3,11,1};
		int incDP[] = findIncreasingSequence(arr);
		int dcrDP[] = findDecreasingSequence(arr);
		
		for(Integer c: incDP) System.out.print(c+" ");
		System.out.println();
		for(Integer c: dcrDP) System.out.print(c+" ");
		System.out.println();
		int maximumPerfectHillLength = Integer.MIN_VALUE;
		
		for(int i = 0; i < incDP.length ;i++) {
			int element = Math.min(incDP[i], dcrDP[i]);
			maximumPerfectHillLength = Math.max(element, maximumPerfectHillLength);
		}
		
		System.out.println("Maximum length perfect hill : "+((maximumPerfectHillLength-1)*2+1));
	}
	
}
