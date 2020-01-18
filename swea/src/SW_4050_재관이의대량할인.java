import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class SW_4050_재관이의대량할인 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			ArrayList<Integer> list = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int sum = 0;
			for(int i = 0; i < N; i++) {
				int temp = Integer.parseInt(st.nextToken());
				list.add(temp);
				sum += temp;				
			}
			Collections.sort(list, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o2 - o1;
				}
			});
			for(int i = 2; i < list.size(); i += 3) {
				sum -= list.get(i);
			}
			System.out.println("#" + t + " " + sum);
		}
	}
}
