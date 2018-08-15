package leetcode;

public class findLongestPalindromicSubString {
	
	private static int maxLen,low;
	public static String longestPalindrome(String a) {
		if(a.length()<2) return a;
		
		for(int i = 0 ; i < a.length()-1; i++) {
			checkPalindrome(a,i,i);
			checkPalindrome(a,i,i+1);
		}
		return a.substring(low, low+maxLen);
	}
	
	public static void checkPalindrome(String a, int l, int m) {
		
		while(l>=0 && m<a.length() && a.charAt(l)==a.charAt(m)) {
			l--;
			m++;
		}
		
		if(maxLen < m-l-1) {
			maxLen = m-l-1;
			low = l+1;
		}
		
	}
	
	public static void main(String[] args) {
		String a = "ac";
		System.out.println(longestPalindrome(a));
	}
	
}
