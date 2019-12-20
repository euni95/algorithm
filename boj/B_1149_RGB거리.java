import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1149_RGB거리 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] house = new int[N];
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int G = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			int tempR = R + Math.min(house[1], house[2]);
			int tempG = G + Math.min(house[0], house[2]);
			int tempB = B + Math.min(house[0], house[1]);
			
			house[0] = tempR;
			house[1] = tempG;
			house[2] = tempB;
		}
		min = Math.min(house[0], Math.min(house[1], house[2]));
		System.out.println(min);
	}

}
