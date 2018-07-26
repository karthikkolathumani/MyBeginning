
public class GoogleQuestions {
	
	public static int binarySearch(int[] arr, int key,int low, int high) {
		
		while(low<=high) {
			int mid = (low+high)/2;
			//System.out.println( mid);
			//if(mid==skipIndex) continue;
			if(key<arr[mid]) high = mid -1;
			else if(key>arr[mid]) low = mid+1;
			else return mid;
			
		}
		
		return -1;
		
	}
	
	public static void main(String[] args) {
		int arr[] = {1,2,3,4};
		int sum = 8;
		int result = -1;
		int index = -1;
		for(int i = 0 ; i < arr.length ;i++) {
			int complement = sum - arr[i];
			if(i==0) {
				result = binarySearch(arr,complement,i+1,arr.length-1);
				index = i;
			}
			else {
				result = binarySearch(arr,complement,0,i-1);
				index = i;
				if(result==-1) {
					result = binarySearch(arr,complement,i+1,arr.length-1);
					index = i;
				}
			}
			
			
		}
		
		System.out.println(result+" "+index);
	}
	
	
	
	

}
