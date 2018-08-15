package CrackingCodingInterview;
import java.util.*;



public class SetOfStacks {
	
	ArrayList<Stack> stack;
	int capacity;
	int pointer;
	
	public SetOfStacks(int size) {
		this.capacity = size;
		this.pointer = 0;
		this.stack = new ArrayList<>();
		Stack<Integer> newStack = new Stack<>();
		stack.add(newStack);
	}
	
	
	public boolean push(int data) {
		Stack<Integer> curr = stack.get(pointer);
		if(curr.size()==capacity) {
			Stack<Integer> newStack = new Stack<>();
			newStack.push(data);
			stack.add(newStack);
			pointer++;
			return true;
		}else {
			curr.push(data);
			return true;
		}
		
	}
	
	public int pop() throws EmptyStackException{
		Stack<Integer> temp = stack.get(pointer);
		if(temp==null) throw new EmptyStackException();
		else {
			int result = temp.pop();
			if(temp.size()==0) pointer--;
			return result;
		}
	}
	
	public int popAt(int stackNumber) throws NullPointerException {
		if(stackNumber>=stack.size()) throw new NullPointerException();
		else {
			Stack<Integer> temp = stack.get(stackNumber);
			if(temp.size()==0) throw new EmptyStackException();
			else return temp.pop();
		}
	}
	
	public static void main(String[] args) {
		SetOfStacks obj = new SetOfStacks(3);
		obj.push(1);
		obj.push(2);
		obj.push(3);
		obj.push(4);
		obj.push(5);
		obj.push(6);
		obj.push(7);
		obj.push(8);
		obj.push(9);
		//obj.push(10);
		System.out.println(obj.stack.size());
		System.out.println();
		
		System.out.println(obj.popAt(2));
		System.out.println(obj.popAt(2));
		System.out.println(obj.popAt(2));
		System.out.println(obj.popAt(2));
	}
}
