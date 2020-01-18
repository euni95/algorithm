import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_2999_비밀이메일 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] letter = br.readLine().toCharArray();
		int N = letter.length;

		int r = 0, c = 0;
		for (int i = 1; i < N; i++) {
			if (N % i == 0) {
				int temp = N / i;
				if(temp >= i) {
					r = i;
					c = temp;
				}
				else break;
			}
		}
		for(int i = 0; i < r; i++) {
			int tempC = i;
			for(int j = 0; j < c; j++) {
				System.out.print(letter[tempC]);
				tempC += r;
			}
		}
	}
}
