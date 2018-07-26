import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MarsOrbiter {

    // Complete the marsExploration function below.
    static int marsExploration(String s) {
    	Stack<Character> stc = new Stack<>();
    	if(s.length()<3) return 0;
        int i = 0;
        int count = 0;
        String o = "SOS";
        while(true) {
        	int k = 0;
        	while(stc.size()!=3) {
        		stc.push(s.charAt(i));
        		i++;
        	}
        	while(!stc.isEmpty()) {
        		
        		if(o.charAt(k)!=stc.pop()) count++;
        		
        		k++;
        	}
        	
        	if(i==s.length()) break;
        	
        }
        return count;
        
    }
    
    public static int[] getarray() {
    	return new int[0];
    }


    

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        System.out.println(marsExploration(s));
    }
}
