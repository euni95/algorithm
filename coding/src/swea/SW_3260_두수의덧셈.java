import java.util.Scanner;
import java.util.Stack;

public class SW_3260_두수의덧셈 { //0725 workshop _ 두 수의 덧셈
	static int[] result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			Stack<Character> stackA = new Stack<Character>();
			Stack<Character> stackB = new Stack<Character>();
			
			char[] A = sc.next().toCharArray();
			char[] B = sc.next().toCharArray();
			
			for(int i = 0; i < A.length; i++) {
				stackA.push(A[i]);
			}
			
			for(int i = 0; i < B.length; i++) {
				stackB.push(B[i]);
			}
			
			if(A.length < B.length) {
				result = new int[B.length+1];
				add(B.length, stackB, stackA);
			}
			else {
				result = new int[A.length+1];
				add(A.length, stackA, stackB);
			}
			
			System.out.print("#" + t + " ");
			for(int i = 0; i < result.length; i++) {
				if(i == 0 && result[i] == 0) continue;
				System.out.print(result[i]);
			}System.out.println();
		}
	}
	
	static void add(int len, Stack<Character> stackA, Stack<Character> stackB) {
		boolean check = false;
		int a = 0, b = 0, sum;
		for(int i = 0; i < len; i++) {
			a = stackA.pop() - '0';
			b = 0;
			if(!stackB.isEmpty()) b = stackB.pop() - '0';
			
			
			if(check) a++;
			sum = a + b;
			if(sum > 9) {
				check = true;
			}
			else check = false;
			
			if(i == len - 1 && check && sum > 9) {
				result[0] = 1;
			}
			result[len-i] = sum%10;
			
		}
	}
}
