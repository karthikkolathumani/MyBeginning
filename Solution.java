package Heaps;

class Solution {
    
    public static boolean checkPrime(int num){
        if (num == 1) return false;
    if (num == 2) return true;

    int newnum =(int) Math.sqrt(num);

    for (int i = 2; i <= newnum; i++) 
        if (num % i == 0) return false;

    return true;
    }
    
     
    
    public static boolean isPal(int n){
        String temp = n+"";
        char[] arr = temp.toCharArray();
        
        if(arr.length==1) return false;
       
        for(int i = 0, j = arr.length-1;i<arr.length/2 || j>arr.length/2;i++,j--){
             
            if(arr[i]!=arr[j]) return false;
        }
        
        return true;
    }
    
    public static int Palindrome(int n){
         String temp = n+"";
        char[] arr = temp.toCharArray();
        
        while(!isPal(n)){
            n++; 
        }
        
        return n;
    }
    
    public int primePalindrome(int N) {
       
        if(N<=7){
        	
           
            int[] primes = {2,3,5,7};
            int result = -1;
            for(int i = 0 ; i < primes.length;i++){
                if(N<=primes[i]) result = primes[i];
            }
            return result;
        }
        else {
        boolean isPrime = checkPrime(N);
        boolean isPalindrome = false;
        int result = -1;
        
        if(isPrime){
           isPalindrome = isPal(N);
          System.out.println(isPalindrome);
           if(isPalindrome) return N;
           
           
           else{
               while(checkPrime(N) && isPal(N)) {
            	   N++;
               }
               result = N;
               return result;
               
           }
        }
        else {
        	while(checkPrime(N) && isPal(N)) {
         	   N++;
            }
        	result = N;
            return result;
           }
        
        
        }
         
    }
    public static void main(String[] args) {
    	Solution obj = new Solution();
    	
		System.out.println(obj.primePalindrome(13));
	}
}