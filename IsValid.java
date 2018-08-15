package leetcode;
import java.util.*;
public class IsValid {
	
	
	public static boolean isValid(String s) {
		if(s==null || s.length()==0) return false; 
        Stack<Character> stac = new Stack<>();
        
        for(int i = 0 ; i < s.length() ;i++){
            char c = s.charAt(i);
            System.out.println(c);
            switch(c){
                case '{': {
                    stac.push(c);
                    break;
                }
                case '(': {
                	
                    stac.push(c);
                    break;
                }
                case '[': {
                    stac.push(c);
                    break;
                }
                case '}':{
                	if(!stac.isEmpty()) {
                    char x = stac.pop();
                    if (x!='{') return false;
                    break;
                	}else return false;
                    
                }
                case ']':{
                	if(!stac.isEmpty()) {
                    char x = stac.pop();
                    if(x!='[') return false;
                    break;
                	}else {
                		return false;
                	}
                }
                case ')': {
                	if(!stac.isEmpty()) {
                    char x = stac.pop();
                    if(x!='(') return false;
                    break;
                	}else {
                		return false;
                		
                	}
                }
            }   
        }
        
        if(!stac.isEmpty()) return false;
        else return true;
        
    }
	
	public static void main(String[] args) {
		String test = "))))";
		System.out.println(isValid(test));
	}
}
