//import java.io.*;
import java.util.Scanner;
public class maxSubArrayKadane {
	
	private int maxSubArray(int arr[]){
		
		int maxSum=0;
		int calSum=0;
		
		for(int i=0;i<arr.length;i++){
			calSum+=arr[i];
			if(calSum<0)
				calSum=0;
			else if (maxSum<calSum)
				maxSum=calSum;				
		}
		
		return maxSum;
		
	}

	public static void main(String args[]) {
		// TODO Auto-generated method stub
		
		int size;
		System.out.println("Enter the size of the array");
		Scanner sc=new Scanner(System.in);
		size=sc.nextInt();
		System.out.println("Enter the elements of the array");
		int[] arr = new int[size];
		for(int i=0;i<size;i++){
			arr[i]=sc.nextInt();
		}
				
		maxSubArrayKadane ob=new maxSubArrayKadane();
		int result=ob.maxSubArray(arr);
		System.out.println("The sum of the maximum sub array is : "+result);
		sc.close();
		
	}
	
	
}

