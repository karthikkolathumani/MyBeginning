
public class LibraryFines {
static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
        
        if(y2-y1==1 && m2-m1==11 && d2-d1==30) return 0;
        
        
        if((y2-y1)>0) return 0;
        else if ((y2-y1)==0){
           if(m2-m1>0) return 0;
           else if(m2-m1==0){
               if(d2-d1>0) return 0;
               else if((d2-d1)==0) return 0;
               else return 15*(Math.abs(d2-d1));
           }
           else return 500*(Math.abs(m1-m2)); 
           }
            
        else return 10000;
        
        

    }

public static void main(String[] args) {
	System.out.println(libraryFine(2,7,1014,1,1,1014));
}

}
