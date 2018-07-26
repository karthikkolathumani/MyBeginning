package DynamicProgramming;

public class CoinChange {
	
	public static int change(int amount, int[]change) {
		
		int[][] memo = new int[amount+1][change.length];
		int x,y;
		for(int i = 0 ; i  < change.length ; i++) {
			memo[0][i] = 1;
		}
		
		for(int i = 1 ; i < amount +1 ;i++) {
			for(int j = 0 ; j < change.length ; j++) {
				x = (i - change[j] >= 0)?memo[i-change[j]][j]:0;
				y = (j>=1)? memo[i][j-1]:0;
				memo[i][j] = x+y;
			}
		}
		
		return memo[amount][change.length-1];
	}
	
	public static void main(String[] args) {
		int amount = 25;
		int change[] = {0};
		System.out.println(change(amount,change));
	}

}
