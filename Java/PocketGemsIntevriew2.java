
public class PocketGemsIntevriew2 {
	public static void main(String[] args) {
		int[] a = {1,45,23,1,2,7,12,34};
		System.out.println(findMaxProfit(a));
		}
	public static int findMaxProfit(int a[]) {
		int result =0;
		int dp[] = new int[a.length];
		if(a.length==0) {
			return result;
		}
		if(a.length==1) {
			return a[0];
		}
		
		dp[0] = a[0];
		dp[1] = Math.max(a[0], a[1]);
		for(int i=2;i<a.length;i++) {
			dp[i] = Math.max(dp[i-2]+a[i],dp[i-1]);
		}
		result = dp[a.length-1];
		return result;
	}
		
	}


