import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class SW_5658_보물상자비밀번호 {
	static int N, K;
	static ArrayList<Character> nums;
	static Set<String> set;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			set = new TreeSet<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			nums = new ArrayList<>();
			String line = br.readLine().trim();
			for(int i = 0; i < N; i++) nums.add(line.charAt(i));
			
			for(int i = 0; i < N; i++) {
				if(i == 0) {
					calc();
				} else {
					char temp = (char)nums.get(N-1);
					nums.add(0, temp);
					nums.remove(N);
					calc();
				}
			}
			Iterator<String> it = set.iterator();
			int cnt = 0;
			String result = "";
			while(it.hasNext()) {
				result = it.next();
				if(cnt == set.size()-K) break;
				cnt++;
			}
			System.out.println("#" + t + " " + Integer.parseInt(result,16));
		}
	}

	private static void calc() {
		for(int i = 0; i < N; i += N/4) {
			String temp = "";
			for(int j = 0; j < N/4; j++) {
				temp += nums.get(i+j);
			}
			set.add(temp);
		}
	}

}
