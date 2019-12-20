import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_15686_치킨배달 {
	static int N, M;
	static int[][] city;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		city = new int[N][N];
		
		ArrayList<Point> ck = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
				if(city[i][j] == 2) ck.add(new Point(i, j));
			}
		}
		int min = Integer.MAX_VALUE;
		boolean[] ckv = new boolean[ck.size()];
		int ckNum = 1 << ck.size();
		for(int i = 0; i < ckNum; i++) {
			ckv = new boolean[ck.size()];
			int cnt = 0;
			for(int j = 0; j < ck.size(); j++) {
				if((i & (1 << j)) == 0) {
					ckv[j] = true;
					cnt++;
				}
			}
			int sum = 0;
			if(cnt == M) {
				for(int j = 0; j < N; j++) {
					for(int k = 0; k < N; k++) {
						if(city[j][k] == 1) {
							int temp = Integer.MAX_VALUE;
							for(int l = 0; l < ck.size(); l++) {
								if(!ckv[l]) continue;
								int dist = Math.abs(ck.get(l).x - j) + Math.abs(ck.get(l).y - k);
								if(dist < temp) temp = dist;
							}
							sum += temp;
						}
					}
				}
				if(min > sum) min = sum;
			}
		}
		System.out.println(min);
	}
	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
