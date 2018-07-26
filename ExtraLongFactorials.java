import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ExtraLongFactorials{

    
    
    // Complete the extraLongFactorials function below.
    static void extraLongFactorials(int n) {
    	BigInteger bg = new BigInteger("1");
    	
    	
    	
    	
    	for(int i=2;i<=n;i++) {
    		bg = bg.multiply(BigInteger.valueOf(i));
    	}
    	
    	System.out.println(bg);
    	
        

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        extraLongFactorials(n);
       
        scanner.close();
    }
}
