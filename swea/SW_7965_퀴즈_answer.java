package A_1;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

//7965. 퀴즈
// 분할 정복과 메모이제이션
//1^1 + 2^2 + 3^3 + 4^4 + 5^5 = 1 + 4 + 27 + 256 + 3125 = 3413
//나머지 연산은 전체 합산 하기전 나머지의 합을  중간중간에 해도 결과 같음.
// (7 + 8 + 9 + 10) % 3 =>  1
// (7%3 + 8%3 + 9%3 + 10%3) % 3 =>(1 + 2 + 3 + 1) % 3 =>1  
public class SW_7965_퀴즈_answer {
	static int MOD = 1000000007;
	public static void main(String[] args) throws IOException{
		
		long[] memo = new long[1000001];
		
		
		for(int i = 1 ; i <=1000000; i++) {
			memo[i] = (memo[i-1] + pow(i,i)) % MOD;
		}
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(reader.readLine());
		int idx = 0;
		for(int t = 1; t <= TC; t++) {
			idx = Integer.parseInt(reader.readLine());
			
			System.out.println("#" + t + " " + memo[idx]);
		}

	}

	static long pow(int a, int b) {
		if(b == 0) {
			return 1;
		}
		if(b == 1) {
			return a;
		}
		long temp = pow(a, b/2);
		if(b%2 == 0) {
			return (temp * temp) % MOD;
		}else {
			return ((temp * temp) % MOD * a) % MOD;
		}
	}

}
