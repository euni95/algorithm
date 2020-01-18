import java.util.Scanner;
import java.util.Stack;

public class SW_1223_계산기2 { //[S/W 문제해결 기본] 6일차 - 계산기2

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = 10;
		for(int t = 1; t <= TC; t++) {
			Stack<Character> stack = new Stack<>();
			int lineLen = sc.nextInt();
			char[] line = sc.next().toCharArray();
			char[] result = new char[lineLen];
			int index = 0;
			
			for(char ch : line) {
				if(ch >= '0' && ch <= '9') {
					result[index++] = ch;
				}
				else {
					while(!(stack.isEmpty()) && check(ch) <= check(stack.peek())) {
						result[index++] = stack.pop();
					}
					stack.push(ch);
				}
			}
			while(!stack.isEmpty()) {
				result[index++] = stack.pop();
			}
			
			System.out.println("#" + t + " " + calc(result));
		}
		sc.close();
	}

	private static int calc(char[] result) {
		Stack<Integer> stack = new Stack<>();
		int num1, num2, sum = 0;
		
		for(char ch : result) {
			if(ch >= '0' && ch <= '9') {
				stack.push(ch - '0');
			}
			else {
				num2 = stack.pop();
				num1 = stack.pop();
				sum = doCalc(num1, num2, ch);
				stack.push(sum);
			}
		}
		return sum;
	}

	private static int doCalc(int num1, int num2, char ch) {
		int sum = 0;
		
		switch(ch) {
		case '+':
			sum = num1 + num2;
			break;
		case '-':
			sum = num1 - num2;
			break;
		case '*':
			sum = num1 * num2;
			break;
		case '/':
			sum = num1 / num2;
			break;
		}
		return sum;
	}

	private static int check(char ch) {
		int checkNum = 0;
		switch(ch) {
		case '+': case '-':
			checkNum = 1;
			break;
		case '*': case '/':
			checkNum = 2;
			break;
		}
		return checkNum;
	}

}
