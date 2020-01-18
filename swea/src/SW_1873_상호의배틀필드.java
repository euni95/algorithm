import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW_1873_상호의배틀필드 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			String[] lines = br.readLine().split(" ");
			int H = Integer.parseInt(lines[0]);
			int W = Integer.parseInt(lines[1]);

			char[][] map = new char[H][W];
			int tankX = 0, tankY = 0, tankD = 0;

			for (int i = 0; i < H; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j = 0; j < W; j++) {
					char temp = map[i][j];
					if (temp == '^' || temp == 'v' || temp == '<' || temp == '>') {
						tankX = i; tankY = j;
						if (temp == '^') tankD = 0;
						else if (temp == 'v') tankD = 1;
						else if (temp == '<') tankD = 2;
						else if (temp == '>') tankD = 3;
					}
				}
			}
			
			int N = Integer.parseInt(br.readLine());
			int[] input = new int[N];
			char[] line = br.readLine().toCharArray();
			for (int i = 0; i < N; i++) {
				char temp = line[i];
				if (temp == 'U') input[i] = 0;
				else if (temp == 'D') input[i] = 1;
				else if (temp == 'L') input[i] = 2;
				else if (temp == 'R') input[i] = 3;
				else input[i] = 4;
			}
			int[] dx = { -1, 1, 0, 0 };
			int[] dy = { 0, 0, -1, 1 };
			for (int i = 0; i < N; i++) {
				int temp = input[i];
				
				if(temp == 4) {
					int tx = tankX, ty = tankY;
					while(true) {
						tx += dx[tankD];
						ty += dy[tankD];
						
						if(tx < 0 || ty < 0 || tx >= H || ty >= W) break;
						if(map[tx][ty] == '#') break;
						if(map[tx][ty] == '*') {
							map[tx][ty] = '.';
							break;
						}
					}
				} else {
					int tx = tankX + dx[temp];
					int ty = tankY + dy[temp];
					
					if(tx < 0 || ty < 0 || tx >= H || ty >= W || map[tx][ty] != '.') {
						char tempD = ' ';
						if(temp == 0) tempD = '^';
						else if(temp == 1) tempD = 'v';
						else if(temp == 2) tempD = '<';
						else if(temp == 3) tempD = '>';

						tankD = temp;
						map[tankX][tankY] = tempD;
						continue;
					}
					if(map[tx][ty] == '.') {
						char tempD = ' ';
						if(temp == 0) tempD = '^';
						else if(temp == 1) tempD = 'v';
						else if(temp == 2) tempD = '<';
						else if(temp == 3) tempD = '>';
						

						map[tankX][tankY] = '.';
						map[tx][ty] = tempD;
						
						tankX = tx;
						tankY = ty;
						tankD = temp;
					}
				}
			}
			
			System.out.print("#" + t + " ");
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				} System.out.println();
			}
		}
	}

}
