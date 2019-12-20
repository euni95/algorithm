import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_16235_나무재테크 {
	static int N, M, K;
	static int[][] A, land;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken()); // year

		A = new int[N + 1][N + 1]; // 각 칸에 추가되는 양분의 양
		land = new int[N + 1][N + 1]; // 가장 처음에 양분은 모든 칸에 5만큼 들어있음
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				land[i][j] = 5;
			}
		}

		LinkedList<Tree> tree = new LinkedList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());
			tree.add(new Tree(x, y, age));
		}

		Queue<Tree> death = new LinkedList<>();
		Tree t;
		for (int i = 0; i < K; i++) {
			// 봄
			Iterator<Tree> it = tree.iterator();
			while (it.hasNext()) {
				t = it.next();
				int nutri = land[t.x][t.y];
				if (nutri >= t.age) {
					land[t.x][t.y] -= t.age;
					t.setAge(t.age + 1);
				} else {
					death.add(t);
					it.remove();
				}
			}
			// 여름
			while (!death.isEmpty()) {
				t = death.poll();
				land[t.x][t.y] += t.age / 2;
			}

			// 가을
			int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
			int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };
			ArrayList<Tree> add = new ArrayList<>();

			it = tree.iterator();
			while(it.hasNext()) {
				t = it.next();
				if (t.age % 5 != 0)
					continue;

				for (int k = 0; k < 8; k++) {
					int tx = t.x + dx[k];
					int ty = t.y + dy[k];

					if (tx <= 0 || ty <= 0 || tx > N || ty > N)
						continue;
					add.add(new Tree(tx, ty, 1));
				}
			}
			tree.addAll(0, add);

			// 겨울
			for (int j = 1; j <= N; j++)
				for (int k = 1; k <= N; k++)
					land[j][k] += A[j][k];

		}
		System.out.println(tree.size());
	}

	static class Tree {
		int x;
		int y;
		int age;

		public Tree(int x, int y, int age) {
			this.x = x;
			this.y = y;
			this.age = age;
		}

		public void setAge(int age) {
			this.age = age;
		}

	}
}
