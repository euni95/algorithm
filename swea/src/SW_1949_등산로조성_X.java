//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class SW_1949_등산로조성_X {
//	static int N, K;
//	static int[][] map;
//	static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };
//
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//
//		int T = Integer.parseInt(br.readLine());
//		for (int t = 1; t <= T; t++) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			N = Integer.parseInt(st.nextToken());
//			K = Integer.parseInt(st.nextToken());
//
//			map = new int[N][N];
//
//			int max = 0;
//			for (int i = 0; i < N; i++) {
//				st = new StringTokenizer(br.readLine());
//				for (int j = 0; j < N; j++) {
//					int temp = Integer.parseInt(st.nextToken());
//					map[i][j] = temp;
//					max = Math.max(max, temp);
//				}
//			}
//
//			int result = 0;
//
//			int cnt = 0;
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					if (map[i][j] == max) { // 등산로는 가장 높은 봉우리에서 시작
//						result = Math.max(result, go(i, j, cnt));
//						cnt++;
//					}
//				}
//			}
//			sb.append("#").append(t).append(" ").append(result).append("\n");
//		}
//		System.out.println(sb);
//	}
//
//	private static int go(int x, int y, int top) {
//		Queue<Point> q = new LinkedList<>();
//		q.add(new Point(x, y, -1, -1, -1, true));
//		
////		Queue<String> test = new LinkedList<>();
////		test.add(Integer.toString(map[x][y]) + " ");
////		System.out.println(x + " " + y);
//		int cnt = 0;
//
//		while (!q.isEmpty()) {
//			int qSize = q.size();
//
//			for (int i = 0; i < qSize; i++) {
//				Point temp = q.poll();
////				String t = test.poll();
//
//				for (int j = 0; j < 4; j++) {
//					int tx = temp.x + dx[j];
//					int ty = temp.y + dy[j];
//
//					if (tx < 0 || ty < 0 || tx >= N || ty >= N) continue;
//					
//					int tempCost = map[temp.x][temp.y];
//					// 깎을 수 있을 때 _ 이전의 깎은 값을 상관 할 필요가 없음
//					if(temp.check) {
//						if(map[tx][ty] < tempCost) {
//							q.add(new Point(tx, ty, -1, -1, -1, true));
////							test.add(t + map[tx][ty] + " ");
//						}
//						else if(map[tx][ty] - K < tempCost) {
//							q.add(new Point(tx, ty, tx, ty, tempCost - 1, false));
////							test.add(t + map[tx][ty] + "(" + tempCost + ") ");
//						}
//					}
//					
//					// 못깎을 때
//					else {
//						if(temp.x == temp.cx && temp.y == temp.cy) {
//							tempCost = temp.before;
//						}
//						
//						int nowCost = map[tx][ty];
//						if(tx == temp.cx && ty == temp.cy) {
//							nowCost = temp.before;
//						}
//						
//						if(nowCost >= tempCost) continue;
//						q.add(new Point(tx, ty, temp.cx, temp.cy, temp.before, false));
////						test.add(t + map[tx][ty] + "(" + tempCost + ") ");
//					}
//				}
//			}
//			cnt++;
//		}
//		System.out.println("///////////////////////");
//		return cnt;
//	}
//
//	static class Point {
//		int x, y, cx, cy, before;
//		boolean check; // true : 깎을수있음
//
//		public Point(int x, int y, int cx, int cy, int before, boolean check) {
//			this.x = x;
//			this.y = y;
//			this.cx = cx;
//			this.cy = cy;
//			this.before = before;
//			this.check = check;
//		}
//
//	}
//}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_1949_등산로조성_X {
	static int testcase, n, k, map[][], high, max;
	static boolean visited[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		testcase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for (int tc = 1; tc <= testcase; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());

			map = new int[n][n];
			visited = new boolean[n][n];
			high = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					high = Math.max(high, map[i][j]);
				}
			}
			max = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == high) {
						visited[i][j] = true;
						dfs(i, j, false, 1);
						visited[i][j] = false;
					}
				}
			}

			sb.append("#").append(tc).append(" ").append(max).append("\n");
		}
		System.out.println(sb.toString());
	}

	static int[] dy = { -1, 0, 1, 0 }, dx = { 0, 1, 0, -1 };

	private static void dfs(int y, int x, boolean used, int depth) {
		int ny, nx;
		if (depth > max) max = depth;

		for (int d = 0; d < 4; d++) {
			ny = y + dy[d];
			nx = x + dx[d];
			if (ny < 0 || nx < 0 || ny >= n || nx >= n || visited[ny][nx]) continue;
			visited[ny][nx] = true;
			if (map[ny][nx] < map[y][x]) {
				dfs(ny, nx, used, depth + 1);
			} else if (!used && (map[ny][nx] - k < map[y][x])) {
				// 산깎기를 사용하지 않은 경우
//            for(int i=1; i<=k; i++) {
//               if(map[ny][nx]-i < map[y][x]) {
				int temp = map[ny][nx];
				map[ny][nx] = map[y][x] - 1;
				dfs(ny, nx, true, depth + 1);
				map[ny][nx] = temp;
//                  break;
//               }
//            }
			}
			visited[ny][nx] = false;
		}
	}
}