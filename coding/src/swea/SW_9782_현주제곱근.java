package A_1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_6782 {
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(reader.readLine());
		long num,index;
		 // 최소 횟수
		for(int t = 1; t <= tc; t++) {
			num = Long.parseLong(reader.readLine());
			result = 0;
			dfs(num, 0);
			System.out.println("#" + t + " " + result);
		}
	}
	static void dfs(long n, int cnt) {
		if (n == 2) {
			result = cnt;
			return;
		}

		double tmp =  Math.sqrt(n);
		if ((int)tmp == tmp) { // 현재 n이 제곱수였다면 바로 루트씌우면 됨.
			dfs((int)tmp, cnt + 1);
		} else { // 그게 아니면 제곱수까지 1 더하는 연산 수행하고 나서 루트씌워야함.
			long tmp2 = (int) tmp;
			cnt += (tmp2 + 1) * (tmp2 + 1) - n;
			dfs(tmp2 + 1, cnt + 1);
		}
	}
}