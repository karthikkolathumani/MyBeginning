package leetcode;

public class SpiralMatrix {
	
	public static int[][] printSpiralMatrix(int n){
		int result[][]= new int[n][n];
		int rowStart = 0;
		int rowEnd = n-1;
		int colStart = 0;
		int colEnd = n-1;
		int number = 1;
		while(rowStart<=rowEnd && colStart<=colEnd && number<=(n*n) ) {
			
			for(int i=colStart;i<=colEnd;i++) {
				result[rowStart][i] = number++;
			}
			rowStart++;
			
			for(int i = rowStart;i<=rowEnd;i++) {
				result[i][colEnd] = number++;
			}
			colEnd--;
			
		
			for(int i = colEnd ;i>=colStart ;i--) {
				result[rowEnd][i] = number++;
			}
			rowEnd--;
			
			
			
			for(int i = rowEnd; i>=rowStart ;i-- ) {
				result[i][colStart] = number++;
			}
			
			colStart++;
			
		}
		
		return result;
		
	}
	
	public static void main(String[] args) {
		int n = 5;
		int result[][] = printSpiralMatrix(n);
		
		for(int i = 0 ; i < result.length ;i++) {
			for(int j = 0; j< result[i].length ;j++) {
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
	}
}
