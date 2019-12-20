import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW_1240_단순2진암호코드 { // [S/W 문제해결 응용] 1일차 - 단순 2진 암호코드
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			String[] line = br.readLine().split(" ");
			int N = Integer.parseInt(line[0]);
			int M = Integer.parseInt(line[1]);

			int[] code = new int[56];
			char[][] codes = new char[N][M];
			for (int i = 0; i < N; i++) {
				codes[i] = br.readLine().toCharArray();
			}
			int idx = 0;
			a : for (int i = 0; i < N; i++) {
				for (int j = M - 1; j >= 0; j--) {
					if(codes[i][j] == '1') {
						for(int k = j-55; k <= j; k++) {
							code[idx++] = codes[i][k] - '0';
						} 
						break a;
					}
				}
			}
			String check;
			int sum1 = 0, sum2 = 0, verify = 0;
			for(int i = 0; i < 8; i++) {
				int cnt = 0; check = "";
				for(int j = 7 * i; j < (7*i) + 6; j++) {
					cnt++;
					if(code[j] != code[j+1]) {
						check += String.valueOf(cnt);
						cnt = 0;
					}
				}
				check += String.valueOf(cnt+1);
				int num = trans(check);

				if(i==7) verify = num;
				else if(i%2 == 0) sum1 += num;
				else if(i%2 == 1) sum2 += num;
			}
			int result = 0;
			if((sum1*3 + sum2 + verify) % 10 == 0) {
				result = sum1 + sum2 + verify;
			}
			System.out.println("#" + t + " " + result);
		}
	}

	private static int trans(String check) {
		int num = -1;
		switch(check) {
		case "3211":
			num = 0;
			break;
		case "2221":
			num = 1;
			break;
		case "2122":
			num = 2;
			break;
		case "1411":
			num = 3;
			break;
		case "1132":
			num = 4;
			break;
		case "1231":
			num = 5;
			break;
		case "1114":
			num = 6;
			break;
		case "1312":
			num = 7;
			break;
		case "1213":
			num = 8;
			break;
		case "3112":
			num = 9;
			break;
		}
		return num;
	}
}
