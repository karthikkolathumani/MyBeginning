package DynamicProgramming;

public class MaximumSumSubarrayBF {
	
	public static int findmaximumSum(int arr[]) {
		int result = Integer.MIN_VALUE;
		
		for(int i = 0; i < arr.length ;i++) {
			int sum = 0;
			for(int j = i ; j < arr.length ;j++) {
				sum += arr[j];
				result = Math.max(result, sum);
			}
		}
		
	return result;	
	}
	
	
	public static int findMaximumSumKadane(int[] arr) {
		int max_so_far = arr[0]; // -2
		int currSum = arr[0]; // -2
		int start = 0;
		int end = 0;
		for(int i = 1 ; i <arr.length ;i++) {
			
			
			currSum = Math.max(currSum+arr[i], arr[i]); //  3,
			if(max_so_far<currSum) {
				max_so_far = currSum;
				end = i;
			}
		}
		
		int newSum = 0;
		for(int j = end ;j >= 0 ; j--) {
			if(newSum!=max_so_far) newSum += arr[j];
				
			else {start = j+1;
			break;
			} 
		}
		
		
		
		System.out.println("Starts at: "+start+" and ends at: "+ end);
		return max_so_far;
	}
	
	
	public static int findMaximumPositiveSum(int [] arr) {
		int curr_sum = 0 ; 
		int max_so_far = 0;
		
		for(int i = 0 ; i  <arr.length ; i++) {
			curr_sum += arr[i];
			max_so_far = Math.max(curr_sum, max_so_far);
			if(curr_sum<0) curr_sum = 0;
		}
		
		return max_so_far;
	}
	
	public static int findMiddle(int[] arr, int l, int m, int h) {
		int sum = 0;
		int left_sum = Integer.MIN_VALUE;
		int right_sum = Integer.MIN_VALUE;
		
		for(int i=m ; i>=l ; i--) {
			sum += arr[i];
			left_sum = Math.max(sum, left_sum);
		}
		sum = 0;
		for(int j = m+1; j<=h ;j++) {
			sum += arr[j];
			right_sum = Math.max(right_sum, sum);
		}
		
		return right_sum+left_sum;
	}
	public static int findMaximumPositiveSumDIVIDEANDQUONQER(int[] arr,int l,int h) {
		
		if(l == h) return arr[l];
		
		int m = (l+h)/2;
		
		return (Math.max(Math.max(findMaximumPositiveSumDIVIDEANDQUONQER(arr,l,m), findMaximumPositiveSumDIVIDEANDQUONQER(arr,m+1,h)), findMiddle(arr,l,m,h)));
	}
	
	public static void main(String[] args) {
		int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3};
		System.out.println(findmaximumSum(arr));
		System.out.println(findMaximumSumKadane(arr));
		System.out.println(findMaximumPositiveSum(arr));
		System.out.println(findMaximumPositiveSumDIVIDEANDQUONQER(arr,0,arr.length-1));
	}
}
