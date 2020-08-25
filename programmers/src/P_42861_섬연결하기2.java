import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class P_42861_섬연결하기2 {
	public static void main(String[] args) throws Exception {
		Solution solution = new Solution();
		int n = 4;
		int[][] costs = {
				{0, 1, 1},
				{0, 2, 2},
				{1, 2, 5},
				{1, 3, 1},
				{2, 3, 8}
		};
		System.out.println(solution.solution(n, costs));
	}

	static class Solution {

		public int solution(int n, int[][] costs) {
			int answer = 0;
			
			ArrayList<Node>[] nodes = new ArrayList[n];
			for(int i = 0; i < n; i++) nodes[i] = new ArrayList<>();
			for(int i = 0; i < costs.length; i++) {
				int x = costs[i][0];
				int y = costs[i][1];
				int cost = costs[i][2];
				
				nodes[x].add(new Node(y, cost));
				nodes[y].add(new Node(x, cost));
			}
			
			PriorityQueue<Node> pq = new PriorityQueue<>();
			boolean[] v = new boolean[n];
			for(Node node : nodes[0]) pq.add(node);
			v[0] = true;
			
			int cnt = 0;
			while(!pq.isEmpty()) {
				if(cnt == n - 1) break;
				
				Node temp = pq.poll();
				
				if(v[temp.x]) continue;
				answer += temp.cost;
				v[temp.x] = true;
				for(Node node : nodes[temp.x]) pq.add(node);
				cnt++;
			}
			return answer;
		}
		
	}
	
	static class Node implements Comparable<Node> {
		int x, cost;

		public Node(int x, int cost) {
			this.x = x;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost < o.cost ? -1 : 1;
		}
		
	}
}
