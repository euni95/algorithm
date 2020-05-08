import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_17838_커맨드 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			String cmd = br.readLine();

			if (cmd.length() != 7) System.out.println(0);
			else {
				char ch1 = cmd.charAt(0);
				char ch2 = cmd.charAt(2);

				if (ch1 == ch2 || cmd.charAt(1) != ch1 || cmd.charAt(3) != ch2 || cmd.charAt(4) != ch1
						|| cmd.charAt(5) != ch2 || cmd.charAt(6) != ch2) {
					System.out.println(0);
				} else
					System.out.println(1);
			}
		}
	}
}
