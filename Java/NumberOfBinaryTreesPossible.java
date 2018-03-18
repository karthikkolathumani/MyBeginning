package BinarySearchTree;
import java.io.*;
// N = 0 is assumed to be 1.

public class NumberOfBinaryTreesPossible {
	
	static String getInput() throws IOException {
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		String input = br.readLine();
		return input;
	}
	
	static int calcNumberofTrees(int n) {
		int result = 0;
		
		int dp[] = new int[n+1];
		dp[0] = 1;
		dp[1] = 1;
		
		for(int i=2;i<=n;i++) {
			dp[i] = 0;
			for(int j=0;j<i;j++) {
				dp[i] += dp[j] * dp[i-j-1];
			}
		}
		
		return dp[n];
	}

	public static void main(String[] args) throws IOException {
		System.out.println("Enter the number of trees");
		System.out.flush();
		int n = Integer.parseInt(getInput().trim());
		System.out.println(calcNumberofTrees(n));
	}
	
}
