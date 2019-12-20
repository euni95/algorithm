import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_2798_블랙잭_for {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] card = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) card[i] = Integer.parseInt(st.nextToken());
		
		int sum = 0;
		int max = 0;
		for(int i = 0; i < N - 2; i++) {
			for(int j = i + 1; j < N - 1; j++) {
				for(int k = j + 1; k < N; k++) {
					sum = card[i] + card[j] + card[k];
					if(sum <= M && max < sum) max = sum;
				}
			}
		}
		System.out.println(max);
	}

}
