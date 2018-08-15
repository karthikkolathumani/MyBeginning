package leetcode;

public class Jumps_2 {

	public static int minimumJumps(int arr[], int i) {
		
		if(i>=arr.length-1) return 0;
		if(arr[i]==0) return Integer.MAX_VALUE;
		
		
		int n = arr[i];
		int min = Integer.MAX_VALUE;
		while(n>=1) {
			int steps = minimumJumps(arr,i+n);
			if(min > steps+1 && steps+1>0) {
				min = steps+1;
			}
			n--;
		}
		
		return min;
		
	}
	
	
	public static int minimumJumpsDP(int arr[]) {
		int dp[] = new int[arr.length];
		
		dp[0] = 0;
		
		for(int i = 1; i< dp.length ;i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		
		
		for(int j = 1; j< arr.length ;j++) {
			for(int k = 0; k <=j  ;k++ ) {
				int result = Integer.MAX_VALUE;
				int jumpPossible = arr[k];
				if(jumpPossible+k >= j) {
					int jumpsToCurrPoint = dp[k];
					int jumsToNextPoint = jumpsToCurrPoint+1;
					result = Math.min(jumsToNextPoint, dp[j]);
					dp[j] = result;
				}
				
			}
		}
		
		return dp[dp.length -1];
	}
	
	public static void main(String[] args) {
		int arr[] = {0};
		System.out.println(minimumJumps(arr,0));
		System.out.println(minimumJumpsDP(arr));
	}
}
