
public class AppendAndDelete {
	 static String appendAndDelete(String s, String t, int k) {
	     int sLen = s.length()-1;
	     int tLen = t.length()-1;
		 
		 
		 int diff = Math.abs(sLen-tLen);
		 
		 int same = 0;
		 int count = diff;
		 
		 int longer = Math.max(sLen, tLen);
		 
		 longer -= diff;
		 
		 int i = 0;
		 
		 
		 
		 while(i<=longer) {
			 if(s.charAt(i)==t.charAt(i)) {
			 same++;
			 i++;
			 }
		 }
		 
		 int mismatch = (s.length()-same) + count;

		 return (mismatch>k)?"No":"Yes";
	    }
	 
	 

	    public static void main(String[] args)  {
	    
	    	System.out.println(appendAndDelete("hackerhappy","hackerrank",9));
	    	
	    }

}
