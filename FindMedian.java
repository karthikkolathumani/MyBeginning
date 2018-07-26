package Heaps;

//Finding Median with two sorted arrays
public class FindMedian {
	
	
	static int[] array1;
	static int[]  array2;
	
	public  FindMedian(int[] arr, int[] arr1) {
		FindMedian.array1 = arr;
		FindMedian.array2 = arr1;
		
		array1 = (array1.length<array2.length)?array1:array2;
		array2 = (array2.length>array1.length)?array2:array1;
		double c = findMedian();
		System.out.println(c);
	}
	
	
	public static double findMedian() {
		int length1 = array1.length; // 23, 26, 31, 35 // 4
		int length2 = array2.length; // 3, 5, 7, 9, 16 // 5
		
		int high = length1; //4
		int low = 0;
		
		while(low<=high) { // high = 0
			int partitionX = (low+high)/2; // 0
			int partitionY = (length1+length2+1)/2 - partitionX; // 5
			
			// inf | 23 26 , 31, 35
			// 3, 5, 7, 9, 16 | Inf
			int maxLeftX = (partitionX==0)?        Integer.MIN_VALUE : array1[partitionX-1]; // -Inf
			int minRightX = (partitionX==length1)? Integer.MAX_VALUE : array1[partitionX]; // 23
			int maxLeftY = (partitionY==0)?        Integer.MIN_VALUE :  array2[partitionY-1]; // 16 
			int minRightY = (partitionY==length2)? Integer.MAX_VALUE : array2[partitionY]; // Inf
			
			if(maxLeftX<=minRightY && maxLeftY <= minRightX) {
				// 3, 5, 7, 9, 16, 23, 26, 31, 35
				if((length1+length2)%2==0) return (Math.max(maxLeftX,maxLeftY)+Math.min(minRightX, minRightY))/(double)2;
				else return Math.max(maxLeftX, maxLeftY);
			}
			
			
			else if(maxLeftX > minRightY) high = partitionX-1;
			else low = partitionX+1;
		}
		
		throw new IllegalArgumentException();
				
	}
	
	public static void main(String[] args) {
		int [] arr = {23,26,31,35};
		int [] arr1 = {3,5,7,9,16}; // 3,5,7,9,16,23,26,31,35
		new FindMedian(arr,arr1);
		
	}
	

}
