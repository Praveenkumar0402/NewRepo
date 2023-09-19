package day9;

class StackFullException extends Exception {
	public StackFullException() {
		System.out.println("Stack is Full");
	}
}

class StackEmptyException extends Exception {
	public StackEmptyException() {
		System.out.println("Stack is Empty");
	}
}

interface Stack {
	void push(String value) throws StackFullException;

	String pop() throws StackEmptyException;

	int length();
}

class MyStack implements Stack {
	String data[] = new String[10];
	int top = 0;

	public void push(String value) throws StackFullException {
		if (top < data.length) {
			data[top] = value;
			top++;
		} else
			throw new StackFullException();
	}

	public String pop() throws StackEmptyException {
		if (top > 0) {
			top--;
			return data[top];
		} else
			throw new StackEmptyException();
	}

	public int length() {
		return top;
	}

	public void print() {
		for (int i = 0; i < top; i++) {
			System.out.println(data[i]);
		}
	}
}

public class PushandPop {

	public static void main(String[] args) throws StackFullException, StackEmptyException {
		MyStack s = new MyStack();
		try {
			s.push("1");
			s.push("2");
			s.push("3");
			s.push("4");
			s.push("5");
			s.push("6");
			s.push("7");
			s.push("8");
			s.push("9");
			s.push("10");

			s.pop();
			s.pop();
			s.pop();
			s.pop();
			s.pop();
			s.pop();
			s.pop();
			s.pop();
			// s.pop();
			// s.pop();
			// s.pop();
		} catch (StackFullException ex) {

		}
		s.print();
	}
}
