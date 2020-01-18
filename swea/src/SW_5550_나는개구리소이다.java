import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW_5550_나는개구리소이다 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			char[] sound = br.readLine().toCharArray();

			int[] croak = new int[5];
			int cnt = 0;
			int wait = 0;
			boolean check = true;

			for (int i = 0; i < sound.length; i++) {
				char temp = sound[i];
				check = true;
				switch (temp) {
				case 'c':
					if (wait == 0)
						cnt++;
					else
						wait--;
					croak[0]++;
					break;
				case 'r':
					if (croak[0] > croak[1])
						croak[1]++;
					else
						check = false;
					break;
				case 'o':
					if (croak[1] > croak[2])
						croak[2]++;
					else
						check = false;
					break;
				case 'a':
					if (croak[2] > croak[3])
						croak[3]++;
					else
						check = false;
					break;
				case 'k':
					if (croak[3] > croak[4]) {
						croak[4]++;
						wait++;
					} else
						check = false;
					break;
				}
				if (!check)
					break;
				check = true;
			}

			int temp = sound.length / 5;
			for (int i = 0; i < 5; i++) {
				if (croak[i] != temp) {
					check = false;
					break;
				}
			}

//			System.out.println(Arrays.toString(croak));
			System.out.print("#" + t + " " );
			if (check)
				System.out.println(cnt);
			else
				System.out.println(-1);
		}
	}

}
