package DynamicProgramming;

public class LongestCommonSubsequence {
	
	public static int findCommonSequence(String a, String b) {
		int dp[][] = new int[a.length()+1][b.length()+1];
		
		for(int i = 0 ; i< a.length()+1;i++) {
			dp[i][0] = 0; 
		}
		
		for(int i = 0; i < b.length()+1 ; i++) {
			dp[0][i] = 0;
		}
		
		for(int i = 1 ; i<= a.length() ;i++) {
			for(int j = 1 ; j<=	 b.length() ; j++) {
				if(a.charAt(i-1)==b.charAt(j-1)) {
					dp[i][j] = 1+ dp[i-1][j-1];
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		for(int i = 0; i<=a.length();i++) {
			for(int j=0; j<=b.length();j++) {
				System.out.print(dp[i][j]);
			}
			System.out.println();
		}
		
		
		return dp[a.length()][b.length()];
	}
	
	
	// When saving the space then all you have to do is AND it with 1
	
	public static int findCommonSequenceWithLessSpace(String a, String b) {
		int dp[][]= new int[2][b.length()+1];
		
		int bi = 0;
		for(int i = 0 ; i <= a.length();i++) {
			bi = i&1;
			
			for(int j = 0; j <=b.length(); j++) {
				if(i==0 || j==0) dp[bi][j] = 0;
				
				else if(a.charAt(i-1)==b.charAt(j-1)) {
					dp[bi][j] = dp[1-bi][j-1]+1;
				}
				else {
					dp[bi][j] = Math.max(dp[1-bi][j], dp[bi][j-1]);
				}
			}
			
		}
		
		return dp[bi][b.length()];
	}
	
	public static void main(String[] args) {
		String a = "AGGTAB";
		String b = "GXTXAYB";
		System.out.println(findCommonSequence(a,b));
		System.out.println(findCommonSequenceWithLessSpace(a,b));
		
	}
}
