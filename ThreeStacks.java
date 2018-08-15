package CrackingCodingInterview;

import java.util.EmptyStackException;

public class ThreeStacks {

	
	int stack[];
	int length;
	
	int partition1;
	int partition2;
	int partition3;
	
	public ThreeStacks(int size) {
		
		this.stack = new int[3*size];
		this.length = this.stack.length;
		calculatePartititon();
	}
	
	public void calculatePartititon() {
		partition1 = (length/3) -1;
		partition2 = ((2*length)/3)-1;
		partition3 = ((3*length)/3)-1; 
		
	}
	
	
	public boolean push(int stackNumber,int data) throws Exception {
		switch(stackNumber) {
			
		case 1:{
			if(isEmpty(stackNumber)) {
				throw new Exception("Yo Full Yo : "+stackNumber);
				
			}
			else {
				stack[partition1--] = data;
				return true;
				
			}
			
		}
		case 2:{
			if(isEmpty(stackNumber)) {
				throw new Exception("Yo Full Yo : "+stackNumber);
				
			}
			else {
				stack[partition2--] = data;
				return true;
				
			}
			
		}
		case 3:{
			if(isEmpty(stackNumber)) {
				throw new Exception("Yo Full Yo : "+stackNumber);
				//break;
				
			}
			else {
				stack[partition3--] = data;
				return true;
			}
			//break;
		}
	
		
		}
		return false;
	}
	
	public boolean isEmpty(int stackNumber) {
		switch(stackNumber) {
		case 1:{
			if(partition1==-1 || partition1==(length/3)) return true;
			else return false;
			
		}
		case 2:{
			if(partition2==((length/3) -1) || partition2==((2*length)/3)){
				return true;
			}
			else return false;
			
		}
		case 3:{
			if(partition3==((2*length)/3)-1|| partition3==((3*length)/3)) return true;
			else return false;
		
		}
		
		}
		System.out.println("No condition Executed");
		return false;
	}
	
	
	public int pop(int stackNumber) throws Exception {
		
		switch(stackNumber) {
		
		case 1:{
			partition1++;
			if(isEmpty(stackNumber)) throw new EmptyStackException();
			else {
				
				int result = stack[partition1];
				stack[partition1] = 0;
				return result;
			}
		
		}
		case 2:{
			partition2++;
			if(isEmpty(stackNumber)) throw new EmptyStackException();
			else {
				
				int result = stack[partition2];
				stack[partition2] = 0;
				return result;
			}
		}
		case 3:{
			partition3++;
			if(isEmpty(stackNumber)) throw new EmptyStackException();
			else {
				
				int result = stack[partition3];
				stack[partition3] = 0;
				return result;
			}
		}
		}
		throw new Exception("Some Error Occured");
	}
	
	public int peek(int stackNumber) throws Exception{
		
		switch(stackNumber) {
		case 1:{
			if(isEmpty(stackNumber)) throw new EmptyStackException();
			else {
				return stack[partition1+1];
			}
		}
		case 2:{
			if(isEmpty(stackNumber)) throw new EmptyStackException();
			else {
				return stack[partition2+1];
			}
		}
		case 3:{
			if(isEmpty(stackNumber)) throw new EmptyStackException();
			else {
				return stack[partition3+1];
			}
		}
		}
		
		throw new Exception("Somethings not right");
		
	}
	
	public static void main(String[] args) throws Exception {
		ThreeStacks obj = new ThreeStacks(2);
		
		System.out.println(obj.push(1,1));
		System.out.println(obj.push(1,2));
		System.out.println(obj.push(2,3));
		System.out.println(obj.push(2,4));
		System.out.println(obj.push(3,4));
		System.out.println(obj.push(3,4));
		
		System.out.println(obj.isEmpty(2));
		System.out.println(obj.pop(2));
		System.out.println(obj.pop(2));
		System.out.println(obj.pop(1));
		System.out.println(obj.peek(1));
		for(Integer c: obj.stack) System.out.print(c+" ");
	}
	
	
}
