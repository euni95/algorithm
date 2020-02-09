import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_16637_괄호추가하기 {
	static int N, MAX = Integer.MIN_VALUE;
	static int[] num, original_num;
	static char[] op;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = new int[N/2 + 1];
		original_num = new int[N/2 + 1];
		op = new char[N/2];
		String input = br.readLine();
		for(int i = 0; i < N; i++) {
			char temp = input.charAt(i);
			if(i%2 == 0) original_num[i/2] = temp - '0';
			else op[i/2] = temp;
		}
		con : for(int i = 1; i < (1 << N/2); i++) {
			boolean[] check = new boolean[N/2 + 1];
			for(int j = 0; j < N/2 + 1; j++) {
				if((i & (1 << j)) > 0) {
					if(j != 0 && check[j - 1]) {
						continue con;
					}
					check[j] = true;
				}
			}
//			for(int j = 0; j < N/2 + 1; j++) {
//				System.out.print(check[j] ? 1 : 0);
//			} System.out.println();
			System.arraycopy(original_num, 0, num, 0, N/2+1);
			go(check);
		}
		System.out.println(MAX == Integer.MIN_VALUE ? original_num[0] : MAX);
	}

	private static void go(boolean[] check) {
		boolean[] visited = new boolean[N/2+1];
		for(int i = 0; i < N/2; i++) {
			if(!check[i]) continue;
			num[i] = calc(op[i], num[i], num[i+1]);
			visited[i+1] = true;
		}
		
		int sum = num[0];
		for(int i = 1; i < N/2 + 1; i++) {
			if(visited[i]) continue;
//			System.out.printf("%d %c %d\n", sum, op[i-1], num[i]);
			sum = calc(op[i-1], sum, num[i]);
//			System.out.println(sum);
		}
//		System.out.println(sum);
//		System.out.println();
		MAX = Math.max(MAX, sum);
	}

	private static int calc(char opCode, int num1, int num2) {
		int result = 0;
		switch(opCode) {
		case '+':
			result = num1 + num2;
			break;
		case '-':
			result = num1 - num2;
			break;
		case '*':
			result = num1 * num2;
			break;
		}
		return result;
	}

}
