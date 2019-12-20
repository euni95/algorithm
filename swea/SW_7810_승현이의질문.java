package A_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_7810_승현이의질문 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());		
			int[] count = new int[1000001];
			int max = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				 int temp = Integer.parseInt(st.nextToken());
				 count[temp]++;
				 if(temp > max) max = temp;
			}
			int cnt = 0;
			int result = 0;
			for(int i = max; i >= 0; i--) {
				cnt += count[i];
				if(cnt >= i) {
					result = i;
					break;
				}
			}
			System.out.println("#" + t + " " + result);
		}
	}
}
