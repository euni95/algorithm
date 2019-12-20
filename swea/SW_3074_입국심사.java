import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_3074_입국심사 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 심사대 개수
 			int M = Integer.parseInt(st.nextToken()); // 인원
 			
 			long[] tk = new long[N];
 			long max = 0;
 			for(int i = 0; i < N; i++) {
 				tk[i] = Integer.parseInt(br.readLine());
 				if(max < tk[i]) max = tk[i];
 			}
 			
 			long start = 0;
 			long end = max * M;
 			long p = 0;
 			long mid = 0;
 			long result = Long.MAX_VALUE;
 			while(start <= end) {
 				mid = (start + end) / 2;
 				
 				p = 0;
 				for(int i = 0; i < N; i++) {
 					p += mid / tk[i];
 				}
 				if(p >= M) {
 					if(result > mid) result = mid;
 					end = mid - 1;
 				}
 				else start = mid + 1;
 			}
 			System.out.println("#" + t + " " + result);
		}
	}

}
