import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_3985_롤케이크 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		int expect = 0, maxE = 0;
		int real = -1, maxR = 0;
		int[] roll = new int[L + 1];
		for(int i = 1; i < N + 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			if((K-P) > maxE) {
				maxE = K-P;
				expect = i;
			}
			int temp = 0;
			for(int j = P; j < K + 1; j++) {
				if(roll[j] != 0) continue;
				roll[j] = i;
				temp++;
			}
			if(temp > maxR) {
				maxR = temp;
				real = i;
			}
		}
		
		System.out.println(expect);
		System.out.println(real);
	}

}
