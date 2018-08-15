package leetcode;
import java.util.*;
public class LongestPrefix {
	
	 public static String longestCommonPrefix(String[] strs) {
		 if(strs.length == 0) return "";
		 int smallest = Integer.MAX_VALUE;
		 HashSet<Character> set = new HashSet<>();
		 int setSize = 0;
		 for(int i = 0 ; i < strs.length ;i++) {
			 smallest = Math.min(smallest, strs[i].length());
		 }
		 
		 for(int i = 0 ; i < smallest ;i++) {
			 for(int j = 0 ; j < strs.length ;j++) {
				 set.add(strs[j].charAt(i));
				 if(set.size()>1) {
					 return strs[j].substring(0, setSize);
				 }
			 }
			 set.clear();
			 setSize++;
		 }
		
		 return strs[0].substring(0, setSize);
	 }
	
	public static void main(String[] args) {
		String[] str = {""};
		System.out.println(longestCommonPrefix(str));
	}

}
