import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class B_4195_친구네트워크 {
	static int[] parent, f_cnt;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			Map<String, Integer> index = new HashMap<>();
			int F = Integer.parseInt(br.readLine());
			int cnt = 1;
			parent = new int[F*2 + 1];
			f_cnt = new int[F*2 + 1];
			for(int i = 0; i < F; i++) {
				String[] temp = br.readLine().split(" ");
				int a = 0, b = 0;
				for(int j = 0; j < 2; j++) {
					int num = -1;
					if(index.containsKey(temp[j])) {
						num = index.get(temp[j]);
						
					} else {
						index.put(temp[j], cnt);
						num = cnt++;
					}
					if(parent[num] == 0) {
						parent[num] = num;
						f_cnt[num] = 1;
					}
					if(j == 0) a = num;
					else b = num;
				}
				unionSet(a, b);
			}
		}
		System.out.println(sb);
	}

	private static void unionSet(int a, int b) {
		a = findSet(a);
		b = findSet(b);
		
		if(a != b) {
			parent[b] = a;
			f_cnt[a] += f_cnt[b];
		}
		sb.append(f_cnt[a]).append("\n");
	}

	private static int findSet(int a) {
		if(parent[a] == a) return a;
		else {
			int temp = findSet(parent[a]);
			parent[a] = temp;
			return parent[a];
		}
	}
}
