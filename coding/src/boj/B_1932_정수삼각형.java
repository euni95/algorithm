import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1932_정수삼각형 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] tri = new int[N][N];
		int[] memo = new int[N];
		int[] temp = new int[N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			System.arraycopy(memo, 0, temp, 0, N);
			for(int j = 0; j < N; j++) {
				if(!st.hasMoreTokens()) {
					break;
				} else {
					tri[i][j] = Integer.parseInt(st.nextToken());
					if(i == 0) {
						memo[j] = tri[i][j];
					}
					else {
						if(j == 0) {
							memo[j] = tri[i][j] + temp[j];
						} else {
							memo[j] = Math.max(temp[j-1], temp[j]) + tri[i][j];
						}
					}
				}
			}
			
		}
		int result = 0;
		for(int i = 0; i < N; i++) result = Math.max(result, memo[i]);
		System.out.println(result);
	}

}
