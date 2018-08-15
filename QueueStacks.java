package CrackingCodingInterview;
import java.util.*;
public class QueueStacks {
	Stack<Integer> stack1;
	Stack<Integer> stack2;
	
	public QueueStacks() {
		stack1 = new Stack<>();
		stack2 = new Stack<>();
	}
	
	public boolean enqueue(int data) {
		
		stack1.push(data);
		return true;
		
	}
	
	public int dequeue() throws Exception {
		
		if(stack2.isEmpty()) {
			while(!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		
		if(!stack2.empty()) return stack2.pop();
		else throw new EmptyStackException();
		
	}
	
	
	public static void main(String[] args) throws Exception{
		
		QueueStacks obj = new QueueStacks();
		obj.enqueue(10);
		obj.enqueue(12);
		obj.enqueue(1);
		obj.enqueue(132);
		obj.enqueue(54);
		obj.enqueue(67);
		System.out.println(obj.dequeue());
		System.out.println(obj.dequeue());
		System.out.println(obj.dequeue());
		System.out.println(obj.dequeue());
		System.out.println(obj.dequeue());
		System.out.println(obj.dequeue());
		System.out.println(obj.dequeue());
	}
	
	
	
	
}
