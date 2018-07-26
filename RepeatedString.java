import java.util.ArrayList;

public class RepeatedString {
	
	static long repeatedString(String s, long n) {
		long count =0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='a'){
               
                count++;
            }
        }
        
        long result = n/s.length();
        
        long rem = (n%s.length());
        
        count = result * count;
        for(int i=0;i<rem;i++) {
        	if(s.charAt(i)=='a') count++;
        }
       
        return count;

    }

	
	public static void main(String[] args) {
		System.out.println(repeatedString("aba",10));
		String g = "";
		System.out.println(g.getClass());
	}

}
