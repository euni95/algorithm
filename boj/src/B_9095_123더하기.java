import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_9095_123더하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		int[] arr = new int[12];
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;

		for (int i = 4; i < 12; i++) {
			arr[i] = arr[i-3] + arr[i-2] + arr[i-1];
		}
		
		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(arr[n]);
		}
	}

}
