import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_1463_1로만들기 { //dp
	static int[] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		min = Integer.MAX_VALUE;
		dp = new int[N + 1];
		Arrays.fill(dp, -1);
		
		System.out.println(calc(N));
		System.out.println(Arrays.toString(dp));
	}
	
	static int min;
	private static int calc(int n) {
		
		if(n == 1) {
			return 0;
		}
		
		if(dp[n] != -1) {
			return dp[n];
		}
		
		int ret = Integer.MAX_VALUE;
		if(n % 3 == 0) ret = Math.min(ret, calc(n/3) + 1);
		if(n % 2 == 0) ret = Math.min(ret, calc(n/2) + 1);
		ret = Math.min(ret, calc(n - 1) + 1);
		
		return dp[n] = ret;
	}

}
