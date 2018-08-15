package leetcode;

public class MinimumCostPath {

	 public static int minPathSum(int[][] grid) {
	        if(grid==null || grid.length ==0 || grid[0].length == 0) return 0;
	        
	        int dp[][] = new int [grid.length][grid[0].length];
	        
	        dp[0][0] = grid[0][0];
	        
	        int sum = dp[0][0] ;
	        for(int i = 1 ; i < dp[0].length ;i++){
	        
	            sum+= grid[0][i];
	            dp[0][i] = sum;
	            System.out.println("Exe");
	        }
	        
	        sum  = dp[0][0];
	        
	        for(int i = 1; i < dp.length ;i++){
	            sum += grid[i][0];
	            dp[i][0] = sum;
	        }
	        
	        
	        for(int i = 1; i < grid.length ;i++){
	            for(int j = 1; j< grid[i].length;j++){
	                dp[i][j] = grid[i][j] + Math.min(dp[i][j-1],dp[i-1][j]);        
	            }
	        }
	        
	        for(int i = 0; i < dp.length ;i++){
	            for(int j = 0 ; j < dp[i].length ;j++){
	                System.out.print(dp[i][j]);
	            }
	            System.out.println();
	        }
	        
	        return dp[grid.length -1][grid[0].length-1];
	        
	    }
	 
	 public static void main(String[] args) {
		int arr[][] = {{1,2},{5,6},{1,1}};
		System.out.println(minPathSum(arr)); 
		
	}
}
