import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.*;




public class peekProblem {
	
	static int countingValleys(String s) {
        char[] a = s.toCharArray();
        int isDown = 0;
        int upCount = 0;
        int count =0;
        for(int i=0;i<a.length;i++){
        	System.out.println(a[i]+" "+isDown+" "+upCount);
            if(a[i]=='D') isDown++;
            
            else if(a[i]=='U' && isDown>0) upCount++;
            
            if(isDown==2 && upCount>1){
            	System.out.println("Executed");
                count++;
                isDown =0;
                upCount = 0;
            }
        }
       
        return count;

    }
	
	
	

	    public static void main(String[] args) throws IOException {
	        String a = "DDUUDDUDUUUD";
	        Pattern p = Pattern.compile("D+U+D+");
	        Matcher matcher = p.matcher(a);
	        boolean b = matcher.matches();
	     int count = 0;
	        
	        
	        while (matcher.find()) {
                System.out.printf("I found the text" +
                    " \"%s\" starting at " +
                    "index %d and ending at index %d.%n",
                    matcher.group(),
                    matcher.start(),
                    matcher.end());
                b = true;
                count++;
            }
	        
	       System.out.println(count);
	    }
	}


