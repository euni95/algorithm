import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_16434_드래곤앤던전 {
	static int N;
	static long maxHP, curHP, atk;
	static int[][] room;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		atk = Integer.parseInt(st.nextToken());
		room = new int[N][3];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			room[i][0] = Integer.parseInt(st.nextToken()); // 1 : 몬스터, 2 : 포션
			room[i][1] = Integer.parseInt(st.nextToken()); // 공격력
			room[i][2] = Integer.parseInt(st.nextToken()); // 생명력
		}
		
		for(int i = 0; i < N; i++) {
			if(room[i][0] == 1) {
				if(room[i][2] % atk == 0) {
					curHP += room[i][1] * (room[i][2] / atk - 1);
				} else {
					curHP += room[i][1] * (room[i][2] / atk);
				}
			} else {
				atk += room[i][1];
				curHP -= room[i][2];
				if(curHP < 0) curHP = 0;
			}
			maxHP = Math.max(curHP, maxHP);
		}
		System.out.println(maxHP + 1);
	}
}
