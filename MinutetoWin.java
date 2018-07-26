
public class MinutetoWin {
	

    // Complete the minuteToWinIt function below.
    static int minuteToWinIt(int[] a, int k) {
        // Return the minimum amount of time in minutes.
    
       int temp[] = new int[a.length];
       
       for(int i=0;i<a.length;i++)
    	   temp[i] = a[i];
       
       
        a[0] = a[1]-k;
        int county = 0;
        for(int i=1;i<a.length;i++){
            int sum = a[i-1]+k;
            if(a[i]!=sum){
                a[i] =sum;
                county++;
            }
        }
    
        int count = 0;
        
        for(int i=1;i<temp.length;i++){
            int sum = temp[i-1]+k;
            if(temp[i]!=sum){
            	
            	temp[i] = sum;
                count++;
            }
        }
        
       // System.out.println(count);
        return Math.min(county+1, count);
    }
    
    public static void main(String[] args) {
		int arr[] = {1 ,2 ,5 ,7 ,9 ,85};
		int k =2;
		int res = minuteToWinIt(arr,k);
		System.out.println(res);
	}

}
