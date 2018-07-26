import java.util.*;
import java.io.*;
public class LevelOrdertraversal {
	
	class Node{
	    Node left,right;
	    int data;
	    Node(int data){
	        this.data=data;
	        left=right=null;
	    }
	}

	static void levelOrder(Node root){
	      //Write your code here
	    Stack<Node> stc = new Stack<>();
	    stc.push(root);
	    
	    while(!stc.isEmpty()){
	        Node popped = stc.pop();
	        
	        if(popped.left !=null) stc.push(popped.left);
	        if(popped.right!=null) stc.push(popped.right);
	        
	        System.out.print(popped.data+" ");
	    }
	      
	    }
	
	
    public static void main(String args[]){
            Scanner sc=new Scanner(System.in);
            int T=sc.nextInt();
            Node root=null;
            while(T-->0){
                int data=sc.nextInt();
               // root=insert(root,data);
            }
            levelOrder(root);
        }	
}

