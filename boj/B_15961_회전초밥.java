import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_15961_회전초밥 {
	static int N, d, k, c;
	static int[] food;
	static int[] count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		count = new int[d + 1]; // 갯수 확인
		food = new int[N + 1]; // 접시
		
		int num = 0;
		for(int i = 0; i < N; i++) {
			food[i] = Integer.parseInt(br.readLine());
			if(i < k) {
				count[food[i]]++;
				if(count[food[i]] == 1) num++;
			}
		}
		if(count[c] == 0) num++;
		count[c]++;
		
		int max = num;
		for(int i = 1; i < N; i++) {
			count[food[i - 1]]--;
			if(count[food[i - 1]] == 0) num--;
			
			count[food[(i + k - 1) % N]]++;
			if(count[food[(i + k - 1) % N]] == 1) num++;
			
			max = Math.max(max, num);
		}
		System.out.println(max);
	}
}
