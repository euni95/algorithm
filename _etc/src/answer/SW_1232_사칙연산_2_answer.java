package answer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW_1232_사칙연산_2_answer { // 쌤꺼
	static String[] tree;
	static int N;
	static int[][] fl;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int TC = 1; TC <= 10; TC++) {
			N = Integer.parseInt(br.readLine());
			tree = new String[N + 1];
			fl = new int[N + 1][3];
			String input;
			String[] inputs;
			for (int i = 1; i <= N; i++) {
				input = br.readLine();
				inputs = input.split(" ");
				tree[i] = inputs[1];
				if (inputs.length > 2) {
					fl[i][1] = Integer.parseInt(inputs[2]);
					fl[i][2] = Integer.parseInt(inputs[3]);
				}
			}
			System.out.println("#" + TC + " " + (int) inOrder(1));
		}
	}

	private static double inOrder(int index) {
		if (index >= N + 1)
			return 0;
		if (tree[index].equals("+")) 
		{
			return inOrder(fl[index][1]) + inOrder(fl[index][2]);
		} 
		else if (tree[index].equals("-")) 
		{
			return inOrder(fl[index][1]) - inOrder(fl[index][2]);
		} 
		else if (tree[index].equals("*")) 
		{
			return inOrder(fl[index][1]) * inOrder(fl[index][2]);
		} 
		else if (tree[index].equals("/")) 
		{
			return inOrder(fl[index][1]) / inOrder(fl[index][2]);
		} 
		else {
			return Integer.parseInt(tree[index]);
		}
	}
}