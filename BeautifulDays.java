
public class BeautifulDays {
	
	static int reverse(int a){
        String aS = a +"";
        StringBuilder newS = new StringBuilder();
        boolean isStarting = true;
        char aC[] = aS.toCharArray();
        
        for(int i=0;i<aC.length/2;i++){
            char temp = aC[i];
            aC[i] = aC[aC.length - i-1];
            aC[aC.length - i-1] = temp;
        }
        
        
        for(int i=0;i<aC.length;i++){
            if(aC[i]=='0' && isStarting) continue;
            else{
                isStarting = false;
                newS.append(aC[i]);
            }
        }
        
        return Integer.parseInt(newS.toString());
        
    }

    // Complete the beautifulDays function below.
    static int beautifulDays(int i, int j, int k) {
        int count = 0;
        for(int x=i;x<=j;x++){
        	
            int reversed = reverse(x);
            //System.out.println(reversed);
            if(Math.abs(x-reversed)%k==0) count++;
        }
        return count;
    }
    
    public static void main(String[] args) {
    	System.out.println(beautifulDays(20,23,6));
	}

}
