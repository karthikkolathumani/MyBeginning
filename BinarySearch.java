package leetcode;

public class BinarySearch {

	public static int search(int arr[], int low,int high, int key,boolean left) {
		
		if(low < high) {
			int mid = (low+high)/2;
			
			if(arr[mid] > key || (left && arr[mid] == key)) {
				return search(arr,low,mid,key,left);
			}
			else {
			
				return search(arr,mid+1,high,key,left);
			}
		}
		return low;
	}
	
	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,6,7,7,7,7,7,7,7};
		System.out.println(search(arr,0,arr.length,7,true));
		//System.out.println(search(arr,0,arr.length,7,false)-1);
	}
}
