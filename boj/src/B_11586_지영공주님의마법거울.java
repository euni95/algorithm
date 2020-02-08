import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_11586_지영공주님의마법거울 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		char[][] jy = new char[N][N];
		for(int i = 0; i < N; i++) jy[i] = br.readLine().toCharArray();
		int state = Integer.parseInt(br.readLine());
		if(state == 1) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					sb.append(jy[i][j]);
				} sb.append("\n");
			}
		} else if(state == 2) {
			for(int i = 0; i < N; i++) {
				for(int j = N - 1; j >= 0; j--) {
					sb.append(jy[i][j]);
				} sb.append("\n");
			}
		} else {
			for(int i = N - 1; i >= 0; i--) {
				for(int j = 0; j < N; j++) {
					sb.append(jy[i][j]);
				} sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}
