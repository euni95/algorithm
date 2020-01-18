import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class J_1828_냉장고 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		ArrayList<Point> ref = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int low = Integer.parseInt(st.nextToken());
			int high = Integer.parseInt(st.nextToken());
			ref.add(new Point(low, high));
		}
		
		Collections.sort(ref, new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				return o1.x - o2.x;
			}
		});
		
		int cnt = 1;
		int temp = ref.get(0).y;
		for (int i = 1; i < ref.size(); i++) {
			if (temp < ref.get(i).x) {
				cnt++;
				temp = ref.get(i).y;
			}
			if(temp > ref.get(i).y) temp = ref.get(i).y;
		}
		
		System.out.println(cnt);
	}
}
