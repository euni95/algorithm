import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_5607_조합 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long N = Integer.parseInt(st.nextToken());
			long R = Integer.parseInt(st.nextToken());
			
			long up = 1;
			long down = 1;
			long mod = 1234567891;
			long tempR = R;
			for(int i = 0; i < R; i++) {
				up = (up * N) % mod;
				down = (down * tempR) % mod;
				System.out.println(up + " " + down);
				System.out.println(N + " " + tempR);
				N--; tempR--;
			}
			System.out.println("#" + t +  " "  + Math.round(up/down));
		}
	}

}
