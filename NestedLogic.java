import java.io.*;
import java.util.*;

public class NestedLogic {
    
    public static int calcFines(String a, String b){
    	String ar[] = a.split(" ");
    	String er[] = b.split(" ");
    	
    	int actualreturn[] = new int[ar.length];
    	int expectedreturn[] = new int[er.length];
    	
    	for(int i=0;i<actualreturn.length;i++) {
    		actualreturn[i] = Integer.parseInt(ar[i]);
    		expectedreturn[i] = Integer.parseInt(er[i]);
    	}
    	
    	
    	if(actualreturn[2]<expectedreturn[2]) {
    		if(actualreturn[1]==12 && actualreturn[1]>expectedreturn[1]) {
    			return 0;
    		}
    	}
    	
    	
    	if(actualreturn[2]<=expectedreturn[2]) {
    		if(actualreturn[1]<=expectedreturn[1]) {
    			if(actualreturn[0]<=expectedreturn[0]) {
    				return 0;
    			}else {
        			return (actualreturn[0]-expectedreturn[0])*15;    			
    		    }
    		}else {
    			
    			return (actualreturn[1]-expectedreturn[1])*500;
    		}    		
    	}else return 10000;
    
    	
    	
    
        
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try{
        String actual = bf.readLine();
        String ret = bf.readLine();
            System.out.print(calcFines(actual,ret));
        }
        catch(Exception e){
            System.out.print(e);
        }
        
        
    }
}