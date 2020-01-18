import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW_7965_퀴즈 {
	static final int DIV = 1000000007;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		long[] memo = new long[1000001];
		
		for(int i = 1; i <= 1000000; i++) {
			memo[i] = (memo[i-1] + divide(i,i)) % DIV;
		}
		
		for(int t = 1; t <= T; t++) {
			int num = Integer.parseInt(br.readLine());
			System.out.println(memo[num]);
		}
	}
	private static long divide(int base, int exp) { //밑, 지수
		if(exp == 0) return 1;
		if(exp == 1) return base;
		
		long num = divide(base, exp/2);
		if(exp % 2 == 0) {
			return (num * num) % DIV;
		}
		else {
			return ((num * num) % DIV * base) % DIV;
		}
	}

}
