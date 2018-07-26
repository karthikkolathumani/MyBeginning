import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.*;



public class ModifiedBinarySearchNextSmallest {
	
	public static int[] climbingLeaderboard(int a[],int b[]) {
		SortedSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        ArrayList<Integer> list = new ArrayList<>();
        int [] output = new int[b.length];
        boolean assigned = false;
        for(int i:a) set.add(i);
        for(int i:set) list.add(i);
        int rank = -1;
        int j = 0;
        
        for(int i=b.length-1;i>=0;i--){
            
            while(j<list.size()){
                if(b[i]<list.get(j)){
                	assigned = false;
                    rank = j;
                    j++;
                }
                else if (b[i]>list.get(j)){
                	assigned = true;
                	if(j==0) rank = j;
                	else
                    rank = j;
                    break;
                }
                else{
                	assigned = true;;
                    rank = j;
                    break;
                }
            }
            if(assigned==false) rank = list.size();
            output[i] = rank+1;
            j = rank;
        }
    
        return output;
		
		
	}

		
	
	
	
	public static void main(String[] args) {
		int a[] = {100,100,50,40,20,10};
		int b[] = {5,25,50,120};
		
		int output[] = climbingLeaderboard(a,b);
		
		for(int x:output) System.out.println(x);
	}
	
	

}
