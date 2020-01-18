import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_14888_연산자끼워넣기 {
	static int N;
	static int[] num;
	static int[] op = new int[4];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) num[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) op[i] = Integer.parseInt(st.nextToken());
		
		calc(0, num[0]);
		System.out.println(max);
		System.out.println(min);
	}
	
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	private static void calc(int n, int result) {
		if(n == N - 1) {
			if(max < result) max = result;
			if(min > result) min = result;
			return;
		}
		
		if(op[0] > 0) {
			op[0]--;
			calc(n + 1, result + num[n+1]);
			op[0]++;
		}
		if(op[1] > 0) {
			op[1]--;
			calc(n + 1, result - num[n+1]);
			op[1]++;
		}
		if(op[2] > 0) {
			op[2]--;
			int temp = result * num[n+1];
			calc(n + 1, temp);
			op[2]++;
		}
		if(op[3] > 0) {
			op[3]--;
			int temp = Math.abs(result)/num[n+1];

			if(result < 0) {
				calc(n + 1, -temp);
			} else {
				calc(n + 1, temp);
			}
			
			op[3]++;
		}
	}

}
