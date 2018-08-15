package CrackingCodingInterview;

public class EfficientTwoStacks {

	int stack[];
	int size;
	int stack1;
	int stack2;
	public EfficientTwoStacks(int size) {
		this.stack = new int[size];
		this.size = size;
		this.stack1 = 0;
		this.stack2 = size-1;
	}
	
	public boolean push(int stackNumber, int data) throws Exception {
		
		switch(stackNumber) {
			case 1:{
				if(!isFull()) {
					stack[stack1++] = data;
					return true;
				}
				else throw new Exception("Stack is full");
			}
			
			case 2:{
				if(!isFull()) {
					stack[stack2--] = data;
					return true;
				}
				else throw new Exception("Stack is Full");
			}
		}
		
		throw new Exception("Unable to perform push on : "+stackNumber);
		
	}
	
	public int pop(int stackNumber) throws Exception {
		
		switch(stackNumber) {
		case 1:{
			if(!isEmpty(stackNumber)) {
			stack1--;
			int result = stack[stack1];
			stack[stack1] = 0;
			return result;
			}
			else throw new Exception("Stack "+ stackNumber+" is empty.");
		}
		case 2:{
			if(!isEmpty(stackNumber)) {
				stack2++;
				int result = stack[stack2];
				stack[stack2] = 0;
				return result;
			}
			else throw new Exception("Stack "+stackNumber+" is empty.");
			
		}
		}
		
		throw new Exception("Operation Invalid");
	}
	
	public boolean isFull() {
		return (stack1>stack2 || stack2<stack1);
	}
	
	public boolean isEmpty(int stackNumber) throws Exception {
		switch(stackNumber) {
		case 1: return stack1<0;
		case 2: return stack2>size-1;
		}
		throw new Exception("The mentioned satckNumber is not available : "+stackNumber);
	}
	
	public int peek(int stackNumber) throws Exception {
		
		switch(stackNumber) {
		case 1:{
			stack1--;
			return stack[stack1];
		}
		case 2:{
			stack2++;
			return stack[stack2];
		}
		}
		
		throw new Exception("Operation Invalid");
	}
	
	
	
	public static void main(String[] args) throws Exception {
		EfficientTwoStacks obj = new EfficientTwoStacks(8);
		obj.push(1,2);
		obj.push(1, 9);
		obj.push(1, 9);
		obj.push(1, 1);
		obj.push(2, 1);
		obj.push(2, 1);
		obj.push(2, 9);
		obj.push(2, 2);
		for(Integer c: obj.stack) System.out.print(c+" "); 
		System.out.println();
		obj.pop(2);
		for(Integer c: obj.stack) System.out.print(c+" "); 
		
	}
	
}


