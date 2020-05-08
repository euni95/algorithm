import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_17392_우울한방학_X {
	static int N, M, MIN;
	static int[] promise, day;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 약속 개수
		M = Integer.parseInt(st.nextToken()); // 방학 일수
		
		promise = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) promise[i] = Integer.parseInt(st.nextToken());
		
		
	}
}
