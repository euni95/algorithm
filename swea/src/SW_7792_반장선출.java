import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SW_7792_반장선출 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int max = 0;
			String result = "";
			for(int i = 0; i < N; i++) {
				int[] alpha = new int[26];
				char[] name = br.readLine().toCharArray();
				
				for(int j = 0; j < name.length; j++) {
					if(name[j] == ' ') continue;
					alpha[name[j] - 65]++;
				}
				int cnt = 0;
				for(int j = 0; j < 26; j++) if(alpha[j] != 0) cnt++;

				if(cnt == max && result.compareTo(String.valueOf(name)) >= 0) {
					max = cnt;
					result = String.valueOf(name);
				}
				else if(cnt > max) {
					max = cnt;
					result = String.valueOf(name);
				}
			}
			System.out.println("#" + t + " " + result);
		}
	}

}
