import java.util.ArrayList;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

public class CutTheSticks {
	
static int[] cutTheSticks(int[] arr) {
        
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> out = new ArrayList<>();
        
        
        for(int c:arr) list.add(c);
        
        
        
        Collections.sort(list);
        
        
        
        
        while(list.size()!=0){
            int toRemove = list.get(0);
            //System.out.println(list.get(0));
            out.add(list.size());
            while(list.contains(toRemove)) {
            	int idx = list.indexOf(toRemove);
            	list.remove(idx);
            }
            for(int i=0;i<list.size();i++){
                list.set(i, list.get(i)-toRemove);
                
            }
        }
        
        int[] output = new int[out.size()];
        
        for(int i=0;i<out.size();i++){
            output[i] = out.get(i);
        }
    return output;
    }

	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 3, 3, 2, 1 };
		int out[] = cutTheSticks(arr);
		
		for(int y:out) System.out.println(y);
	}

}
