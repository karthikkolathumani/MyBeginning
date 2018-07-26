package DynamicProgramming;

public class LargestOnesSubMatrix {
	//Brute Force
	public static int largestSubMatrix(int arr[][]) {
		int count = Integer.MIN_VALUE;
		for(int i = 0 ; i < arr.length-1 ; i++) {
			for(int j =0; j< arr[i].length; j++) {
				for(int k = i+1; k< arr.length ;k++) {
					int l = (k-i) + j;
					if(l>=arr[i].length) continue;
					
					if(count <  findIfBinary(arr,i,j,k,l)) {
						//System.out.println(i+" "+j+" "+k+" "+l+" count "+count);
						count  = findIfBinary(arr,i,j,k,l);
						
					}
				}
			}
		}
		
		return count;
	}
	
	public static int findIfBinary(int arr[][], int i, int j , int k , int l) {
		//boolean zero = false;
		int count = 0;
		//System.out.println(i+" "+j+" "+k+" "+l);
	
		for(int q = i; q <= k; q++) {
			for(int w = j; w<= l ;w++) {
				
				if(arr[q][w] == 0) {	
					count = 0;
					return count;
				}else count++; 
			}
		}
		
		
		
		return (count>0)? (Math.abs((k-i)+1)) : 0;
		
		
	}

	//Dynamic Programming
	public static int largestSubMartixDP(int arr[][]) {
		int dp[][] = new int[arr.length][arr[0].length];
		
		
		for(int i = 0 ; i < arr.length ;i++) {
			dp[i][0] = arr[i][0];
		}
		for(int i = 0 ; i < arr[0].length ;i++) {
			dp[0][i] = arr[0][i];
		}
		
		for(int i = 1 ; i < arr.length ; i++) {
			for(int j = 1; j < arr[i].length ;j++) {
				if(arr[i][j] == 1) dp[i][j] = 1+Math.min(dp[i][j-1],Math.min(dp[i-1][j-1], dp[i-1][j]));
				else dp[i][j] = 0;
			}
		}
		
//		for(int i = 0 ; i < dp.length ; i++) {
//			for(int j = 0 ; j < dp[i].length ;j++) {
//				System.out.print(dp[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		return dp[arr.length-1][arr[arr.length-1].length-1];
	}
	
	
	public static void main(String[] args) {
		int arr[][] = {{1,1,1,1},
					   {0,1,1,1},
					   {1,1,1,1},
					   {1,1,1,1},
					   {1,1,1,1},
					   {0,1,1,1}};
		
		System.out.println(largestSubMatrix(arr));
		System.out.println(largestSubMartixDP(arr));
	}
	
}
