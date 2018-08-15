package leetcode;

public class PalindromeNumber {
	public static void main(String[] args) {
		int n = 1000000001;
		boolean isNeg = (n<0)? true:false;
		int i = 1;
		int temp = n;
		while(temp!=0) {
			temp/=10;
			i*=10;
		}
		
		i/=10;
		
		int c =0;
		int d;
		
		while(n!=0) {
			d = n%10;
			c += d*i;
			n/=10;
			i/=10;
		}
		System.out.println(c);
		
	}

}
