import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//백준 16937 두 스티커
public class B_16937_두스티커_answer {
	static int R, C, N;
	//스티커 크기를 저장할 클래스 선언
	static class Pos {
		int r;
		int c;
		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int result;
	//스티커 크기를 담을 리스트
	static List<Pos> list = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		R = sc.nextInt();
		C = sc.nextInt();
		N = sc.nextInt();
		result = 0;
		for (int i = 0; i < N; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();

			list.add(new Pos(r, c));
		}

		//두스티커 이므로 스티커가 2개이상일때만 조합뽑기
		if (list.size() > 1) {
			combi(new Pos[2], list.size(), 2);
		}
		System.out.println(result);
		sc.close();
	}

	static void sticker(Pos[] sel) {
		//각각의 스티커
		Pos first = sel[0];
		Pos second = sel[1];

		//계속 할지 말지 체크
		boolean flag = true;
		//맵을 그리기 위해서 선언
		boolean[][] map = new boolean[R][C];

		//첫번째 스티커는 0,0 에서 출발
		outer:for (int i = 0; i < first.r; i++) {
			for (int j = 0; j < first.c; j++) {
				//map밖으로 나가면 안된다.
				if (i < R && j < C) {
					map[i][j] = true;
				} else {
					//나가면  flag를 false로 변경
					flag = false;
					break outer;
				}
			}
		}
		//첫번째 스티커가 잘 붙었을때만 다음 스티커 붙여보기
		if (flag) {
			outer :for (int i = R - 1; i >= R - second.r; i--) {
				for (int j = C - 1; j >= C - second.c; j--) {
					//당연히 0,0, 안에 들어와야되고 스티커가 붙지 않은 자리이어야함.
					if (i >= 0 && j >= 0 && !map[i][j]) {
						map[i][j] = true;
					} else {
						//아니면  붙일 수 없음
						flag = false;
						break outer;
					}
				}
			}
		}
		//만약 두스티커를 붙였는데도 이상이 없다면.
		if (flag) {
			//두스티커 사이즈 구하고 지금까지 구한 답과 비교후 설정.
			int size = (first.r * first.c) + (second.r * second.c);
			result = Math.max(result, size);
		}
	}

	//들어오는 스티커 크기를 90도회전
	static void change(Pos pos) {
		int tmp = pos.r;
		pos.r = pos.c;
		pos.c = tmp;
	}

	//두스티커 조합 뽑기
	static void combi(Pos[] sel, int n, int r) {
		if (r == 0) {
			//가로 가로 모드
			sticker(sel);
			//세로 가로 모드
			change(sel[0]);
			sticker(sel);
			//세로 세로 모드
			change(sel[1]);
			sticker(sel);
			//가로 세로 모드
			change(sel[0]);
			sticker(sel);
			return;
		}
		if (n < r) {
			return;
		}

		sel[r-1] = list.get(n-1);
		combi(sel, n-1, r-1);
		combi(sel, n-1, r);
	}
}
