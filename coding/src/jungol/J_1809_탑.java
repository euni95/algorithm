import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class J_1809_탑 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int towerNum = Integer.parseInt(br.readLine());
		Stack<Point> stack = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < towerNum; i++) {
			int num = Integer.parseInt(st.nextToken());

			if (stack.isEmpty()) {
				stack.push(new Point(num, i+1));
				sb.append("0 ");
			} else {
				if (stack.peek().num > num) {
					sb.append(stack.peek().idx + " ");
				} else {
					while (!(stack.isEmpty()) && stack.peek().num <= num) {
						stack.pop();
					}
					if (stack.isEmpty()) sb.append("0 ");
					else sb.append(stack.peek().idx + " ");
				}
				stack.push(new Point(num, i+1));
			}
		}
		System.out.println(sb.toString());

	}

	static class Point {
		int num, idx;

		public Point(int num, int idx) {
			this.num = num;
			this.idx = idx;
		}

	}
}