import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class B_17413_단어뒤집기2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();

		Stack<Character> st = new Stack<>();
		for (int i = 0; i < input.length; i++) {

			if (input[i] == ' ') {
				System.out.print(input[i]);
			} else if (input[i] == '<') {
				while (input[i] != '>') {
					System.out.print(input[i]);
					i++;
				}
				System.out.print(input[i]);
			} else {
				while (i < input.length && input[i] != ' ' && input[i] != '<') {
					st.add(input[i]);
					i++;
				}
				while (!st.isEmpty()) {
					System.out.print(st.pop());
				}
				i--;
			}
		}
	}

}

//public class Main {
//
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		char[] input = br.readLine().toCharArray();
//
//		boolean tag = false;
//		Stack<Character> st = new Stack<>();
//		for (int i = 0; i < input.length; i++) {
//			char temp = input[i];
//			
//			if(temp == ' ' || i == input.length - 1) {
//				if(i == input.length - 1) st.add(temp);
//				while(!st.isEmpty()) {
//					System.out.print(st.pop());
//				}
//				if(temp == ' ') System.out.print(temp);
//				continue;
//			}
//
//			if(temp == '>') {
//				tag = false;
//				System.out.print(temp);
//				continue;
//			}
//			if(temp == '<' || tag) {
//				while(!st.isEmpty()) {
//					System.out.print(st.pop());
//				}
//				
//				tag = true;
//				System.out.print(temp);
//				continue;
//			}
//			st.add(temp);
//		}
//	}
//
//}
