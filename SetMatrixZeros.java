package leetcode;

public class SetMatrixZeros {
	
	public static int[][] setZeros(int mat[][]){
		
		// top - bottom
		// at i, check if zero? set that starting element of row to zero and starting element of the current col to 0;
		// when row is zero and col is zero, maintain extra variable col_0 to indicate presence of zeros.
		
		int col_0 = 1;
		
		for(int i = 0 ; i < mat.length ;i++) {
			for(int j = 0; j < mat[i].length ;j++) {
				if(mat[i][j] == 0) {
					//row 
					mat[i][0] = 0;
					if(i!=0 && j!=0) mat[0][j] = 0;
					else col_0 = 0;
				}
			}
		}
		
		for(int i = 0 ; i < mat.length ;i++) {
			for(int j = 0 ; j < mat[i].length ;j++) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println(); 
		
		// traverse the array from bottom up
		
		for(int i = mat.length -1 ; i>=0 ;i--) {
			for(int j = mat[i].length -1 ; j>=1 ;j--) {
				
				if(mat[i][0] == 0 || mat[0][j]==0) {
					mat[i][j] = 0;
				}
				
			}
			if(col_0 == 0) mat[i][0]=0;
		}
		
		return mat;
		
		
		
	}
	
	public static void main(String[] args) {
		int mat[][] = {{0,1,2,0},
					   {3,4,5,2},
					   {1,3,1,5}};
		
		int result[][] = setZeros(mat);

		for(int i = 0 ; i < result.length ;i++) {
			for(int j = 0 ; j < result[i].length ;j++) {
				System.out.print(result[i][j]);
			}
			System.out.println();
		}
		
		
		
	}
}
