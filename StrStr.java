package leetcode;

public class StrStr {
	
	
	public static int strstr(String hayStack, String needle) {
		
		
		
		int index = hayStack.indexOf(needle);
		
		return index;
		
		
		
	}
	
	public static void main(String[] args) {
		String hayStack = "jasf";
		String needle = "";
		System.out.println(strstr(hayStack, needle));
	}
}
