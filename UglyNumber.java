package DynamicProgramming;

public class UglyNumber {

	public static int divideIt(int num,int byNumber) {
		
		while( num%byNumber == 0) num /= byNumber;
		
		return num;
	}
	public static int checkIfUgly(int number) {
		
		number = divideIt(number,2);
		number = divideIt(number,3);
		number = divideIt(number,5);
		
		return (number == 1)? 1:0;
	}
	
	
	//Brute Force approach
	public static int findKthUglyNumberBruteForce(int k) {
		if(k == 1) return 1;
		int number = 2;
		int count  = 1;
		
		while(count<k) {
			int i = checkIfUgly(number);
			if(i == 1) count++;
			number++;
		}
		
		return number;
		
		
	}
	
	
	
	
	public static int findKthUglyNumberDP(int k) {
		int[] ugly = new int[k];
		ugly[0] = 1;
		
		int id2 = 0, id3 = 0, id5 = 0;
		int nextMultipleOf2 = 2, nextMultipleOf3 = 3, nextMultipleOf5 = 5;
		int nextUglyNumber = 0;
		
		for(int i = 1 ; i < ugly.length ;i++) {
			nextUglyNumber = Math.min(nextMultipleOf5, Math.min(nextMultipleOf2, nextMultipleOf3));
			ugly[i] = nextUglyNumber;
			
			if(nextUglyNumber == nextMultipleOf2) {
				id2++;
				nextMultipleOf2 = ugly[id2] * 2;
			}
			
			if(nextUglyNumber == nextMultipleOf3) {
				id3++;
				nextMultipleOf3 = ugly[id3] * 3;
			}
			
			if(nextUglyNumber == nextMultipleOf5) {
				id5++;
				nextMultipleOf5 = ugly[id5] * 5;
			}
			
		}
		
		return ugly[k-1];
		
	}
	
	public static void main(String[] args) {
		//System.out.println("The 100th ugly number is : " + findKthUglyNumberDP(150));
		System.out.println("The 100th ugly number is : " + findKthUglyNumberBruteForce(150));
	}
}
