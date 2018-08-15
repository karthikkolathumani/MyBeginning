package CrackingCodingInterview;

public class StackMin {

	int stack[];
	int top = 0;
	int size;
	int min;
	int minimum[];
	int minIndex;
	public StackMin(int size) {
		this.stack = new int[size];
		this.size = size;
		this.min = Integer.MAX_VALUE;
		this.minimum = new int[size];
		this.minIndex = 0;
	}
	
	public boolean push(int data)throws Exception {
		
		if(!isFull()) {
			//System.out.println(min);
			if(min>=data) {
				minimum[minIndex++] = data;
				min = data;
			}
			stack[top++] = data;
			return true;
		}
		else throw new Exception("Stack is full");
	}
	
	public int getMin() throws Exception {
		if(minIndex<0) throw new Exception("Stack is empty");
		return minimum[minIndex-1];
	}
	
	
	public boolean isFull() {
		return top>=stack.length;
	}
	
	public boolean isEmpty() {
		return (top<0);
	}
	
	public int pop() throws Exception {
		if(!isEmpty()) {
		top--;
		int result = stack[top];
		if(result == minimum[minIndex-1]) {
			minIndex--;
		}
		stack[top] = 0;
		return result;
		}
		else throw new Exception("Stack is empty");
	}
	
	public static void main(String[] args) throws Exception {
		StackMin obj = new StackMin(8);
		obj.push(5);
		obj.push(6);
		obj.push(4);
		obj.push(3);
		obj.push(3);
		obj.push(99);
		obj.push(3);
		obj.push(0);
		//obj.push(0);
		//obj.pop();
		System.out.println(obj.getMin());
		for(Integer c:  obj.stack) System.out.print(c+" ");
		System.out.println();
		for(Integer c:  obj.minimum) System.out.print(c+" ");
		
	}
}
