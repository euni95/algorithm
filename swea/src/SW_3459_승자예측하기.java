import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW_3459_승자예측하기 {
	static long N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Long.parseLong(br.readLine());
			long num = 2;
			
			System.out.print("#" + t + " ");
			if (N == 1) {
				System.out.print("Bob");
			} else {
				while (true) {
					if (num * 2 > N) {
						if (N <= num + num / 2)
							System.out.print("Alice");
						else
							System.out.print("Bob");
						break;
					}
					num *= 2;
					if (num * 2 > N) {
						if (N <= num + num / 2)
							System.out.print("Bob");
						else
							System.out.print("Alice");
						break;
					}
					num *= 2;
				}
			}
			System.out.println();
		}
	}
}
