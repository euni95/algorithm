import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW_5672_올해의조련사 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine().trim());
		for(int t = 1; t <= T; t++) {
			StringBuilder re_sb = new StringBuilder();
			int N = Integer.parseInt(br.readLine().trim());
			char[] ani = new char[N];
			for(int i = 0; i < N; i++) ani[i] = br.readLine().trim().charAt(0);
			
			int s_idx = 0, e_idx = N-1;
			while(s_idx <= e_idx) {
				if(s_idx == e_idx) {
					re_sb.append(ani[s_idx]);
					break;
				}
				char s = ani[s_idx];
				char e = ani[e_idx];
				if(s < e) {
					re_sb.append(s);
					s_idx++;
				} else if(s > e) {
					re_sb.append(e);
					e_idx--;
				} else {
					int s_tIdx = s_idx + 1, e_tIdx = e_idx - 1;
					
					boolean check = false;
					while(s_tIdx <= e_tIdx) {
						char s_temp = ani[s_tIdx];
						char e_temp = ani[e_tIdx];

						if(s_temp < e_temp) {
							check = false;
							break;
						} else if(s_temp > e_temp) {
							check = true;
							break;
						} else {
							s_tIdx++;
							e_tIdx--;
						}
					}
					if(check) {
						re_sb.append(ani[e_idx--]);
					} else {
						re_sb.append(ani[s_idx++]);
					}
				}
			}
			
			sb.append("#").append(t).append(" ").append(re_sb.toString()).append("\n");
		}
		System.out.println(sb.toString());
	}

}
