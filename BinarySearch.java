import java.util.*;
public class BinarySearch {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int a [] = new int[5];
//		
//		for(int i=0;i<a.length;i++) {
//			a[i] = sc.nextInt();
//		}
//		
//		int find = sc.nextInt();
		
		//System.out.println(search(a,find,0,a.length-1));
		//System.out.println(searchI(a,find));
		
		System.out.println(Double.MAX_VALUE);
		System.out.println(Double.MIN_VALUE);
	}
	
	
	//Recursive
	public static int search(int a[],int find, int low,int high) {
		
		if(low> high) return -1;
		
			int mid = (low+high)/2;
			if(find < a[mid]) return  search(a,find,low,mid-1);
			else if(find > a[mid]) return search(a,find,mid+1,high);
			else return mid;	
	}
	
	//Iterative
	public static int searchI(int a[],int find) {
		int low = 0;
		int high = a.length - 1;
		while(low<=high) {
			int mid = (low+high)/2;
			if(find < a[mid]) high = mid - 1;
			else if(find > a[mid]) low = mid+1;
			else return mid;
		}
		
		return -1;
		
	}
	
}









//11 12 13 14 15 16 17 18 19 20 21