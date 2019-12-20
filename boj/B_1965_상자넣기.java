import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1965_상자넣기 {
	static int[] bs;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		bs = new int[n];
		int idx = 0;
		for(int i = 0; i < n; i++) {
			int b = Integer.parseInt(st.nextToken());
			if(i == 0) {
				bs[0] = b;
				continue;
			}
			if(bs[idx] < b) {
				bs[++idx] = b;
			} else {
				int t = lower_bound(idx, b);
				bs[t] = b;
			}
		}
		System.out.println(idx + 1);
	}

	private static int lower_bound(int end, int b) {
		int start = 0;
		while(start < end) {
			int mid = (start + end) / 2;
			
			if(bs[mid] >= b) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		return end;
	}

}
