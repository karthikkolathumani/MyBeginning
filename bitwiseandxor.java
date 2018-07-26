import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class bitwiseandxor {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        for (int tItr = 0; tItr < t; tItr++) {
            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);
            
            
            int max = Integer.MIN_VALUE;
            for(Integer i=1;i<n;i++){
                for(Integer j=i+1;j<=n;j++){
                	 
                    int result = i & j;
                    if(result<k) max = Math.max(max,result);
                }
            }
            System.out.println(max);
        }
        
      
        
        scanner.close();
    }
}