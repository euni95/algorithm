import java.util.Arrays;

public class P_60062_외벽점검 {
	public static void main(String[] args) throws Exception {
		Solution solution = new Solution();

//		int n = 12;
//		int[] weak = {1, 3, 4, 9, 10};
//		int[] dist = {3, 5, 7};
//		int[] weak = {10, 0};
//		int[] dist = {1, 1};
//		int[] weak = {1, 5, 6, 10};
//		int[] dist = {1, 2, 3, 4};

//		int n = 100;
//		int[] weak = {0, 100};
//		int[] dist = {2, 1};
//		
		int n = 200;
		int[] weak = { 0, 10, 50, 80, 120, 160 };
		int[] dist = { 1, 10, 5, 40, 30 };
//		
		System.out.println(solution.solution(n, weak, dist));
	}

	static class Solution {
		int weakLen, min, n;
		int[] dist, weak;

		public int solution(int n, int[] weak, int[] dist) {
			min = Integer.MAX_VALUE;

			this.weakLen = weak.length;
			this.weak = weak;
			this.dist = dist;
			this.n = n;

			int[] p = new int[dist.length];
			boolean[] v = new boolean[dist.length];
			perm(p, v, 0);

			return min == Integer.MAX_VALUE ? -1 : min;
		}

		public void perm(int[] p, boolean[] v, int idx) {
			if (idx == dist.length) {
				for(int i = 0; i < weakLen; i++) {
					cleaning(i, p);
				}
				return;
			}
			for (int i = 0; i < dist.length; i++) {
				if (v[i]) continue;
				p[idx] = dist[i];
				v[i] = true;
				perm(p, v, idx + 1);
				v[i] = false;
			}
		}

		public void cleaning(int realStart, int[] p) {
			int start = realStart;
			int end = start;
			int temp = 0;
			int idx = 0;
			
			while (true) {
				if(min <= idx + 1) break;
				
				if (start < end) temp = weak[end] - weak[start];
				else if (start > end) temp = n - weak[start] + weak[end];
				else temp = 0;

				if (temp > p[idx]) {
					idx++;
					start = end;
					if (idx == dist.length) break;
				} else end = (end + 1) % weakLen;
				
				if(end == realStart) {
					min = Math.min(min, idx + 1);
					break;
				}
			}

		}
	}
}
