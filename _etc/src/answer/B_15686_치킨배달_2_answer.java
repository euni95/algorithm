package answer;
import java.util.ArrayList;
import java.util.Scanner;

// 백준 15686 치킨배달 2
// 좌표값과 거리값만 저장해 놓고 처리하기

public class B_15686_치킨배달_2_answer {

	static int[][] map;
	static int N; // 배열 사이즈
	static int M; // 치킨집 갯수
	static ArrayList<Loc> houses;
	static ArrayList<Loc> chikens;
	static int[] selections;
	static int result = Integer.MAX_VALUE;
	
	static int[][] dist; 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		dist = new int[14][101];
		N = sc.nextInt();
		M = sc.nextInt();
		map  = new int[N][N];
		houses = new ArrayList<Loc>();
		chikens = new ArrayList<Loc>();
		for(int i = 0 ; i < N; i++) {
			for(int j = 0 ; j < N; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 1) {  // 집이면 집리스트에 추가
					houses.add(new Loc(i,j));
				}else if(map[i][j] == 2) {
					chikens.add(new Loc(i,j));  // 치킨집 목록에 추가
				}
			}
		}
		selections = new int[14];
		// 집과 치킨집 사이의 거리를 미리 구해놓고 저장함
		for(int i = 0 ; i <chikens.size(); i++) {
			for(int j = 0 ; j < houses.size(); j++) {
				dist[i][j] = calc(chikens.get(i), houses.get(j));
			}
		}
		dfs(0,0);
		
		System.out.println(result);
		
	}
//	치킨가게와 집 사이의 거리 구하는 메소드
	static int calc(Loc x1, Loc x2) {
		return Math.abs(x1.x-x2.x) + Math.abs(x1.y - x2.y);
	}
	static int solve() {
		int res = 0;
		
//		모든 집에서 선택된 치킨의 집 갯수 만큼 가장 작은 값을 구하여 누적
		for(int i = 0 ;i < houses.size(); i++) {
			int cMin = Integer.MAX_VALUE;
			for(int j =0; j < M; j++) {
				cMin = Math.min(cMin, dist[selections[j]][i]);
			}
			res += cMin;
		}
		return res;
	}
	static void dfs(int start, int depth) {
		if(depth == M) {
			result = Math.min(result, solve());
		}
		// 모든 시작위치를 변경해서 검색
		for(int i = start ; i <chikens.size(); i++) {
			selections[depth] = i;
			dfs(i+1, depth+1);
			selections[depth] = 0;
		}
	}

	static class Loc{
		int x, y;

		public Loc(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}

}
