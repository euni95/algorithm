import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SW_1232 { // [S/W 문제해결 기본] 9일차 - 사칙연산
	static int N;
	static String[] arr;
	static Child[] child;

	static class Child {
		int left;
		int right;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = 3;
		for (int t = 1; t <= T; t++) {
			list = new ArrayList<>();
			N = Integer.parseInt(br.readLine());
			arr = new String[N + 1];
			child = new Child[N + 1];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken());
				arr[num] = st.nextToken();
				child[num] = new Child();
				if (st.hasMoreTokens()) {
					child[num].left = Integer.parseInt(st.nextToken());
				}
				if (st.hasMoreTokens()) {
					child[num].right = Integer.parseInt(st.nextToken());
				}
			}
			postOrder(1);
			System.out.println(list);
//			while (true) {
//				for (int i = 0; i < list.size(); i++) {
//					String s = list.get(i);
//					if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
//						double a = Double.parseDouble(list.get(i - 2));
//						double b = Double.parseDouble(list.get(i - 1));
//						double temp = calc(a, b, s);
//						list.remove(i - 2);
//						list.remove(i - 2);
//						list.remove(i - 2);
//						list.add(i - 2, String.valueOf(temp));
//						break;
//					}
//				}
//				if (list.size() == 1)
//					break;
//			}
//			System.out.println("#" + t + " " + list.get(0));
		}
	}

	private static void postOrder(int start) {
		if (arr[start] == null)
			return;
		postOrder(child[start].left);

//		list.add(arr[start]);
		postOrder(child[start].right);
		list.add(arr[start]);
	}

	static ArrayList<String> list = new ArrayList<>();

	private static double calc(double a, double b, String op) {
		double result = 0.0;
		switch (op) {
		case "+":
			result = a + b;
			break;
		case "-":
			result = a - b;
			break;
		case "*":
			result = a * b;
			break;
		case "/":
			result = a / b;
			break;
		}
		return result;
	}
}
