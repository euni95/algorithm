import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_11399_ATM {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] atm = new int[N];
		for (int i = 0; i < N; i++) atm[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(atm);

		int sum = 0;
		int result = 0;
		for(int i = 0; i < N; i++) {
			sum += atm[i];
			result += sum;
		}
		System.out.println(result);
	}

}
