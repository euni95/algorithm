import java.util.TreeSet;

public class P_42861_섬연결하기 {
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
		int[] parent;
//		ArrayList<Node> nodes = new ArrayList<>();
		TreeSet<Node> nodes = new TreeSet<>();

		public int solution(int n, int[][] costs) {
			int answer = 0;
			
			parent = new int[n];
			for(int i = 0; i < n; i++) parent[i] = i;
			for(int i = 0; i < costs.length; i++) nodes.add(new Node(costs[i][0], costs[i][1], costs[i][2]));
			
			int cnt = 0;
			for(Node node : nodes) {
				if(cnt == n - 1) break;
				
				int start = findSet(node.start);
				int end = findSet(node.end);
				
				if(start == end) continue;
				unionSet(node.start, node.end);
				answer += node.cost;
				cnt++;
			}
			return answer;
		}

		public void unionSet(int a, int b) {
			a = findSet(a);
			b = findSet(b);
			
			if(a != b) {
				parent[b] = a;
			}
		}
		
		public int findSet(int a) {
			if(parent[a] == a) return a;
			else return parent[a] = findSet(parent[a]);
		}
	}
	
	static class Node implements Comparable<Node> {
		int start, end, cost;

		public Node(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost < o.cost ? -1 : 1;
		}

		@Override
		public String toString() {
			return "Node [start=" + start + ", end=" + end + ", cost=" + cost + "]";
		}
		
	}
}
