import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_17392_우울한방학 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 약속 개수
		int M = Integer.parseInt(st.nextToken()); // 방학 일수

		st = new StringTokenizer(br.readLine());
		int gloomyDay = 0;
		for (int i = 0; i < N; i++) {
			gloomyDay += Integer.parseInt(st.nextToken());
		}

		gloomyDay = M - N - gloomyDay;

		if (gloomyDay <= 0) {
			System.out.println(0);
			return;
		}

		int length = gloomyDay / (N + 1);
		int rest = gloomyDay % (N + 1);

		int sum = 0;
		sum += ((length * (length + 1) * (length * 2 + 1)) / 6) * (N + 1 - rest);
		
		length += 1;
		sum += ((length * (length + 1) * (length * 2 + 1)) / 6) * rest;
		
		System.out.println(sum);
	}

}
