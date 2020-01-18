import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_16937_두스티커 {
	static int H, W, N;
	static ArrayList<Point> list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(br.readLine());

		if (H > W) {
			int temp = H;
			H = W;
			W = temp;
		}
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			if (x > y) {
				int temp = x;
				x = y;
				y = temp;
			}
			if (H < x || W < y) continue;
			list.add(new Point(x, y));
		}
		int result = 0;
		int max = 0;
		if (list.size() >= 2) {
			for (int i = 0; i < list.size() - 1; i++) {
				for (int j = i + 1; j < list.size(); j++) {
					int ix = list.get(i).x, iy = list.get(i).y;
					int jx = list.get(j).x, jy = list.get(j).y;
					result = ix * iy + jx * jy;	
					if(H * W < result) continue;
				    boolean check = false;
					if ((ix + jx) <= W && iy <= H && jy <= H) check = true;
					else if ((ix + jy) <= W && iy <= H && jx <= H) check = true;
					else if ((iy + jx) <= W && ix <= H && jy <= H) check = true;
					else if ((ix + jx) <= H) check = true;
					else if (ix <= H && jx <= H && (iy + jy) <= W) check = true;
			
					if (check) {
						if (result > max) max = result;
					}
				}
			}
		}
		System.out.println(max);
	}
}

