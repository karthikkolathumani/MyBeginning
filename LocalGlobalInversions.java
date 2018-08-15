package leetcode;

public class LocalGlobalInversions {

	public static boolean isIdealPermutation(int[] A) {
		if(A==null) return false;
		
		for(int i = 0 ;i<A.length-1;i++) {
			if(A[i]>A[i+1]) {
				int temp = A[i];
				A[i] = A[i+1];
				A[i+1] = temp;	
			}
		}
		
		for(int i = 0 ; i < A.length-1; i++) {
			if(A[i]>A[i+1]) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		int A[] = {1,2,0};
		System.out.println(isIdealPermutation(A));
	}
	
}
