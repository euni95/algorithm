import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class SW_7206_숫자게임 {
	static HashMap<Integer, Integer> map = new HashMap<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int number = Integer.parseInt(br.readLine());
			map.clear();
			System.out.println("#" + t + " " + calc(number));
		}
	}

	private static int calc(int num) {
		if(num < 10) return 0;
		if(map.containsKey(num)) {
			return map.get(num);
		}
		String str = String.valueOf(num);
		int len = str.length(), cnt = 0;
		for (int i = 1; i < (1 << len); i++) {
			int mul = 1, temp = 0;
			for (int j = 0; j < len; j++) {
				if ((i & 1 << j) == 0) {
					temp = temp * 10 + (str.charAt(j) - '0');
				} else {
					mul *= temp;
					temp = str.charAt(j) - '0';
				}
			}
			mul *= temp;
			temp = calc(mul);
			cnt = Math.max(cnt, temp);
		}
		map.put(num, ++cnt);
		return cnt;
	}

}