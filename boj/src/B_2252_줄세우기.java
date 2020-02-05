import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_2252_줄세우기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] cnt = new int[N+1];
		ArrayList<Integer>[] student = new ArrayList[N+1];
		for(int i = 0; i <= N; i++) student[i] = new ArrayList<>();
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()); // 앞
			int B = Integer.parseInt(st.nextToken()); // 뒤
			student[A].add(B);
			cnt[B]++;
		}
		
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1; i <= N; i++) if(cnt[i] == 0) q.add(i);
		while(!q.isEmpty()) {
			int poll = q.poll();
			sb.append(poll).append(" ");
			for(int i = 0; i < student[poll].size(); i++) {
				int temp = student[poll].get(i);
				if(--cnt[temp] == 0) {
					q.add(temp);
				}
			}
		}
		System.out.println(sb);
		
	}
}
