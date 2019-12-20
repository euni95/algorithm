import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_8500_극장좌석 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int result = N;
			int max = 0;
			for(int n = 0; n < N; n++) {
				int i = Integer.parseInt(st.nextToken());
				result += i;
				if(max < i) max = i;
			}
			System.out.println("#" + t + " " + (result + max));
		}
	}

}
