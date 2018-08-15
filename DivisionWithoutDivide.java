package leetcode;

public class DivisionWithoutDivide {
// Doesnt work for large numbers
	
	   public static int divide(int dividend, int divisor) {
	        
	        int q = 0; 
	        int nextDivident = dividend;
	        
	        while(nextDivident > divisor){
	            
	            while(q<=nextDivident) {
	            	System.out.println("Yo");
	            	q+= divisor;
	            }
	            
	            nextDivident += nextDivident-q; 
	            System.out.print("hello");

	           
	        }
	        int count =0;
	        int county =0;
	        while(count<q) {
	        	System.out.print("hello");
	        	count +=divisor;
	        	county++;
	        }
	        return county;
	    }
	   
	   public static void main(String[] args) {
		System.out.println(divide(2147483647
				,1));
	}
	
}
