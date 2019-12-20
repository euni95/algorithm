import java.util.Scanner;

//스택을 이용한 괄호 검사
public class SW_1218_스택을이용한괄호검사 {
	static int result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t = 1; t < 11; t++) {
			int len = sc.nextInt();
			SStack stack = new SStack(len);
			String st = sc.next();
			char[] line = st.toCharArray();
			
			
			for(int i = 0; i < len; i++) {
				char d = line[i];
				System.out.println(stack.top);
				if(d == '(' || d == '[' || d == '{' || d == '<') stack.push(d);
				else {
					if(stack.top == -1) {
						result = 0;
						continue;
					}
					char checkChar = line[stack.top];
					if((checkChar == '(' && d == ')') || (checkChar == '[' && d == ']') || (checkChar == '{' && d == '}') || (checkChar == '<' && d == '>')) {
						stack.pop();
					} else {
						result = 0;
						break;
					}
					
				}
				if(stack.top > -1) {
					result = 0;
					continue;
				}
				result = 1;
			}
			System.out.println("#" + t + " " + result);
		}
	}

	static class SStack {
		//최대 사이즈
		private int size;
		private char[] datas = null;
		private int top = -1;
		
		//생성자 오버로딩
		public SStack(int size) {
			this.size = size;
			datas = new char[size];
			top = -1;
		}
		
		public void check(char d) {
		

 		}
		
		public char pop() {
			System.out.println("dddddd");
			if(isEmpty()) {
				System.out.println("empty");
				return '\u0000';
			}
			return datas[top--];
			
		}
		
		public void push(char d) {
			if(isFull()) {
				System.out.println("full");
				return;
			}
			
			datas[++top] = d;
		}
		
		public boolean isFull() {
			return top + 1 == size;
		}
		
		public boolean isEmpty() {
			return top == -1;
		}
	}
}
