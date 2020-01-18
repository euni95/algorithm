import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_17471_게리맨더링 {
	static int N;
	static int[] pop;
	static ArrayList<Integer>[] con;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		pop = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i < N + 1; i++) pop[i] = Integer.parseInt(st.nextToken());
		con = new ArrayList[N + 1];
		
		for(int i = 0; i < N + 1; i++) {
			con[i] = new ArrayList<>();
			if(i == 0) continue;
			st = new StringTokenizer(br.readLine());
			int temp = Integer.parseInt(st.nextToken());
			for(int j = 0; j < temp; j++) {
				con[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		int size = (1 << N) - 1;
		int min = Integer.MAX_VALUE;
		ArrayList<Integer> a = new ArrayList<>();
		ArrayList<Integer> b = new ArrayList<>();
		for(int i = 1; i < size / 2 + 1; i++) {
			a.clear(); b.clear();
			for(int j = 0; j < N; j++) {
				if((i & (1 << j)) == 0) {
					a.add(j+1);
				} else {
					b.add(j+1);
				}
			}
			boolean[] visited = new boolean[N + 1];
			int re_a = check(a, visited);
			int re_b = check(b, visited);
			
			if(re_a != -1 && re_b != -1) {
				min = Math.min(min, Math.abs(re_a - re_b));
			}
		}
		System.out.println(min != Integer.MAX_VALUE ? min : -1);
	}
	
	private static int check(ArrayList<Integer> a, boolean[] visited) {
		Queue<Integer> q = new LinkedList<>();
		q.add(a.get(0));
		visited[a.get(0)] = true;
		int cnt = 1;
		int total = pop[a.get(0)];
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			
			for(int i = 0; i < a.size(); i++) {
				if(!visited[a.get(i)] && con[temp].contains(a.get(i))) {
					visited[a.get(i)] = true;
					cnt++;
					q.add(a.get(i));
					total += pop[a.get(i)];
				}
			}
		}
		if(cnt == a.size()) {
			return total;
		}
		return -1;
	}

}
