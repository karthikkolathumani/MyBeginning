import java.util.Arrays;
import java.util.Collections;

public class ElectronicShop {
	
	public static int calculate(int a[],int b[],int bud) {
		
		
		//Arrays.sort(a,Collections.reverseOrder());	
		Arrays.sort(b);
		
		int larg[] = (a.length>b.length)? a:b;
		int smal[] = (a.length>b.length)? b:a;
		
		int max = 0;
		for(int i=0;i<larg.length;i++) {
			if(larg[i]<bud) {
				int numToFind = bud - larg[i];
				int x = Arrays.binarySearch(smal, numToFind);
				if(x==1) {
					max = Math.max(max, numToFind+larg[i]);
				}
				else {
					int low = 0;
					int high = smal.length -1;
					int jusSmall = -1;
					while(low<=high) {
						int mid = (low+high)/2;
						jusSmall = smal[mid];
						if(smal[mid]<numToFind) high = mid-1;
						else if (smal[mid]>numToFind) low = mid+1;
						else break;
						
					}
					
					max = Math.max(max, jusSmall+larg[i]);
					
					
				}
				
			}
		}
		
		if(max==0) return -1;
		return max;
		
		
	}
	
	
	public static void main(String[] args) {
		int a[] = {4};
		
		int b[] = {5};
		int bud = 5;
		System.out.println(calculate(a,b,bud));
	}
}
