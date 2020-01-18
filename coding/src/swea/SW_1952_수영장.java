import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_1952_수영장 {
	static int day, month, months, year;
	static int[] plan;
	static int min;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		plan = new int[12];
		
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			day = Integer.parseInt(st.nextToken());
			month = Integer.parseInt(st.nextToken());
			months = Integer.parseInt(st.nextToken());
			year = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}
			min = year; // 1년 이용권을 사용하는 경우
		
			swim(0, 0);
			System.out.println("#" + t + " " + min);
		}
	}
	
	static void swim(int idx, int cost) {
		if(cost >= min) return;
		if(idx >= 12) {
			min = Math.min(cost, min);
			return;
		}

		// 하루
		swim(idx + 1, cost + (plan[idx] * day));
		
		// 한달
		swim(idx + 1, cost + (plan[idx] != 0 ? month : 0));
		
		// 세달
		boolean check = false;
		for(int i = 0; i < 3; i++) {
			if(idx + i >= 12) break;
			if(plan[(idx+i)] != 0) {
				check = true;
				break;
			}
		}
		swim(idx + 3, cost + (check ? months : 0));
	}
}
