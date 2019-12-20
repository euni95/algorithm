import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class J_2634_사냥꾼 {
	static int M, N, L;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		int[] shot = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) 
			shot[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(shot);

		Point[] animal = new Point[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			animal[i] = new Point(a, b);
		}
		Arrays.sort(animal, new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				return o1.x > o2.x ? 1 : -1;
			}
		});
		
		int temp = 0;
 		int cnt = 0;
		int tx, ty;
		for(int i = 0; i < N; i++) {
			tx = animal[i].x;
			ty = animal[i].y;
			
			while(temp < M && shot[temp] < tx) temp++;

			boolean flag = false;
			if(temp > 0 && Math.abs(shot[temp - 1] - tx) + ty <= L) flag = true;
			if(temp < M && Math.abs(shot[temp] - tx) + ty <= L) flag = true;
			if(flag) cnt++;
		}
		System.out.println(cnt);
	}

}
