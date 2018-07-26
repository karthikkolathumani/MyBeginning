
public class Grouping {
	
	static int whichSection(int n, int k, int[] a) {
        // Return the section number you will be assigned to assuming you are student number k.
        
        int comp [] = new int[a.length];
        
        comp[0] = a[0];
        
        for(int i=1;i<a.length;i++){
            comp[i] = comp[i-1] + a[i];
            
        }
        int group = 1;
        
        for(int c: comp) System.out.print(c+" ");
        
        for(int i=comp.length-1;i>=0;i--){
        	if(comp[i]<k) return i+2;
        	else if(comp[i]==k) return i+1;
        }
        return group;
    }
	
	public static void main(String[] args) {
		int a[] = {11, 24 ,420, 6 ,9};
		System.out.println(whichSection(9,469,a));
	}

}
