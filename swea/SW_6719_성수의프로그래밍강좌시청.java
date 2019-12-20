import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SW_6719_성수의프로그래밍강좌시청 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 강좌 총 개수
			int K = Integer.parseInt(st.nextToken()); // 들을 강좌 개수
			
			st = new StringTokenizer(br.readLine());
			PriorityQueue<Integer> q = new PriorityQueue<>();
			
			for(int i = 0; i < N; i++) q.add(Integer.parseInt(st.nextToken()));
			
			double result = 0;
			for(int i = 0; i < N; i++) {
				int temp = q.poll();
				if(i < (N-K)) continue;
				result = (double) (result + temp) / 2;
			}
			System.out.println("#" + t + " " + String.format("%.6f", result));
		}
	}
	
}
