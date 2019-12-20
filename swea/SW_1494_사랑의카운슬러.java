import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_1494_사랑의카운슬러 {
	static int N;
	static int[] arr;
	static Point[] worm;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			
			worm = new Point[N];
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				worm[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			min = Long.MAX_VALUE;
			check = new boolean[N];
			perm(0, 0);
			System.out.println("#" + t + " " + min);
		}
	}

	static boolean[] check;
	static long min;
	static void perm(int idx, int depth) {
		if (depth == N/2) {
			if(!check[0]) return;
			long startX = 0, startY = 0;
			long endX = 0, endY = 0;
			
			for (int i = 0; i < N; i++) {
				if (check[i]) {
					startX += worm[i].x;
					startY += worm[i].y;
				}
				else {
					endX += worm[i].x;
					endY += worm[i].y;
				}
			}
			long result = (long) (Math.pow((startX - endX), 2) + Math.pow((startY - endY), 2));
			if(min > result) min = result;
			return;
		}

		for (int i = idx; i < N; i++) {
			check[i] = true;
			perm(i + 1, depth + 1);
			check[i] = false;
		}
	}
}
