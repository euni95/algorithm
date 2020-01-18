import java.util.Scanner;
import java.util.Stack;

public class SW_1224_계산기3 { // [S/W 문제해결 기본] 6일차 - 계산기3

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// Scanner sc = new Scanner(new FileReader(fileName));

		for (int t = 1; t <= 10; t++) {
			Stack<Character> stack = new Stack<>();
			int lineLen = sc.nextInt();
			char[] line = sc.next().toCharArray();
			String result = "";

			for (char ch : line) {
				if (Character.isDigit(ch)) {
					result += ch;
				}

				else if (ch == '(') {
					stack.push(ch);
				}

				else if (ch == ')') {
					while (!(stack.isEmpty()) && stack.peek() != '(') {
						result += stack.pop();
					}
					stack.pop();
				}

				else {
					while (!(stack.isEmpty()) && getPriority(ch) <= getPriority(stack.peek())) {
						result += stack.pop();
					}
					stack.push(ch);
				}

			}
			while (!stack.isEmpty()) {
				result += stack.pop();
			}

			System.out.println("#" + t + " " + calc(result));
		}
		sc.close();

	}

	static public int calc(String line) {
		char[] temp = line.toCharArray();
		Stack<Integer> stack = new Stack<>();
		int num1, num2, sum = 0;

		for (char ch : temp) {
			
			if (Character.isDigit(ch)) {
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
		
		switch (ch) {
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

	static public int getPriority(char ch) {
		int type = 0;

		switch (ch) {
		case '*':
		case '/':
			type = 2;
			break;
		case '+':
		case '-':
			type = 1;
			break;
		}
		return type;
	}

}
