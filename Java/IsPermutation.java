import java.util.Arrays;

/**
 * Considers whitespaces and case sensitive
 * @author karthik
 *
 */

public class IsPermutation {
	public static void main(String[] args) {
		String a = "dog";
		String b = "god ";
		a = sort(a);
		b = sort(b);
		
		System.out.println(isPermutation(a,b));
	}
	
	private static String sort(String a) {
		char chararray[] = a.toCharArray();
		Arrays.sort(chararray);
		
		a = new String(chararray);
		return a;
	}
	
	
	private static boolean isPermutation(String a, String b) {
		if(a.length() != b.length()) {
			return false;
		}
		
		if(a.equals(b)) {
			return true;
		}
				
		return false;
		
	}

}
