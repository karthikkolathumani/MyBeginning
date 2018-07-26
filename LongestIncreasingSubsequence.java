package DynamicProgramming;

public class LongestIncreasingSubsequence {
	
	
	// Use the sorting method and then find the LCS(merge Sorting)
	public static int findIncreasingSequence(int[] arr) {
		int unsorted[] = new int[arr.length];
		
		for(int i = 0; i < arr.length ;i++) {
			unsorted[i] = arr[i];
		}
		
		
		sort(arr, new int[arr.length],0,arr.length-1);
		
		int dp[][] = new int[2][arr.length+1];
		int bi = 0; 
		for(int i=0;i<= unsorted.length ;i++) {
			bi = i & 1;
			for(int j = 0; j<= arr.length ;j++) {
				if(i==0 || j==0) dp[bi][j] = 0;
				
				else if(unsorted[i-1] == arr[j-1]) dp[bi][j] = 1 + dp[1-bi][j-1];
				else {
					dp[bi][j] = Math.max(dp[1-bi][j], dp[bi][j-1]);
				}
				
			}
		}
		
		return dp[bi][arr.length];
	
	}
	
	public static void sort(int arr[], int temp[] ,int l, int h) {
		
		if(l>=h) return ;
		
		int mid = (l+h)/2;
		
		 sort(arr,temp,l,mid);
		 sort(arr,temp,mid+1,h);	
		
		 merged(arr,temp,l,h);
		
		
	}
	
	public static void merged (int[] array, int[] temp, int leftStart, int rightEnd) {
		int leftEnd = (rightEnd + leftStart)/2;
		int rightStart = leftEnd + 1;
		int size = rightEnd - leftStart +1;
		
		int left = leftStart;
		
		System.out.println("LeftStart value is: "+leftStart);
		int right = rightStart;
		int index = leftStart;
		
		while(left<= leftEnd && right <= rightEnd) {
			if(array[left]<=array[right]) {
				temp[index] = array[left++];
			}else {
				temp[index] = array[right++];
			}
			
			index++;
		}
		
		while(left<=leftEnd) {
			temp[index++] = array[left++] ;
		}
		
		while(right<=rightEnd) {
			temp[index++] = array[right++] ;
		}
		
		System.arraycopy(temp, leftStart, array, leftStart, size);
	}
	
	public static int[] merged(int arr[], int l,int mid, int h) {
		int left[] = new int[mid-l+1];
		int right[] = new int[h-mid];
		
		for(int i = 0 ; i < left.length ;i ++) {
			left[i] = arr[l+i];
		}
		
		for(int i = 0 ;i< right.length ;i++) {
			right[i] = arr[mid+l+i];
		}
		
		return new int[0];
		
	}

	//In this method what you need to do is you have to check whether an 
	//element can be added to the subsequence or not by checking the previous
	// n-1 elements.
	
	public static int longestIncreasingSequnce(int[] arr) {
		
		int dp[] = new int[arr.length];
		
		for(int i = 0 ; i< dp.length ;i++) dp[i] = 1;
		
		for(int i = 1 ; i < arr.length ; i++) {
			int result = 0;
			for(int j = i-1 ; j >=0 ;j--) {				
				if(arr[i]>arr[j] && dp[i]<dp[j]+1)					
					dp[i] = dp[j] + 1;
			}
			
	}
		int res = 0;
		for(int i = 0 ; i< dp.length ;i++) {
			//System.out.print(dp[i]+" ");
			res = Math.max(res, dp[i]);
		}
		
		return res;
	}
	
	
	
	
	public static void main(String[] args) {
		int arr[] = {2,99,101,102,104,105,3,1,5,12,100,101,102,103};
	
		//System.out.println(findIncreasingSequence(arr));
		System.out.println(longestIncreasingSequnce(arr));
	}
}
