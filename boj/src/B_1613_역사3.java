import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1613_역사3 {
	static int n, k, s;
	static boolean[][] map;
	static boolean[] v;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		map = new boolean[n + 1][n + 1];
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int one = Integer.parseInt(st.nextToken());
			int two = Integer.parseInt(st.nextToken());
			map[one][two] = true;
		}
		for(int i = 1; i <= n; i++) {
			v = new boolean[n + 1];
			if(!v[i]) {
				v[i] = true;
				bfs(i);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		s = Integer.parseInt(br.readLine());
		for(int i = 0; i < s; i++) {
			st = new StringTokenizer(br.readLine());
			int one = Integer.parseInt(st.nextToken());
			int two = Integer.parseInt(st.nextToken());
			
			boolean ch1 = map[one][two];
			boolean ch2 = map[two][one];
			
			if(!ch1 && !ch2) sb.append(0).append("\n");
			else if(!ch1 && ch2) sb.append(1).append("\n");
			else if(ch1 && !ch2) sb.append(-1).append("\n");
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				System.out.print(map[i][j] ? 1 : 0);
			}
			System.out.println();
		}
		System.out.println(sb);
	}

	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		
		while(!q.isEmpty()) {
			int qSize = q.size();
			
			for(int i = 0; i < qSize; i++) {
				int poll = q.poll();
				
				for(int j = 1; j <= n; j++) {
					if(!map[poll][j]) continue;
					if(v[j]) continue;
					map[poll][j] = map[start][j] = true;
					v[j] = true;
					q.add(j);
				}
			}
		}
	}
}
