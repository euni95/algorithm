import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_14891_톱니바퀴2 {
	static int[][] wheels;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		
		wheels = new int[size][8];
		for(int i = 0; i < size; i++) {
			String input = br.readLine();
			for(int j = 0; j < 8; j++) {
				wheels[i][j] = input.charAt(j) - '0';
			}
		}
		int[] idx = new int[size];
		// 시계 방향이면 -> (idx + 7) % 8 , 반시계 방향이면 (idx + 1) % 8
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int wh = Integer.parseInt(st.nextToken()) - 1;
			int dir = Integer.parseInt(st.nextToken()); // 1 : 시계, -1 : 반시계
			// 바꾸깅
			int[] ch = new int[size];
			Arrays.fill(ch, -1);
			
			if(dir == 1) ch[wh] = (idx[wh] + 7) % 8;
			else ch[wh] = (idx[wh] + 1) % 8;
			
			int temp_dir = dir * -1;
			// 왼쪽으루
			for(int j = wh - 1; j >= 0; j--) {
				if(wheels[j][(idx[j] + 2) % 8] == wheels[j + 1][(idx[j + 1] + 6) % 8]) break;
				if(temp_dir == 1) ch[j] = (idx[j] + 7) % 8;
				else ch[j] = (idx[j] + 1) % 8;
				temp_dir *= -1;
			}
			temp_dir = dir * -1;
			// 오른쪽으루
			for(int j = wh + 1; j < size; j++) {
				if(wheels[j][(idx[j] + 6) % 8] == wheels[j - 1][(idx[j - 1] + 2) % 8]) break;
				if(temp_dir == 1) ch[j] = (idx[j] + 7) % 8;
				else ch[j] = (idx[j] + 1) % 8;
				temp_dir *= -1;
			}
			//갱신
			for(int j = 0; j < size; j++) {
				if(ch[j] != -1) idx[j] = ch[j]; 
			}
		}
		int score = 0;
		for(int i = 0; i < size; i++) {
			int t = wheels[i][idx[i]];
			if(t == 1) score++;
		}
		System.out.println(score);
	}

}
