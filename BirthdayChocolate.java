import java.util.*;

public class BirthdayChocolate {

static int solve(int[] s, int d, int m) {
		int sumUntilNow = 0;
	for(int i=0;i<m;i++) {
		sumUntilNow += s[i];
		
	}
	int count=0;
	if(sumUntilNow==d) count++;
	int windowSum = sumUntilNow;
	
	for(int i=m;i<s.length;i++) {
		
		windowSum += s[i] - s[i-m];
		if(windowSum==d) count++;
	}
	return count;
	
	
	
		
        
	
    }


public static void main(String[] args) {
	int a[] = {4};
	System.out.println(solve(a,4,1));
}
	
}
